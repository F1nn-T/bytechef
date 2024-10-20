import defaultNodes from '@/shared/defaultNodes';
import {WorkflowTask} from '@/shared/middleware/automation/configuration';
import {ComponentDefinitionBasic, TaskDispatcherDefinitionBasic} from '@/shared/middleware/platform/configuration';
import {getRandomId} from '@/shared/util/random-utils';
import Dagre from '@dagrejs/dagre';
import {ComponentIcon} from 'lucide-react';
import {useEffect} from 'react';
import InlineSVG from 'react-inlinesvg';
import {Edge, Node, ReactFlowState, useReactFlow, useStore} from 'reactflow';

import useWorkflowDataStore from '../stores/useWorkflowDataStore';
import getNextPlaceholderId from '../utils/getNextPlaceholderId';

const NODE_WIDTH = 200;
const NODE_HEIGHT = 150;
const DIRECTION = 'TB';
const FINAL_PLACEHOLDER_NODE_ID = getRandomId();

const TASK_DISPATCHER_NAMES = [
    'branch',
    'condition',
    'each',
    'fork-join',
    'loop',
    'loop-break',
    'map',
    'parallel',
    'subflow',
];

const nodeCountSelector = (state: ReactFlowState) => state.nodeInternals.size;

const convertTaskToNode = (
    task: WorkflowTask,
    taskDefinition: ComponentDefinitionBasic | TaskDispatcherDefinitionBasic,
    index: number
): Node => {
    const componentName = task.type.split('/')[0];

    return {
        data: {
            ...task,
            componentName,
            icon: (
                <InlineSVG
                    className="size-9"
                    loader={<ComponentIcon className="size-9 flex-none text-gray-900" />}
                    src={taskDefinition.icon!}
                />
            ),
            operationName: task.type.split('/')[2],
            taskDispatcher: TASK_DISPATCHER_NAMES.includes(componentName),
            trigger: index === 0,
            workflowNodeName: task.name,
        },
        id: task.name,
        position: {x: 0, y: 0},
        type: 'workflow',
    };
};

export default function useLayout({
    componentDefinitions,
    taskDispatcherDefinitions,
}: {
    componentDefinitions: Array<ComponentDefinitionBasic>;
    taskDispatcherDefinitions: Array<TaskDispatcherDefinitionBasic>;
}) {
    const nodeCount = useStore(nodeCountSelector);

    const {fitView, getEdges, getNodes, setEdges, setNodes} = useReactFlow();

    const {
        workflow: {tasks, triggers},
    } = useWorkflowDataStore();

    const triggerComponentName = triggers?.[0]?.type.split('/')[0];

    const triggerDefinition = componentDefinitions.find((definition) => definition.name === triggerComponentName);

    const triggerNode =
        triggerDefinition && triggers?.[0] ? convertTaskToNode(triggers[0], triggerDefinition, 0) : defaultNodes[0];

    let taskNodes: Array<Node> = [];

    if (tasks) {
        taskNodes = tasks?.map((task, index) => {
            const componentName = task.type.split('/')[0];

            const combinedDefinitions = [...componentDefinitions, ...taskDispatcherDefinitions];

            const taskDefinition = combinedDefinitions.find((definition) => definition.name === componentName);

            if (taskDefinition) {
                return convertTaskToNode(task, taskDefinition, index + 1);
            } else {
                return {
                    data: {
                        ...task,
                        componentName,
                        icon: <ComponentIcon className="size-9 flex-none text-gray-900" />,
                        operationName: task.type.split('/')[2],
                        taskDispatcher: TASK_DISPATCHER_NAMES.includes(componentName),
                        trigger: index === 0,
                    },
                    id: task.name,
                    position: {x: 0, y: 0},
                    type: 'workflow',
                };
            }
        });
    }

    const allNodes: Array<Node> = [];

    taskNodes.forEach((taskNode) => {
        if (!taskNode.data.metadata?.ui?.condition) {
            allNodes.push(taskNode);
        }

        // Create left, right, and bottom placeholder nodes when the task node is a Condition
        if (taskNode.data.componentName === 'condition') {
            const leftPlaceholderNode: Node = {
                data: {label: '+', metadata: {ui: {condition: `${taskNode.id}-left-placeholder-0`}}},
                id: `${taskNode.id}-left-placeholder-0`,
                position: {x: 0, y: 0},
                type: 'placeholder',
            };

            const rightPlaceholderNode: Node = {
                data: {label: '+', metadata: {ui: {condition: `${taskNode.id}-right-placeholder-0`}}},
                id: `${taskNode.id}-right-placeholder-0`,
                position: {x: 0, y: 0},
                type: 'placeholder',
            };

            const bottomPlaceholderNode: Node = {
                data: {label: '+'},
                id: `${taskNode.id}-bottom-placeholder`,
                position: {x: 0, y: 0},
                type: 'placeholder',
            };

            allNodes.push(leftPlaceholderNode, rightPlaceholderNode, bottomPlaceholderNode);
        }

        // Handle placeholder nodes above and below the task node inside the Condition
        if (taskNode.data.metadata?.ui?.condition) {
            const sourcePlaceholderIndex = allNodes.findIndex(
                (node) => node.id === taskNode.data.metadata.ui.condition
            );

            if (sourcePlaceholderIndex === -1) {
                return;
            }

            const sourcePlaceholderNode = allNodes[sourcePlaceholderIndex];

            const belowPlaceholderNodeId = getNextPlaceholderId(sourcePlaceholderNode.id);

            const belowPlaceholderNode: Node = {
                data: {label: '+', metadata: {ui: {condition: belowPlaceholderNodeId}}},
                id: belowPlaceholderNodeId,
                position: {x: 0, y: 0},
                type: 'placeholder',
            };

            allNodes.splice(sourcePlaceholderIndex + 1, 0, taskNode, belowPlaceholderNode);
        }
    });

    taskNodes = allNodes;

    const triggerAndTaskNodes: Array<Node> = [triggerNode, ...(taskNodes?.length ? taskNodes : [])];

    const finalPlaceholderNode: Node = {
        data: {label: '+'},
        id: FINAL_PLACEHOLDER_NODE_ID,
        position: {x: 0, y: 0},
        type: 'placeholder',
    };

    const taskEdges: Array<Edge> = [];

    // Create edges based on nodes
    triggerAndTaskNodes.forEach((taskNode, index) => {
        const nextNode = triggerAndTaskNodes[index + 1];

        // Create initial edges for the Condition node
        if (taskNode.data.componentName === 'condition') {
            const leftPlaceholderEdge = {
                id: `${taskNode.id}=>${taskNode.id}-left-placeholder-0`,
                source: taskNode.id,
                target: `${taskNode.id}-left-placeholder-0`,
                type: 'smoothstep',
            };

            const rightPlaceholderEdge = {
                id: `${taskNode.id}=>${taskNode.id}-right-placeholder-0`,
                source: taskNode.id,
                target: `${taskNode.id}-right-placeholder-0`,
                type: 'smoothstep',
            };

            taskEdges.push(leftPlaceholderEdge, rightPlaceholderEdge);

            return;
        }

        // Create the bottom Condition edge
        if (taskNode.id.includes('placeholder') && !taskNode.id.includes('bottom')) {
            const parentConditionTaskId = taskNode.id.split('-')[0];

            taskEdges.push({
                id: `${taskNode.id}=>${parentConditionTaskId}-bottom-placeholder`,
                source: taskNode.id,
                target: `${parentConditionTaskId}-bottom-placeholder`,
                type: 'smoothstep',
            });

            return;
        }

        // Create edges for the Condition child node
        if (taskNode.data.metadata?.ui?.condition && !taskNode.id.includes('placeholder')) {
            const sourcePlaceholderId = taskNode.data.metadata.ui.condition;

            const targetPlaceholderId = getNextPlaceholderId(sourcePlaceholderId);
            const edgeFromSourceNodeToTaskNode = {
                id: `${sourcePlaceholderId}=>${taskNode.id}`,
                source: `${sourcePlaceholderId}`,
                target: taskNode.id,
                type: 'smoothstep',
            };

            const edgeFromTaskNodeToTargetNode = {
                id: `${taskNode.id}=>${targetPlaceholderId}`,
                source: taskNode.id,
                target: `${targetPlaceholderId}`,
                type: 'smoothstep',
            };

            taskEdges.pop();

            taskEdges.push(edgeFromSourceNodeToTaskNode, edgeFromTaskNodeToTargetNode);

            return;
        }

        if (nextNode) {
            taskEdges.push({
                id: `${taskNode.id}=>${nextNode.id}`,
                source: taskNode.id,
                target: nextNode.id,
                type: taskNode.id.includes('placeholder') ? 'smoothstep' : 'workflow',
            });
        } else {
            triggerAndTaskNodes.push(finalPlaceholderNode);

            taskEdges.push({
                id: `${taskNode.id}=>${FINAL_PLACEHOLDER_NODE_ID}`,
                source: taskNode.id,
                target: FINAL_PLACEHOLDER_NODE_ID,
                type: 'placeholder',
            });
        }
    });

    useEffect(() => {
        const dagreGraph = new Dagre.graphlib.Graph().setDefaultEdgeLabel(() => ({}));

        dagreGraph.setGraph({rankdir: DIRECTION});

        let nodes: Node[] = getNodes();
        let edges: Edge[] = getEdges();

        if (triggerAndTaskNodes.length) {
            nodes = taskNodes?.length ? [...triggerAndTaskNodes] : [triggerNode, finalPlaceholderNode];
        }

        edges = taskEdges;

        nodes.forEach((node) => {
            dagreGraph.setNode(node.id, {height: NODE_HEIGHT, width: NODE_WIDTH});
        });

        edges.forEach((edge) => {
            dagreGraph.setEdge(edge.source, edge.target);
        });

        Dagre.layout(dagreGraph);

        nodes = nodes.map((node) => {
            const position = dagreGraph.node(node.id);

            return {...node, position};
        });

        setNodes(nodes);
        setEdges(edges);

        window.requestAnimationFrame(() => {
            fitView();
        });
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [finalPlaceholderNode, nodeCount, setEdges, setNodes, taskEdges, taskNodes]);
}
