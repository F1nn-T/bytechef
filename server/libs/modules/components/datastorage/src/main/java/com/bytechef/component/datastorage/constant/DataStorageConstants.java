
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

package com.bytechef.component.datastorage.constant;

import com.bytechef.hermes.definition.Option;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import static com.bytechef.hermes.definition.DefinitionDSL.option;

/**
 * @author Ivica Cardic
 */
public class DataStorageConstants {

    public static final String APPEND_LIST_AS_SINGLE_ITEM = "appendListAsSingleItem";
    public static final String CREATE_VALUE_IF_MISSING = "createValueIfMissing";
    public static final String DEFAULT_VALUE = "defaultValue";
    public static final String INDEX = "index";
    public static final String KEY = "key";
    public static final String SCOPE = "scope";
    public static final String VALUE = "value";
    public static final String VALUE_TO_ADD = "valueToAdd";
    public static final String TIMEOUT = "timeout";

    @SuppressFBWarnings("MS")
    public static final Option[] SCOPE_OPTIONS = {
        option("Current Execution", 1),
        option("Workflow Instance", 2),
        option("Workflow", 3),
        option("Account", 4)
    };
}
