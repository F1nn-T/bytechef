/* tslint:disable */
/* eslint-disable */
/**
 * The Embedded Configuration Internal API
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
import type { Category } from './Category';
import {
    CategoryFromJSON,
    CategoryFromJSONTyped,
    CategoryToJSON,
    CategoryToJSONTyped,
} from './Category';
import type { IntegrationStatus } from './IntegrationStatus';
import {
    IntegrationStatusFromJSON,
    IntegrationStatusFromJSONTyped,
    IntegrationStatusToJSON,
    IntegrationStatusToJSONTyped,
} from './IntegrationStatus';
import type { Tag } from './Tag';
import {
    TagFromJSON,
    TagFromJSONTyped,
    TagToJSON,
    TagToJSONTyped,
} from './Tag';

/**
 * A group of workflows that make one logical integration.
 * @export
 * @interface Integration
 */
export interface Integration {
    /**
     * The name of the integration's component.
     * @type {string}
     * @memberof Integration
     */
    componentName: string;
    /**
     * The created by.
     * @type {string}
     * @memberof Integration
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof Integration
     */
    readonly createdDate?: Date;
    /**
     * The description of an integration.
     * @type {string}
     * @memberof Integration
     */
    description?: string;
    /**
     * The icon.
     * @type {string}
     * @memberof Integration
     */
    icon?: string;
    /**
     * The id of an integration.
     * @type {number}
     * @memberof Integration
     */
    readonly id?: number;
    /**
     * The last modified by.
     * @type {string}
     * @memberof Integration
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof Integration
     */
    readonly lastModifiedDate?: Date;
    /**
     * The last published date.
     * @type {Date}
     * @memberof Integration
     */
    readonly lastPublishedDate?: Date;
    /**
     * 
     * @type {IntegrationStatus}
     * @memberof Integration
     */
    lastStatus?: IntegrationStatus;
    /**
     * The last version of an integration.
     * @type {number}
     * @memberof Integration
     */
    readonly lastVersion?: number;
    /**
     * If multiple instances of an integration are allowed or not.
     * @type {boolean}
     * @memberof Integration
     */
    multipleInstances: boolean;
    /**
     * The name of an integration.
     * @type {string}
     * @memberof Integration
     */
    name?: string;
    /**
     * 
     * @type {Category}
     * @memberof Integration
     */
    category?: Category;
    /**
     * The integration workflow ids belonging to this integration.
     * @type {Array<number>}
     * @memberof Integration
     */
    integrationWorkflowIds?: Array<number>;
    /**
     * 
     * @type {Array<Tag>}
     * @memberof Integration
     */
    tags?: Array<Tag>;
    /**
     * 
     * @type {number}
     * @memberof Integration
     */
    version?: number;
}



/**
 * Check if a given object implements the Integration interface.
 */
export function instanceOfIntegration(value: object): value is Integration {
    if (!('componentName' in value) || value['componentName'] === undefined) return false;
    if (!('multipleInstances' in value) || value['multipleInstances'] === undefined) return false;
    return true;
}

export function IntegrationFromJSON(json: any): Integration {
    return IntegrationFromJSONTyped(json, false);
}

export function IntegrationFromJSONTyped(json: any, ignoreDiscriminator: boolean): Integration {
    if (json == null) {
        return json;
    }
    return {
        
        'componentName': json['componentName'],
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'description': json['description'] == null ? undefined : json['description'],
        'icon': json['icon'] == null ? undefined : json['icon'],
        'id': json['id'] == null ? undefined : json['id'],
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'lastPublishedDate': json['lastPublishedDate'] == null ? undefined : (new Date(json['lastPublishedDate'])),
        'lastStatus': json['lastStatus'] == null ? undefined : IntegrationStatusFromJSON(json['lastStatus']),
        'lastVersion': json['lastVersion'] == null ? undefined : json['lastVersion'],
        'multipleInstances': json['multipleInstances'],
        'name': json['name'] == null ? undefined : json['name'],
        'category': json['category'] == null ? undefined : CategoryFromJSON(json['category']),
        'integrationWorkflowIds': json['integrationWorkflowIds'] == null ? undefined : json['integrationWorkflowIds'],
        'tags': json['tags'] == null ? undefined : ((json['tags'] as Array<any>).map(TagFromJSON)),
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function IntegrationToJSON(json: any): Integration {
    return IntegrationToJSONTyped(json, false);
}

export function IntegrationToJSONTyped(value?: Omit<Integration, 'createdBy'|'createdDate'|'id'|'lastModifiedBy'|'lastModifiedDate'|'lastPublishedDate'|'lastVersion'> | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'componentName': value['componentName'],
        'description': value['description'],
        'icon': value['icon'],
        'lastStatus': IntegrationStatusToJSON(value['lastStatus']),
        'multipleInstances': value['multipleInstances'],
        'name': value['name'],
        'category': CategoryToJSON(value['category']),
        'integrationWorkflowIds': value['integrationWorkflowIds'],
        'tags': value['tags'] == null ? undefined : ((value['tags'] as Array<any>).map(TagToJSON)),
        '__version': value['version'],
    };
}

