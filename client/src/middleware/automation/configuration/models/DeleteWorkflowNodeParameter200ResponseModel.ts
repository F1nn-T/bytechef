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

import { mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface DeleteWorkflowNodeParameter200ResponseModel
 */
export interface DeleteWorkflowNodeParameter200ResponseModel {
    /**
     * 
     * @type {{ [key: string]: any; }}
     * @memberof DeleteWorkflowNodeParameter200ResponseModel
     */
    parameters?: { [key: string]: any; };
}

/**
 * Check if a given object implements the DeleteWorkflowNodeParameter200ResponseModel interface.
 */
export function instanceOfDeleteWorkflowNodeParameter200ResponseModel(value: object): boolean {
    return true;
}

export function DeleteWorkflowNodeParameter200ResponseModelFromJSON(json: any): DeleteWorkflowNodeParameter200ResponseModel {
    return DeleteWorkflowNodeParameter200ResponseModelFromJSONTyped(json, false);
}

export function DeleteWorkflowNodeParameter200ResponseModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): DeleteWorkflowNodeParameter200ResponseModel {
    if (json == null) {
        return json;
    }
    return {
        
        'parameters': json['parameters'] == null ? undefined : json['parameters'],
    };
}

export function DeleteWorkflowNodeParameter200ResponseModelToJSON(value?: DeleteWorkflowNodeParameter200ResponseModel | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'parameters': value['parameters'],
    };
}
