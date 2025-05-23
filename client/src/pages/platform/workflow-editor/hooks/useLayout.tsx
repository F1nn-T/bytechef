import {
    CONDITION_CASE_FALSE,
    CONDITION_CASE_TRUE,
    EDGE_STYLES,
    FINAL_PLACEHOLDER_NODE_ID,
    TASK_DISPATCHER_NAMES,
} from '@/shared/constants';
import defaultNodes from '@/shared/defaultNodes';
import {
    ComponentDefinitionBasic,
    TaskDispatcherDefinitionBasic,
    WorkflowTask,
} from '@/shared/middleware/platform/configuration';
import {NodeDataType} from '@/shared/types';
import {Edge, Node} from '@xyflow/react';
import {ComponentIcon} from 'lucide-react';
import {useEffect, useMemo} from 'react';
import {useShallow} from 'zustand/react/shallow';

import useWorkflowDataStore from '../stores/useWorkflowDataStore';
import createAllConditionEdges, {hasTaskInConditionBranches} from '../utils/createConditionEdges';
import createConditionNode from '../utils/createConditionNode';
import createLoopEdges from '../utils/createLoopEdges';
import createLoopNode from '../utils/createLoopNode';
import {
    convertTaskToNode,
    createEdgeFromTaskDispatcherBottomGhostNode,
    getLayoutedElements,
} from '../utils/layoutUtils';

export default function useLayout({
    canvasWidth,
    componentDefinitions,
    taskDispatcherDefinitions,
}: {
    componentDefinitions: Array<ComponentDefinitionBasic>;
    canvasWidth: number;
    taskDispatcherDefinitions: Array<TaskDispatcherDefinitionBasic>;
}) {
    const {
        workflow: {tasks, triggers},
    } = useWorkflowDataStore();

    const {setEdges, setNodes} = useWorkflowDataStore(
        useShallow((state) => ({
            setEdges: state.setEdges,
            setNodes: state.setNodes,
        }))
    );

    const triggerComponentName = useMemo(() => triggers?.[0]?.type.split('/')[0], [triggers]);

    const triggerDefinition = useMemo(
        () => componentDefinitions.find((definition) => definition.name === triggerComponentName),
        [componentDefinitions, triggerComponentName]
    );

    const triggerNode = useMemo(() => {
        if (triggerDefinition && triggers?.[0]) {
            return convertTaskToNode(triggers[0], triggerDefinition, 0);
        }

        return defaultNodes[0];
    }, [triggerDefinition, triggers]);

    let allNodes: Array<Node> = [triggerNode];

    const conditionChildTasks: {[key: string]: {caseTrue: string[]; caseFalse: string[]}} = {};
    const loopChildTasks: {[key: string]: {iteratee: string[]}} = {};

    if (tasks) {
        tasks.forEach((task) => {
            const {name, parameters} = task;

            const componentName = task.type.split('/')[0];

            if (!TASK_DISPATCHER_NAMES.includes(componentName)) {
                return;
            }

            if (componentName === 'condition' && parameters) {
                conditionChildTasks[name] = {
                    caseFalse: (parameters.caseFalse || []).map(
                        (caseFalseSubtask: WorkflowTask) => caseFalseSubtask.name
                    ),
                    caseTrue: (parameters.caseTrue || []).map((caseTrueSubtask: WorkflowTask) => caseTrueSubtask.name),
                };
            } else if (componentName === 'loop' && parameters?.iteratee) {
                loopChildTasks[name] = {
                    iteratee: parameters.iteratee.map((iteratee: WorkflowTask) => iteratee.name),
                };
            }
        });

        tasks.forEach((task) => {
            const {name, parameters, type} = task;
            const componentName = type.split('/')[0];
            const isTaskDispatcher = TASK_DISPATCHER_NAMES.includes(componentName);

            let taskNode: Node;
            let isNested = false;
            let nestingData = {};

            const taskDefinition = [...componentDefinitions, ...taskDispatcherDefinitions].find(
                (definition) => definition.name === componentName
            );

            // Convert task to node
            if (taskDefinition) {
                taskNode = convertTaskToNode(task, taskDefinition, 1);
            } else {
                taskNode = {
                    data: {
                        ...task,
                        componentName,
                        icon: <ComponentIcon className="size-9 flex-none text-gray-900" />,
                        operationName: type.split('/')[2],
                        taskDispatcher: isTaskDispatcher,
                        taskDispatcherId: isTaskDispatcher ? name : undefined,
                    },
                    id: name,
                    position: {x: 0, y: 0},
                    type: 'workflow',
                };
            }

            // Check for nesting in conditions
            for (const [conditionId, conditionCases] of Object.entries(conditionChildTasks)) {
                const conditionCasesList = [
                    {taskNames: conditionCases.caseTrue, value: CONDITION_CASE_TRUE},
                    {taskNames: conditionCases.caseFalse, value: CONDITION_CASE_FALSE},
                ];

                const matchingCase = conditionCasesList.find((conditionCase) => conditionCase.taskNames.includes(name));

                if (matchingCase) {
                    nestingData = {
                        conditionData: {
                            conditionCase: matchingCase.value,
                            conditionId,
                            index: matchingCase.taskNames.indexOf(name),
                        },
                    };

                    isNested = true;

                    break;
                }
            }

            // Only check for loop nesting if not already nested in a condition
            if (!isNested) {
                for (const [loopId, loopData] of Object.entries(loopChildTasks)) {
                    if (loopData.iteratee.includes(name)) {
                        nestingData = {
                            loopData: {
                                index: loopData.iteratee.indexOf(name),
                                loopId,
                            },
                        };

                        isNested = true;

                        break;
                    }
                }
            }

            // Apply nesting data if found
            if (isNested) {
                taskNode.data = {
                    ...taskNode.data,
                    ...nestingData,
                };
            }

            // Create auxiliary nodes for task dispatchers
            if (componentName === 'condition') {
                const hasTrueBranchTasks = parameters?.caseTrue?.length > 0;
                const hasFalseBranchTasks = parameters?.caseFalse?.length > 0;

                allNodes = createConditionNode({
                    allNodes: [...allNodes, taskNode],
                    conditionId: taskNode.id,
                    isNested,
                    options: {
                        createLeftPlaceholder: !hasTrueBranchTasks,
                        createRightPlaceholder: !hasFalseBranchTasks,
                    },
                });
            } else if (componentName === 'loop') {
                const hasSubtasks = parameters?.iteratee?.length > 0;

                allNodes = createLoopNode({
                    allNodes: [...allNodes, taskNode],
                    isNested,
                    loopId: taskNode.id,
                    options: {
                        createPlaceholder: !hasSubtasks,
                    },
                });
            } else {
                allNodes.push(taskNode);
            }
        });
    }

    const finalPlaceholderNode: Node = useMemo(() => {
        return {
            data: {label: '+'},
            id: FINAL_PLACEHOLDER_NODE_ID,
            position: {x: 0, y: 0},
            type: 'placeholder',
        };
    }, []);

    const taskEdges: Array<Edge> = [];

    // Create edges based on nodes
    allNodes.forEach((node, index) => {
        const nodeData: NodeDataType = node.data as NodeDataType;

        const isConditionNode = nodeData.componentName === 'condition';
        const isLoopNode = nodeData.componentName === 'loop';

        const isConditionPlaceholderNode = nodeData.conditionId && node.type === 'placeholder';

        const isConditionChildTask = nodeData.conditionData;

        const nextNode = allNodes[index + 1];

        if (isConditionNode) {
            const conditionEdges = createAllConditionEdges(node, allNodes);

            taskEdges.push(...conditionEdges);

            return;
        }

        // Create initial edges for the Loop node
        if (isLoopNode) {
            const loopEdges = createLoopEdges(node);

            taskEdges.push(...loopEdges);

            return;
        }

        if (nextNode && tasks) {
            const isNextNodeTaskDispatcherBottomNode = nextNode.type === 'taskDispatcherBottomGhostNode';

            const nextNodeData: NodeDataType = nextNode.data as NodeDataType;

            const isTaskDispatcherBottomGhostNode = node.type === 'taskDispatcherBottomGhostNode';

            if (isTaskDispatcherBottomGhostNode) {
                const edge = createEdgeFromTaskDispatcherBottomGhostNode({allNodes, index, node, tasks});

                if (edge) {
                    taskEdges.push(edge);

                    if (
                        edge.target === FINAL_PLACEHOLDER_NODE_ID &&
                        !allNodes.some((node) => node.id === FINAL_PLACEHOLDER_NODE_ID)
                    ) {
                        allNodes.push(finalPlaceholderNode);
                    }
                }

                return;
            }

            if (isConditionChildTask || node.id.includes('condition-')) {
                const conditionId = isConditionChildTask ? nodeData.conditionData?.conditionId : node.id.split('-')[0];

                if (conditionId) {
                    const isNextNodeInSameCondition =
                        nextNodeData.conditionData?.conditionId === conditionId ||
                        hasTaskInConditionBranches(conditionId, nextNode.id, tasks);

                    const isOwnBottomGhost =
                        isNextNodeTaskDispatcherBottomNode && nextNode.id === `${conditionId}-condition-bottom-ghost`;

                    const isInDifferentBranches =
                        nodeData.conditionData &&
                        nextNodeData.conditionData &&
                        nodeData.conditionData.conditionCase !== nextNodeData.conditionData.conditionCase;

                    if (isInDifferentBranches || (!isNextNodeInSameCondition && !isOwnBottomGhost)) {
                        return;
                    }
                }
            }

            if (isConditionPlaceholderNode) {
                return;
            }

            let edgeToNextNode: Edge = {
                id: `${node.id}=>${nextNode.id}`,
                source: node.id,
                style: EDGE_STYLES,
                target: nextNode.id,
                type: node.id.includes('placeholder') ? 'smoothstep' : 'workflow',
            };

            if (isNextNodeTaskDispatcherBottomNode) {
                edgeToNextNode = {
                    ...edgeToNextNode,
                    targetHandle: `${nextNode.id}-bottom-ghost-right`,
                };
            }

            if (!taskEdges.find((edge) => edge.source === node.id)) {
                taskEdges.push(edgeToNextNode);
            }
        } else {
            allNodes.push(finalPlaceholderNode);

            taskEdges.push({
                id: `${node.id}=>${FINAL_PLACEHOLDER_NODE_ID}`,
                source: node.id,
                target: FINAL_PLACEHOLDER_NODE_ID,
                type: 'placeholder',
            });
        }
    });

    useEffect(() => {
        const layoutNodes = allNodes;
        const edges: Edge[] = taskEdges;

        const elements = getLayoutedElements(layoutNodes, edges, canvasWidth);

        setNodes(elements.nodes);
        setEdges(elements.edges);

        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [canvasWidth, tasks, triggers]);
}
