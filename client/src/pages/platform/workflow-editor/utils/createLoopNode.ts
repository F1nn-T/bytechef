import {DEFAULT_NODE_POSITION} from '@/shared/constants';
import {Node} from '@xyflow/react';

type LoopNodeOptionsType = {
    createPlaceholder?: boolean;
    createLeftGhost?: boolean;
};

type CreateLoopNodePropsType = {
    allNodes: Array<Node>;
    loopId: string;
    isNested?: boolean;
    options?: LoopNodeOptionsType;
};

/**
 * Creates a placeholder node for a loop
 */
function createPlaceholderNode(loopId: string): Node {
    return {
        data: {
            label: '+',
            loopId,
            taskDispatcherId: loopId,
        },
        id: `${loopId}-loop-placeholder-0`,
        position: DEFAULT_NODE_POSITION,
        type: 'placeholder',
    };
}

/**
 * Creates a top ghost node for a loop
 */
function createTopGhostNode(loopId: string): Node {
    return {
        data: {
            taskDispatcherId: loopId,
        },
        id: `${loopId}-loop-top-ghost`,
        position: DEFAULT_NODE_POSITION,
        type: 'taskDispatcherTopGhostNode',
    };
}

/**
 * Creates a left ghost node for a loop
 */
function createLeftGhostNode(loopId: string): Node {
    return {
        data: {
            taskDispatcherId: loopId,
        },
        id: `${loopId}-loop-left-ghost`,
        position: DEFAULT_NODE_POSITION,
        type: 'loopLeftGhostNode',
    };
}

/**
 * Creates a bottom ghost node for a loop
 */
function createBottomGhostNode(loopId: string, isNested: boolean = false): Node {
    return {
        data: {
            isNestedBottomGhost: isNested,
            taskDispatcherId: loopId,
        },
        id: `${loopId}-loop-bottom-ghost`,
        position: DEFAULT_NODE_POSITION,
        type: 'taskDispatcherBottomGhostNode',
    };
}

/**
 * Creates all necessary auxiliary nodes for a loop task node
 */
export default function createLoopNode({
    allNodes,
    isNested = false,
    loopId,
    options = {
        createPlaceholder: true,
    },
}: CreateLoopNodePropsType): Node[] {
    const nodesWithLoop = [...allNodes];
    const insertIndex = nodesWithLoop.findIndex((node) => node.id === loopId) + 1;
    const nodesToAdd = [];

    nodesToAdd.push(createTopGhostNode(loopId));
    nodesToAdd.push(createLeftGhostNode(loopId));

    if (options.createPlaceholder) {
        nodesToAdd.push(createPlaceholderNode(loopId));
    }

    nodesToAdd.push(createBottomGhostNode(loopId, isNested));

    nodesWithLoop.splice(insertIndex, 0, ...nodesToAdd);

    return nodesWithLoop;
}
