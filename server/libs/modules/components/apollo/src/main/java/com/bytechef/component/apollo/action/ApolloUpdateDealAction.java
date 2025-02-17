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

package com.bytechef.component.apollo.action;

import static com.bytechef.component.OpenApiComponentHandler.PropertyType;
import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.date;
import static com.bytechef.component.definition.ComponentDsl.number;
import static com.bytechef.component.definition.ComponentDsl.object;
import static com.bytechef.component.definition.ComponentDsl.outputSchema;
import static com.bytechef.component.definition.ComponentDsl.string;
import static com.bytechef.component.definition.Context.Http.ResponseType;

import com.bytechef.component.definition.ComponentDsl;
import java.util.Map;

/**
 * Provides a list of the component actions.
 *
 * @generated
 */
public class ApolloUpdateDealAction {
    public static final ComponentDsl.ModifiableActionDefinition ACTION_DEFINITION = action("updateDeal")
        .title("Update Deal")
        .description("Updates the details of existing deals within your team's Apollo account.")
        .metadata(
            Map.of(
                "method", "PATCH",
                "path", "/opportunities"

            ))
        .properties(string("opportunity_id").label("Opportunity Id")
            .description("The ID for the deal you want to update.")
            .required(true)
            .metadata(
                Map.of(
                    "type", PropertyType.PATH)),
            string("owner_id").label("Owner ID")
                .description("The ID for the deal owner within your team's Apollo account.")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            string("name").label("Name")
                .description("New name for the deal.")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            date("closed_date").label("Close Date")
                .description("Updated estimated close date for the deal. This can be a future or past date.")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            string("account_id").label("Account ID")
                .description(
                    "The ID for the account within your Apollo instance. This is the company that you are targeting as part of the deal being created.")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)))
        .output(outputSchema(object()
            .properties(object("body")
                .properties(object("opportunity")
                    .properties(string("id").required(false), string("team_id").required(false),
                        string("owner_id").required(false), number("amount").required(false),
                        date("closed_date").required(false), string("account_id").required(false),
                        string("description").required(false), string("name").required(false),
                        object("currency")
                            .properties(string("name").required(false), string("iso_code").required(false),
                                string("symbol").required(false))
                            .required(false))
                    .required(false))
                .required(false))
            .metadata(
                Map.of(
                    "responseType", ResponseType.JSON))));

    private ApolloUpdateDealAction() {
    }
}
