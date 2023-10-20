
/*
 * Copyright 2021 <your company/name>.
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

package com.bytechef.component.datastorage.action;

import com.bytechef.hermes.component.ActionContext;
import com.bytechef.hermes.component.InputParameters;
import com.bytechef.hermes.component.definition.ActionDefinition;

import static com.bytechef.component.datastorage.constant.DataStorageConstants.KEY;
import static com.bytechef.component.datastorage.constant.DataStorageConstants.SCOPE;
import static com.bytechef.component.datastorage.constant.DataStorageConstants.SCOPE_OPTIONS;
import static com.bytechef.component.datastorage.constant.DataStorageConstants.TIMEOUT;
import static com.bytechef.hermes.component.definition.ComponentDSL.action;

import static com.bytechef.hermes.definition.DefinitionDSL.integer;
import static com.bytechef.hermes.definition.DefinitionDSL.string;

/**
 * @author Ivica Cardic
 */
public class DataStorageAwaitGetValueAction {

    public static final ActionDefinition ACTION_DEFINITION = action("awaitGetValue")
        .title("Await Get Value")
        .description("")
        .properties(
            string(KEY)
                .label("Key")
                .description("The identifier of a value to wait for.")
                .required(true),
            string(SCOPE)
                .label("Scope")
                .description("The namespace to obtain a value from.")
                .options(SCOPE_OPTIONS)
                .required(true),
            integer(TIMEOUT)
                .label("Timeout (1 to 300 sec)")
                .description(
                    "If a value is not found within the specified time, the action returns a null value. Therefore, the maximum wait time should be set accordingly.")
                .minValue(1)
                .maxValue(300)
                .required(true))
        .execute(DataStorageAwaitGetValueAction::execute);

    protected static Object execute(ActionContext actionContext, InputParameters inputParameters) {
        System.out.println(actionContext.toString());

        return null;
    }
}
