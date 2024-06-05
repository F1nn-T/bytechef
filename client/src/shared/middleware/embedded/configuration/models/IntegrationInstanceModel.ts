/* tslint:disable */
/* eslint-disable */
/**
 * The Embedded Configuration API
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
import type { IntegrationInstanceIntegrationInstanceConfigurationModel } from './IntegrationInstanceIntegrationInstanceConfigurationModel';
import {
    IntegrationInstanceIntegrationInstanceConfigurationModelFromJSON,
    IntegrationInstanceIntegrationInstanceConfigurationModelFromJSONTyped,
    IntegrationInstanceIntegrationInstanceConfigurationModelToJSON,
} from './IntegrationInstanceIntegrationInstanceConfigurationModel';
import type { IntegrationInstanceWorkflowModel } from './IntegrationInstanceWorkflowModel';
import {
    IntegrationInstanceWorkflowModelFromJSON,
    IntegrationInstanceWorkflowModelFromJSONTyped,
    IntegrationInstanceWorkflowModelToJSON,
} from './IntegrationInstanceWorkflowModel';

/**
 * Contains configurations and connections required for the execution of integration workflows for a connected user.
 * @export
 * @interface IntegrationInstanceModel
 */
export interface IntegrationInstanceModel {
    /**
     * The id of a connection.
     * @type {number}
     * @memberof IntegrationInstanceModel
     */
    readonly connectionId: number;
    /**
     * The id of a connected user.
     * @type {number}
     * @memberof IntegrationInstanceModel
     */
    readonly connectedUserId?: number;
    /**
     * The created by.
     * @type {string}
     * @memberof IntegrationInstanceModel
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof IntegrationInstanceModel
     */
    readonly createdDate?: Date;
    /**
     * If an integration instance is enabled or not.
     * @type {boolean}
     * @memberof IntegrationInstanceModel
     */
    enabled?: boolean;
    /**
     * The id of an integration instance.
     * @type {number}
     * @memberof IntegrationInstanceModel
     */
    readonly id?: number;
    /**
     * 
     * @type {IntegrationInstanceIntegrationInstanceConfigurationModel}
     * @memberof IntegrationInstanceModel
     */
    integrationInstanceConfiguration?: IntegrationInstanceIntegrationInstanceConfigurationModel;
    /**
     * Th id of an integration instance configuration.
     * @type {number}
     * @memberof IntegrationInstanceModel
     */
    integrationInstanceConfigurationId?: number;
    /**
     * The array of integration instance workflows.
     * @type {Array<IntegrationInstanceWorkflowModel>}
     * @memberof IntegrationInstanceModel
     */
    readonly integrationInstanceWorkflows?: Array<IntegrationInstanceWorkflowModel>;
    /**
     * The last execution date.
     * @type {Date}
     * @memberof IntegrationInstanceModel
     */
    readonly lastExecutionDate?: Date;
    /**
     * The last modified by.
     * @type {string}
     * @memberof IntegrationInstanceModel
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof IntegrationInstanceModel
     */
    readonly lastModifiedDate?: Date;
    /**
     * 
     * @type {number}
     * @memberof IntegrationInstanceModel
     */
    version?: number;
}

/**
 * Check if a given object implements the IntegrationInstanceModel interface.
 */
export function instanceOfIntegrationInstanceModel(value: object): boolean {
    if (!('connectionId' in value)) return false;
    return true;
}

export function IntegrationInstanceModelFromJSON(json: any): IntegrationInstanceModel {
    return IntegrationInstanceModelFromJSONTyped(json, false);
}

export function IntegrationInstanceModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): IntegrationInstanceModel {
    if (json == null) {
        return json;
    }
    return {
        
        'connectionId': json['connectionId'],
        'connectedUserId': json['connectedUserId'] == null ? undefined : json['connectedUserId'],
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'enabled': json['enabled'] == null ? undefined : json['enabled'],
        'id': json['id'] == null ? undefined : json['id'],
        'integrationInstanceConfiguration': json['integrationInstanceConfiguration'] == null ? undefined : IntegrationInstanceIntegrationInstanceConfigurationModelFromJSON(json['integrationInstanceConfiguration']),
        'integrationInstanceConfigurationId': json['integrationInstanceConfigurationId'] == null ? undefined : json['integrationInstanceConfigurationId'],
        'integrationInstanceWorkflows': json['integrationInstanceWorkflows'] == null ? undefined : ((json['integrationInstanceWorkflows'] as Array<any>).map(IntegrationInstanceWorkflowModelFromJSON)),
        'lastExecutionDate': json['lastExecutionDate'] == null ? undefined : (new Date(json['lastExecutionDate'])),
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function IntegrationInstanceModelToJSON(value?: Omit<IntegrationInstanceModel, 'connectionId'|'connectedUserId'|'createdBy'|'createdDate'|'id'|'integrationInstanceWorkflows'|'lastExecutionDate'|'lastModifiedBy'|'lastModifiedDate'> | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'enabled': value['enabled'],
        'integrationInstanceConfiguration': IntegrationInstanceIntegrationInstanceConfigurationModelToJSON(value['integrationInstanceConfiguration']),
        'integrationInstanceConfigurationId': value['integrationInstanceConfigurationId'],
        '__version': value['version'],
    };
}
