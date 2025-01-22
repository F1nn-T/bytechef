/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration Internal API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
import type { ComponentConnection } from './ComponentConnection';
import {
    ComponentConnectionFromJSON,
    ComponentConnectionFromJSONTyped,
    ComponentConnectionToJSON,
    ComponentConnectionToJSONTyped,
} from './ComponentConnection';

/**
 * Represents a definition of a workflow trigger.
 * @export
 * @interface WorkflowTrigger
 */
export interface WorkflowTrigger {
    /**
     * 
     * @type {Array<ComponentConnection>}
     * @memberof WorkflowTrigger
     */
    readonly connections?: Array<ComponentConnection>;
    /**
     * The description of the task.
     * @type {string}
     * @memberof WorkflowTrigger
     */
    description?: string;
    /**
     * The human-readable description of the task.
     * @type {string}
     * @memberof WorkflowTrigger
     */
    label?: string;
    /**
     * Key-value map of metadata.
     * @type {{ [key: string]: any; }}
     * @memberof WorkflowTrigger
     */
    metadata?: { [key: string]: any; };
    /**
     * The identifier name of the task. Task names are used for assigning the output of one task so it can be later used by subsequent tasks.
     * @type {string}
     * @memberof WorkflowTrigger
     */
    name: string;
    /**
     * Key-value map of task parameters.
     * @type {{ [key: string]: any; }}
     * @memberof WorkflowTrigger
     */
    parameters?: { [key: string]: any; };
    /**
     * The timeout expression which describes when a trigger should be deemed as timed-out.
     * @type {string}
     * @memberof WorkflowTrigger
     */
    timeout?: string;
    /**
     * The type of the trigger.
     * @type {string}
     * @memberof WorkflowTrigger
     */
    type: string;
}

/**
 * Check if a given object implements the WorkflowTrigger interface.
 */
export function instanceOfWorkflowTrigger(value: object): value is WorkflowTrigger {
    if (!('name' in value) || value['name'] === undefined) return false;
    if (!('type' in value) || value['type'] === undefined) return false;
    return true;
}

export function WorkflowTriggerFromJSON(json: any): WorkflowTrigger {
    return WorkflowTriggerFromJSONTyped(json, false);
}

export function WorkflowTriggerFromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowTrigger {
    if (json == null) {
        return json;
    }
    return {
        
        'connections': json['connections'] == null ? undefined : ((json['connections'] as Array<any>).map(ComponentConnectionFromJSON)),
        'description': json['description'] == null ? undefined : json['description'],
        'label': json['label'] == null ? undefined : json['label'],
        'metadata': json['metadata'] == null ? undefined : json['metadata'],
        'name': json['name'],
        'parameters': json['parameters'] == null ? undefined : json['parameters'],
        'timeout': json['timeout'] == null ? undefined : json['timeout'],
        'type': json['type'],
    };
}

export function WorkflowTriggerToJSON(json: any): WorkflowTrigger {
    return WorkflowTriggerToJSONTyped(json, false);
}

export function WorkflowTriggerToJSONTyped(value?: Omit<WorkflowTrigger, 'connections'> | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'description': value['description'],
        'label': value['label'],
        'metadata': value['metadata'],
        'name': value['name'],
        'parameters': value['parameters'],
        'timeout': value['timeout'],
        'type': value['type'],
    };
}

