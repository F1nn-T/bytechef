/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Workflow Test API
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
 * The source/destination data stream component.
 * @export
 * @interface DataStreamComponentModel
 */
export interface DataStreamComponentModel {
    /**
     * The name of a component.
     * @type {string}
     * @memberof DataStreamComponentModel
     */
    componentName?: string;
    /**
     * The version of a component.
     * @type {number}
     * @memberof DataStreamComponentModel
     */
    componentVersion?: number;
}

/**
 * Check if a given object implements the DataStreamComponentModel interface.
 */
export function instanceOfDataStreamComponentModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function DataStreamComponentModelFromJSON(json: any): DataStreamComponentModel {
    return DataStreamComponentModelFromJSONTyped(json, false);
}

export function DataStreamComponentModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): DataStreamComponentModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'componentName': !exists(json, 'componentName') ? undefined : json['componentName'],
        'componentVersion': !exists(json, 'componentVersion') ? undefined : json['componentVersion'],
    };
}

export function DataStreamComponentModelToJSON(value?: DataStreamComponentModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'componentName': value.componentName,
        'componentVersion': value.componentVersion,
    };
}

