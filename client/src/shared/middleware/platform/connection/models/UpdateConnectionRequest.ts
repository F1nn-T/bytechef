/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Connection Internal API
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
import type { Tag } from './Tag';
import {
    TagFromJSON,
    TagFromJSONTyped,
    TagToJSON,
    TagToJSONTyped,
} from './Tag';

/**
 * Contains all connection parameters that can be updated.
 * @export
 * @interface UpdateConnectionRequest
 */
export interface UpdateConnectionRequest {
    /**
     * The name of a connection.
     * @type {string}
     * @memberof UpdateConnectionRequest
     */
    name: string;
    /**
     * 
     * @type {Array<Tag>}
     * @memberof UpdateConnectionRequest
     */
    tags: Array<Tag>;
    /**
     * 
     * @type {number}
     * @memberof UpdateConnectionRequest
     */
    version?: number;
}

/**
 * Check if a given object implements the UpdateConnectionRequest interface.
 */
export function instanceOfUpdateConnectionRequest(value: object): value is UpdateConnectionRequest {
    if (!('name' in value) || value['name'] === undefined) return false;
    if (!('tags' in value) || value['tags'] === undefined) return false;
    return true;
}

export function UpdateConnectionRequestFromJSON(json: any): UpdateConnectionRequest {
    return UpdateConnectionRequestFromJSONTyped(json, false);
}

export function UpdateConnectionRequestFromJSONTyped(json: any, ignoreDiscriminator: boolean): UpdateConnectionRequest {
    if (json == null) {
        return json;
    }
    return {
        
        'name': json['name'],
        'tags': ((json['tags'] as Array<any>).map(TagFromJSON)),
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function UpdateConnectionRequestToJSON(json: any): UpdateConnectionRequest {
    return UpdateConnectionRequestToJSONTyped(json, false);
}

export function UpdateConnectionRequestToJSONTyped(value?: UpdateConnectionRequest | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'name': value['name'],
        'tags': ((value['tags'] as Array<any>).map(TagToJSON)),
        '__version': value['version'],
    };
}

