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
import type { ControlType } from './ControlType';
import {
    ControlTypeFromJSON,
    ControlTypeFromJSONTyped,
    ControlTypeToJSON,
    ControlTypeToJSONTyped,
} from './ControlType';
import type { PropertyType } from './PropertyType';
import {
    PropertyTypeFromJSON,
    PropertyTypeFromJSONTyped,
    PropertyTypeToJSON,
    PropertyTypeToJSONTyped,
} from './PropertyType';
import type { ValueProperty } from './ValueProperty';
import {
    ValuePropertyFromJSON,
    ValuePropertyFromJSONTyped,
    ValuePropertyToJSON,
    ValuePropertyToJSONTyped,
} from './ValueProperty';

/**
 * A null property type.
 * @export
 * @interface NullProperty
 */
export interface NullProperty extends ValueProperty {
}



/**
 * Check if a given object implements the NullProperty interface.
 */
export function instanceOfNullProperty(value: object): value is NullProperty {
    return true;
}

export function NullPropertyFromJSON(json: any): NullProperty {
    return NullPropertyFromJSONTyped(json, false);
}

export function NullPropertyFromJSONTyped(json: any, ignoreDiscriminator: boolean): NullProperty {
    return json;
}

export function NullPropertyToJSON(json: any): NullProperty {
    return NullPropertyToJSONTyped(json, false);
}

export function NullPropertyToJSONTyped(value?: NullProperty | null, ignoreDiscriminator: boolean = false): any {
    return value;
}

