/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Execution API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * The blueprint that describe the execution of a job.
 * @export
 * @interface WorkflowBasicModel
 */
export interface WorkflowBasicModel {
    /**
     * The created by.
     * @type {string}
     * @memberof WorkflowBasicModel
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof WorkflowBasicModel
     */
    readonly createdDate?: Date;
    /**
     * The number of workflow connections
     * @type {number}
     * @memberof WorkflowBasicModel
     */
    readonly connectionsCount?: number;
    /**
     * The description of a workflow.
     * @type {string}
     * @memberof WorkflowBasicModel
     */
    description?: string;
    /**
     * The id of the workflow.
     * @type {string}
     * @memberof WorkflowBasicModel
     */
    readonly id?: string;
    /**
     * The number of workflow inputs
     * @type {number}
     * @memberof WorkflowBasicModel
     */
    readonly inputsCount?: number;
    /**
     * The descriptive name for the workflow
     * @type {string}
     * @memberof WorkflowBasicModel
     */
    readonly label?: string;
    /**
     * The last modified by.
     * @type {string}
     * @memberof WorkflowBasicModel
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof WorkflowBasicModel
     */
    readonly lastModifiedDate?: Date;
    /**
     * Does this workflow have a manual trigger or not
     * @type {boolean}
     * @memberof WorkflowBasicModel
     */
    readonly manualTrigger?: boolean;
    /**
     * 
     * @type {Array<string>}
     * @memberof WorkflowBasicModel
     */
    readonly workflowTaskComponentNames?: Array<string>;
    /**
     * 
     * @type {Array<string>}
     * @memberof WorkflowBasicModel
     */
    readonly workflowTriggerComponentNames?: Array<string>;
    /**
     * 
     * @type {number}
     * @memberof WorkflowBasicModel
     */
    version?: number;
}

/**
 * Check if a given object implements the WorkflowBasicModel interface.
 */
export function instanceOfWorkflowBasicModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function WorkflowBasicModelFromJSON(json: any): WorkflowBasicModel {
    return WorkflowBasicModelFromJSONTyped(json, false);
}

export function WorkflowBasicModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowBasicModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'createdBy': !exists(json, 'createdBy') ? undefined : json['createdBy'],
        'createdDate': !exists(json, 'createdDate') ? undefined : (new Date(json['createdDate'])),
        'connectionsCount': !exists(json, 'connectionsCount') ? undefined : json['connectionsCount'],
        'description': !exists(json, 'description') ? undefined : json['description'],
        'id': !exists(json, 'id') ? undefined : json['id'],
        'inputsCount': !exists(json, 'inputsCount') ? undefined : json['inputsCount'],
        'label': !exists(json, 'label') ? undefined : json['label'],
        'lastModifiedBy': !exists(json, 'lastModifiedBy') ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': !exists(json, 'lastModifiedDate') ? undefined : (new Date(json['lastModifiedDate'])),
        'manualTrigger': !exists(json, 'manualTrigger') ? undefined : json['manualTrigger'],
        'workflowTaskComponentNames': !exists(json, 'workflowTaskComponentNames') ? undefined : json['workflowTaskComponentNames'],
        'workflowTriggerComponentNames': !exists(json, 'workflowTriggerComponentNames') ? undefined : json['workflowTriggerComponentNames'],
        'version': !exists(json, '__version') ? undefined : json['__version'],
    };
}

export function WorkflowBasicModelToJSON(value?: WorkflowBasicModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'description': value.description,
        '__version': value.version,
    };
}

