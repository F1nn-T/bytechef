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

package com.bytechef.component.definition.ai.agent;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;

/**
 * @author Ivica Cardic
 */
@FunctionalInterface
public interface SingleConnectionToolFunction extends ToolFunction {

    /**
     *
     * @param inputParameters
     * @param connectionParameters
     * @param context
     * @return
     */
    Object apply(Parameters inputParameters, Parameters connectionParameters, ActionContext context) throws Exception;
}
