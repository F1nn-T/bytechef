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
/**
 * The help text that is meant to guide your users as to how to configure this action or trigger.
 * @export
 * @interface Help
 */
export interface Help {
    /**
     * The help text
     * @type {string}
     * @memberof Help
     */
    body: string;
    /**
     * The url to additional documentation
     * @type {string}
     * @memberof Help
     */
    learnMoreUrl?: string;
}

/**
 * Check if a given object implements the Help interface.
 */
export function instanceOfHelp(value: object): value is Help {
    if (!('body' in value) || value['body'] === undefined) return false;
    return true;
}

export function HelpFromJSON(json: any): Help {
    return HelpFromJSONTyped(json, false);
}

export function HelpFromJSONTyped(json: any, ignoreDiscriminator: boolean): Help {
    if (json == null) {
        return json;
    }
    return {
        
        'body': json['body'],
        'learnMoreUrl': json['learnMoreUrl'] == null ? undefined : json['learnMoreUrl'],
    };
}

export function HelpToJSON(json: any): Help {
    return HelpToJSONTyped(json, false);
}

export function HelpToJSONTyped(value?: Help | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'body': value['body'],
        'learnMoreUrl': value['learnMoreUrl'],
    };
}

