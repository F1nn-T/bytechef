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

package com.bytechef.component.script.action;

import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.array;
import static com.bytechef.component.definition.ComponentDsl.bool;
import static com.bytechef.component.definition.ComponentDsl.date;
import static com.bytechef.component.definition.ComponentDsl.dateTime;
import static com.bytechef.component.definition.ComponentDsl.integer;
import static com.bytechef.component.definition.ComponentDsl.nullable;
import static com.bytechef.component.definition.ComponentDsl.number;
import static com.bytechef.component.definition.ComponentDsl.object;
import static com.bytechef.component.definition.ComponentDsl.string;
import static com.bytechef.component.definition.ComponentDsl.time;
import static com.bytechef.component.script.constant.ScriptConstants.INPUT;
import static com.bytechef.platform.component.definition.ScriptComponentDefinition.SCRIPT;

import com.bytechef.component.definition.Property;
import com.bytechef.component.script.action.definition.ScriptActionDefinition;
import com.bytechef.component.script.engine.PolyglotEngine;

/**
 * @author Matija Petanjek
 * @author Ivica Cardic
 */
public class ScriptJavaAction {

    public final ScriptActionDefinition actionDefinition;

    public ScriptJavaAction(PolyglotEngine polyglotEngine) {
        this.actionDefinition = new ScriptActionDefinition(
            action("java")
                .title("Java")
                .description("Executes custom Java code.")
                .properties(
                    object(INPUT)
                        .label("Input")
                        .description("Initialize parameter values used in the custom code.")
                        .additionalProperties(
                            array(), bool(), date(), dateTime(), integer(), nullable(), number(), object(), string(),
                            time()),
                    string(SCRIPT)
                        .label("Java Code")
                        .description("Add your Java custom logic here.")
                        .controlType(Property.ControlType.CODE_EDITOR)
                        .defaultValue(
                            "public static Object perform(Map<String, ?> input, Context context) {\n\treturn null;\n}")
                        .required(true))
                .output(),
            "java", polyglotEngine);
    }
}
