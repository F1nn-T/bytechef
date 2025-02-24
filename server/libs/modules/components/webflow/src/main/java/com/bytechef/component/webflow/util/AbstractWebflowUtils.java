/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.webflow.util;

import com.bytechef.component.definition.Context;
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.Parameters;
import java.util.List;
import java.util.Map;

/**
 * Provides methods for retrieving dynamic options for various properties within the component.
 *
 * @generated
 */
public abstract class AbstractWebflowUtils {
    public static List<Option<String>> getSiteIdOptions(
        Parameters inputParameters,
        Parameters connectionParameters, Map<String, String> dependencyPaths, String searchText,
        Context context) {

        return List.of();
    }

    public static List<Option<String>> getCollectionIdOptions(
        Parameters inputParameters,
        Parameters connectionParameters, Map<String, String> dependencyPaths, String searchText,
        Context context) {

        return List.of();
    }

    public static List<Option<String>> getOrderIdOptions(
        Parameters inputParameters,
        Parameters connectionParameters, Map<String, String> dependencyPaths, String searchText,
        Context context) {

        return List.of();
    }

    public static List<Option<String>> getItemIdOptions(
        Parameters inputParameters,
        Parameters connectionParameters, Map<String, String> dependencyPaths, String searchText,
        Context context) {

        return List.of();
    }
}
