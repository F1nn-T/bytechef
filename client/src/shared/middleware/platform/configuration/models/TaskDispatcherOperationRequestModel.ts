/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration API
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
/**
 * 
 * @export
 * @interface TaskDispatcherOperationRequestModel
 */
export interface TaskDispatcherOperationRequestModel {
    /**
     * The parameters of an action.
     * @type {{ [key: string]: any; }}
     * @memberof TaskDispatcherOperationRequestModel
     */
    parameters: { [key: string]: any; };
}

/**
 * Check if a given object implements the TaskDispatcherOperationRequestModel interface.
 */
export function instanceOfTaskDispatcherOperationRequestModel(value: object): boolean {
    if (!('parameters' in value)) return false;
    return true;
}

export function TaskDispatcherOperationRequestModelFromJSON(json: any): TaskDispatcherOperationRequestModel {
    return TaskDispatcherOperationRequestModelFromJSONTyped(json, false);
}

export function TaskDispatcherOperationRequestModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): TaskDispatcherOperationRequestModel {
    if (json == null) {
        return json;
    }
    return {
        
        'parameters': json['parameters'],
    };
}

export function TaskDispatcherOperationRequestModelToJSON(value?: TaskDispatcherOperationRequestModel | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'parameters': value['parameters'],
    };
}
