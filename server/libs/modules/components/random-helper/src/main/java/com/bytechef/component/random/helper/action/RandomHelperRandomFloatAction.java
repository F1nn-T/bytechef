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

package com.bytechef.component.random.helper.action;

import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.integer;
import static com.bytechef.component.definition.ComponentDsl.number;
import static com.bytechef.component.definition.ComponentDsl.outputSchema;
import static com.bytechef.component.random.helper.constant.RandomHelperConstants.END_INCLUSIVE;
import static com.bytechef.component.random.helper.constant.RandomHelperConstants.START_INCLUSIVE;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDsl.ModifiableActionDefinition;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.random.helper.constant.RandomHelperConstants;

/**
 * @author Ivica Cardic
 */
public class RandomHelperRandomFloatAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action("randomFloat")
        .title("Random Float")
        .description("Generates a random float value.")
        .properties(
            integer(START_INCLUSIVE)
                .label("Start Inclusive")
                .description("The minimum possible generated value.")
                .required(true)
                .defaultValue(0),
            integer(END_INCLUSIVE)
                .label("End Inclusive")
                .description("The maximum possible generated value.")
                .required(true)
                .defaultValue(100))
        .output(outputSchema(number().description("Generated random float value.")))
        .perform(RandomHelperRandomFloatAction::perform);

    /**
     * Generates a random float.
     */
    protected static Float perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext context) {

        int startInclusive = inputParameters.getInteger(START_INCLUSIVE, 0);
        int endInclusive = inputParameters.getInteger(END_INCLUSIVE, 100);

        return nextFloat(startInclusive, endInclusive);
    }

    private static float nextFloat(final float startInclusive, final float endExclusive) {
        if (endExclusive < startInclusive) {
            throw new IllegalArgumentException("Start value must be smaller or equal to end value");
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException("Both range values must be non-negative");
        }

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + ((endExclusive - startInclusive) * RandomHelperConstants.RANDOM.nextFloat());
    }
}
