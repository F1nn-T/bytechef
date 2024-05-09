/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Connection API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


/**
 * The environment of a connection.
 * @export
 */
export const ConnectionEnvironmentModel = {
    Development: 'DEVELOPMENT',
    Test: 'TEST',
    Production: 'PRODUCTION'
} as const;
export type ConnectionEnvironmentModel = typeof ConnectionEnvironmentModel[keyof typeof ConnectionEnvironmentModel];


export function ConnectionEnvironmentModelFromJSON(json: any): ConnectionEnvironmentModel {
    return ConnectionEnvironmentModelFromJSONTyped(json, false);
}

export function ConnectionEnvironmentModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ConnectionEnvironmentModel {
    return json as ConnectionEnvironmentModel;
}

export function ConnectionEnvironmentModelToJSON(value?: ConnectionEnvironmentModel | null): any {
    return value as any;
}

