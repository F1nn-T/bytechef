import {Button} from '@/components/ui/button';
import {HoverCardContent, HoverCardTrigger} from '@/components/ui/hover-card';
import WorkflowNodesPopoverMenu from '@/pages/platform/workflow-editor/components/WorkflowNodesPopoverMenu';
import {useWorkflowMutation} from '@/pages/platform/workflow-editor/providers/workflowMutationProvider';
import {useGetWorkflowNodeDescriptionQuery} from '@/shared/queries/platform/workflowNodeDescriptions.queries';
import {NodeDataType} from '@/shared/types';
import {HoverCard, HoverCardPortal} from '@radix-ui/react-hover-card';
import {useQueryClient} from '@tanstack/react-query';
import {Handle, Position} from '@xyflow/react';
import {PencilIcon, TrashIcon} from 'lucide-react';
import {memo, useState} from 'react';
import {useParams} from 'react-router-dom';
import sanitize from 'sanitize-html';
import {twMerge} from 'tailwind-merge';

import useNodeClickHandler from '../hooks/useNodeClick';
import useWorkflowDataStore from '../stores/useWorkflowDataStore';
import useWorkflowNodeDetailsPanelStore from '../stores/useWorkflowNodeDetailsPanelStore';
import handleDeleteTask from '../utils/handleDeleteTask';
import styles from './NodeTypes.module.css';

const WorkflowNode = ({data, id}: {data: NodeDataType; id: string}) => {
    const [isHovered, setIsHovered] = useState(false);
    const [hoveredNodeName, setHoveredNodeName] = useState<string | undefined>();

    const {currentNode, workflowNodeDetailsPanelOpen} = useWorkflowNodeDetailsPanelStore();
    const {workflow} = useWorkflowDataStore();

    const handleNodeClick = useNodeClickHandler(data, id);

    const isSelected = currentNode?.name === data.name;

    const {data: workflowNodeDescription} = useGetWorkflowNodeDescriptionQuery(
        {
            id: workflow.id!,
            workflowNodeName: hoveredNodeName!,
        },
        hoveredNodeName !== undefined
    );

    const queryClient = useQueryClient();

    const {updateWorkflowMutation} = useWorkflowMutation();

    const {projectId} = useParams();

    const handleDeleteNodeClick = (data: NodeDataType) => {
        if (data) {
            handleDeleteTask({
                currentNode,
                data,
                projectId: +projectId!,
                queryClient,
                updateWorkflowMutation,
                workflow,
            });
        }
    };

    return (
        <div
            className={twMerge(
                'nodrag relative flex min-w-60 cursor-pointer justify-center',
                !data.taskDispatcher && 'items-center'
            )}
            data-nodetype={data.trigger ? 'trigger' : 'task'}
            key={id}
            onMouseOut={() => setIsHovered(false)}
            onMouseOver={() => setIsHovered(true)}
        >
            {isHovered && (
                <div className="absolute left-workflow-node-popover-hover pr-4">
                    {data.trigger ? (
                        <WorkflowNodesPopoverMenu hideActionComponents hideTaskDispatchers sourceNodeId={id}>
                            <Button
                                className="bg-white p-2 shadow-md hover:text-blue-500 hover:shadow-sm"
                                title="Change trigger component"
                                variant="outline"
                            >
                                <PencilIcon className="size-4" />
                            </Button>
                        </WorkflowNodesPopoverMenu>
                    ) : (
                        <Button
                            className="bg-white p-2 shadow-md hover:text-red-500 hover:shadow-sm"
                            onClick={() => handleDeleteNodeClick(data)}
                            title="Delete a node"
                            variant="outline"
                        >
                            <TrashIcon className="size-4" />
                        </Button>
                    )}
                </div>
            )}

            <HoverCard
                key={id}
                onOpenChange={(open) => {
                    if (open) {
                        setHoveredNodeName(data.name);
                    } else {
                        setHoveredNodeName(undefined);
                    }
                }}
            >
                <HoverCardTrigger>
                    <Button
                        className={twMerge(
                            'size-18 rounded-md border-2 border-gray-300 bg-white p-4 shadow hover:border-blue-200 hover:bg-blue-200 hover:shadow-none [&_svg]:size-9',
                            isSelected && workflowNodeDetailsPanelOpen && 'border-blue-300 bg-blue-100 shadow-none'
                        )}
                        onClick={handleNodeClick}
                    >
                        {data.icon}
                    </Button>
                </HoverCardTrigger>

                <HoverCardPortal>
                    <HoverCardContent className="w-fit min-w-72 max-w-xl text-sm" side="right">
                        {workflowNodeDescription?.description && (
                            <div
                                className="flex"
                                dangerouslySetInnerHTML={{
                                    __html: sanitize(workflowNodeDescription.description, {
                                        allowedAttributes: {
                                            div: ['class'],
                                            table: ['class'],
                                            td: ['class'],
                                            tr: ['class'],
                                        },
                                    }),
                                }}
                            />
                        )}
                    </HoverCardContent>
                </HoverCardPortal>
            </HoverCard>

            <div className="ml-2 flex w-full min-w-max flex-col items-start">
                <span className="font-semibold">{data.title || data.label}</span>

                {data.operationName && <pre className="text-sm">{data.operationName}</pre>}

                <span className="text-sm text-gray-500">{data.workflowNodeName}</span>
            </div>

            <Handle
                className={twMerge('left-node-handle-placement', styles.handle)}
                isConnectable={false}
                position={Position.Top}
                type="target"
            />

            <Handle
                className={twMerge('left-node-handle-placement', styles.handle)}
                isConnectable={false}
                position={Position.Bottom}
                type="source"
            />

            {data.name.includes('condition') && (
                <div className="absolute bottom-0 left-0 font-bold text-muted-foreground">
                    <span className="absolute -bottom-10 -left-16">TRUE</span>

                    <span className="absolute -bottom-10 left-24">FALSE</span>
                </div>
            )}
        </div>
    );
};

export default memo(WorkflowNode);
