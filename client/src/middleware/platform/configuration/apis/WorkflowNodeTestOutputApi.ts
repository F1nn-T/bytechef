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


import * as runtime from '../runtime';
import type {
  UploadWorkflowNodeSampleOutputRequestModel,
  WorkflowNodeTestOutputModel,
} from '../models/index';
import {
    UploadWorkflowNodeSampleOutputRequestModelFromJSON,
    UploadWorkflowNodeSampleOutputRequestModelToJSON,
    WorkflowNodeTestOutputModelFromJSON,
    WorkflowNodeTestOutputModelToJSON,
} from '../models/index';

export interface SaveWorkflowNodeTestOutputRequest {
    workflowId: string;
    workflowNodeName: string;
}

export interface UploadWorkflowNodeSampleOutputRequest {
    workflowId: string;
    workflowNodeName: string;
    uploadWorkflowNodeSampleOutputRequestModel: UploadWorkflowNodeSampleOutputRequestModel;
}

/**
 * 
 */
export class WorkflowNodeTestOutputApi extends runtime.BaseAPI {

    /**
     * Create a new or update existing workflow node test output.
     * Create a new or update existing workflow node test output
     */
    async saveWorkflowNodeTestOutputRaw(requestParameters: SaveWorkflowNodeTestOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<WorkflowNodeTestOutputModel>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling saveWorkflowNodeTestOutput.');
        }

        if (requestParameters.workflowNodeName === null || requestParameters.workflowNodeName === undefined) {
            throw new runtime.RequiredError('workflowNodeName','Required parameter requestParameters.workflowNodeName was null or undefined when calling saveWorkflowNodeTestOutput.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/workflow-node-test-outputs/{workflowId}/{workflowNodeName}`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))).replace(`{${"workflowNodeName"}}`, encodeURIComponent(String(requestParameters.workflowNodeName))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => WorkflowNodeTestOutputModelFromJSON(jsonValue));
    }

    /**
     * Create a new or update existing workflow node test output.
     * Create a new or update existing workflow node test output
     */
    async saveWorkflowNodeTestOutput(requestParameters: SaveWorkflowNodeTestOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<WorkflowNodeTestOutputModel> {
        const response = await this.saveWorkflowNodeTestOutputRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Upload a sample output to create a new or update existing workflow node test output.
     * Upload a sample output to create a new or update existing workflow node test output
     */
    async uploadWorkflowNodeSampleOutputRaw(requestParameters: UploadWorkflowNodeSampleOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<WorkflowNodeTestOutputModel>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling uploadWorkflowNodeSampleOutput.');
        }

        if (requestParameters.workflowNodeName === null || requestParameters.workflowNodeName === undefined) {
            throw new runtime.RequiredError('workflowNodeName','Required parameter requestParameters.workflowNodeName was null or undefined when calling uploadWorkflowNodeSampleOutput.');
        }

        if (requestParameters.uploadWorkflowNodeSampleOutputRequestModel === null || requestParameters.uploadWorkflowNodeSampleOutputRequestModel === undefined) {
            throw new runtime.RequiredError('uploadWorkflowNodeSampleOutputRequestModel','Required parameter requestParameters.uploadWorkflowNodeSampleOutputRequestModel was null or undefined when calling uploadWorkflowNodeSampleOutput.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/workflow-node-test-outputs/{workflowId}/{workflowNodeName}/sample-output`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))).replace(`{${"workflowNodeName"}}`, encodeURIComponent(String(requestParameters.workflowNodeName))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: UploadWorkflowNodeSampleOutputRequestModelToJSON(requestParameters.uploadWorkflowNodeSampleOutputRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => WorkflowNodeTestOutputModelFromJSON(jsonValue));
    }

    /**
     * Upload a sample output to create a new or update existing workflow node test output.
     * Upload a sample output to create a new or update existing workflow node test output
     */
    async uploadWorkflowNodeSampleOutput(requestParameters: UploadWorkflowNodeSampleOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<WorkflowNodeTestOutputModel> {
        const response = await this.uploadWorkflowNodeSampleOutputRaw(requestParameters, initOverrides);
        return await response.value();
    }

}