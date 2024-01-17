/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Configuration API
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
 * 
 * @export
 * @interface WorkflowConnectionModel
 */
export interface WorkflowConnectionModel {
    /**
     * 
     * @type {string}
     * @memberof WorkflowConnectionModel
     */
    componentName: string;
    /**
     * 
     * @type {number}
     * @memberof WorkflowConnectionModel
     */
    componentVersion: number;
    /**
     * 
     * @type {number}
     * @memberof WorkflowConnectionModel
     */
    id?: number;
    /**
     * 
     * @type {string}
     * @memberof WorkflowConnectionModel
     */
    key: string;
    /**
     * 
     * @type {string}
     * @memberof WorkflowConnectionModel
     */
    operationName: string;
    /**
     * 
     * @type {boolean}
     * @memberof WorkflowConnectionModel
     */
    required: boolean;
}

/**
 * Check if a given object implements the WorkflowConnectionModel interface.
 */
export function instanceOfWorkflowConnectionModel(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "componentName" in value;
    isInstance = isInstance && "componentVersion" in value;
    isInstance = isInstance && "key" in value;
    isInstance = isInstance && "operationName" in value;
    isInstance = isInstance && "required" in value;

    return isInstance;
}

export function WorkflowConnectionModelFromJSON(json: any): WorkflowConnectionModel {
    return WorkflowConnectionModelFromJSONTyped(json, false);
}

export function WorkflowConnectionModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowConnectionModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'componentName': json['componentName'],
        'componentVersion': json['componentVersion'],
        'id': !exists(json, 'id') ? undefined : json['id'],
        'key': json['key'],
        'operationName': json['operationName'],
        'required': json['required'],
    };
}

export function WorkflowConnectionModelToJSON(value?: WorkflowConnectionModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'componentName': value.componentName,
        'componentVersion': value.componentVersion,
        'id': value.id,
        'key': value.key,
        'operationName': value.operationName,
        'required': value.required,
    };
}
