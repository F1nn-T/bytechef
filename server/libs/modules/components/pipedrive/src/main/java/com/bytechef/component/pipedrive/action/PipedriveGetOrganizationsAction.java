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

package com.bytechef.component.pipedrive.action;

import static com.bytechef.component.OpenApiComponentHandler.PropertyType;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.array;
import static com.bytechef.component.definition.ComponentDSL.bool;
import static com.bytechef.component.definition.ComponentDSL.integer;
import static com.bytechef.component.definition.ComponentDSL.object;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.definition.Context.Http.ResponseType;

import com.bytechef.component.definition.ComponentDSL;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Provides a list of the component actions.
 *
 * @generated
 */
public class PipedriveGetOrganizationsAction {
    public static final ComponentDSL.ModifiableActionDefinition ACTION_DEFINITION = action("getOrganizations")
        .title("Get all organizations")
        .description("Returns all organizations.")
        .metadata(
            Map.of(
                "method", "GET",
                "path", "/organizations"

            ))
        .properties(integer("user_id").label("User Id")
            .description(
                "If supplied, only organizations owned by the given user will be returned. However, `filter_id` takes precedence over `user_id` when both are supplied.")
            .required(false)
            .metadata(
                Map.of(
                    "type", PropertyType.QUERY)),
            integer("filter_id").label("Filter Id")
                .description("The ID of the filter to use")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            string("first_char").label("First Char")
                .description(
                    "If supplied, only organizations whose name starts with the specified letter will be returned (case insensitive)")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            integer("start").label("Start")
                .description("Pagination start")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            integer("limit").label("Limit")
                .description("Items shown per page")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)),
            string("sort").label("Sort")
                .description(
                    "The field names and sorting mode separated by a comma (`field_name_1 ASC`, `field_name_2 DESC`). Only first-level field keys are supported (no nested keys).")
                .required(false)
                .metadata(
                    Map.of(
                        "type", PropertyType.QUERY)))
        .outputSchema(
            object("additional_data")
                .properties(object("pagination")
                    .properties(integer("start").required(false), integer("limit").required(false),
                        bool("more_items_in_collection").required(false), integer("next_start").required(false))
                    .required(false))
                .required(false),
            array("data")
                .items(string("address_route").required(false), integer("related_closed_deals_count").required(false),
                    integer("email_messages_count").required(false), string("name").required(false),
                    integer("has_pic").required(false), bool("active_flag").required(false),
                    integer("id").required(false), integer("value").required(false), string("email").required(false),
                    string("pic_hash").required(false), string("cc_email").required(false),
                    integer("open_deals_count").required(false), bool("active_flag").required(false),
                    string("update_time").required(false), integer("added_by_user_id").required(false),
                    integer("item_id").required(false), string("item_type").required(false),
                    bool("active_flag").required(false), integer("value").required(false),
                    string("add_time").required(false),
                    object("pictures").properties(string("128").required(false), string("512").required(false))
                        .required(false),
                    integer("people_count").required(false), integer("last_activity_id").required(false),
                    string("next_activity_date").required(false), string("update_time").required(false),
                    integer("activities_count").required(false), integer("id").required(false),
                    string("address_admin_area_level_2").required(false), integer("won_deals_count").required(false),
                    string("address_admin_area_level_1").required(false),
                    string("address_street_number").required(false), string("owner_name").required(false),
                    integer("files_count").required(false), string("address").required(false),
                    integer("company_id").required(false), string("address_formatted_address").required(false),
                    string("address_postal_code").required(false), integer("related_won_deals_count").required(false),
                    string("address_country").required(false), string("first_char").required(false),
                    integer("undone_activities_count").required(false), integer("closed_deals_count").required(false),
                    string("address_subpremise").required(false), string("last_activity_date").required(false),
                    integer("label").required(false), integer("related_open_deals_count").required(false),
                    integer("related_lost_deals_count").required(false), integer("next_activity_id").required(false),
                    string("country_code").required(false), string("visible_to").required(false),
                    integer("notes_count").required(false), integer("followers_count").required(false),
                    string("name").required(false), string("address_sublocality").required(false),
                    string("address_locality").required(false), integer("lost_deals_count").required(false),
                    string("next_activity_time").required(false), string("add_time").required(false),
                    integer("done_activities_count").required(false))
                .required(false),
            object("related_objects")
                .properties(
                    object("organization")
                        .properties(string("name").required(false), integer("id").required(false),
                            string("address").required(false), integer("people_count").required(false),
                            integer("owner_id").required(false), string("cc_email").required(false))
                        .required(false),
                    object("user")
                        .properties(string("name").required(false), object("USER_ID").required(false),
                            integer("has_pic").required(false), bool("active_flag").required(false),
                            integer("id").required(false), string("email").required(false),
                            string("pic_hash").required(false))
                        .required(false),
                    object("picture")
                        .properties(string("update_time").required(false), integer("added_by_user_id").required(false),
                            integer("item_id").required(false), string("item_type").required(false),
                            bool("active_flag").required(false), integer("id").required(false),
                            string("add_time").required(false),
                            object("pictures").properties(string("128").required(false), string("512").required(false))
                                .required(false))
                        .required(false))
                .required(false),
            bool("success").required(false))
        .outputSchemaMetadata(Map.of(
            "responseType", ResponseType.JSON))
        .sampleOutput(Map.<String, Object>ofEntries(Map.entry("success", true),
            Map.entry("data",
                List.of(Map.<String, Object>ofEntries(Map.entry("id", 1), Map.entry("company_id", 77),
                    Map.entry("owner_id",
                        Map.<String, Object>ofEntries(Map.entry("id", 10), Map.entry("name", "Will Smith"),
                            Map.entry("email", "will.smith@pipedrive.com"), Map.entry("has_pic", 0),
                            Map.entry("pic_hash",
                                "2611ace8ac6a3afe2f69ed56f9e08c6b"),
                            Map.entry("active_flag", true), Map.entry("value", 10))),
                    Map.entry("name", "Bolt"), Map.entry("open_deals_count", 1),
                    Map.entry("related_open_deals_count", 2), Map.entry("closed_deals_count", 3),
                    Map.entry("related_closed_deals_count", 1), Map.entry("email_messages_count", 2),
                    Map.entry("people_count", 1), Map.entry("activities_count", 2),
                    Map.entry("done_activities_count", 1), Map.entry("undone_activities_count", 0),
                    Map.entry("files_count", 0), Map.entry("notes_count", 0), Map.entry("followers_count", 1),
                    Map.entry("won_deals_count", 0), Map.entry("related_won_deals_count", 0),
                    Map.entry("lost_deals_count", 0), Map.entry("related_lost_deals_count", 0),
                    Map.entry("active_flag", true),
                    Map.entry("picture_id", Map.<String, Object>ofEntries(Map.entry("item_type", "person"),
                        Map.entry("item_id", 25), Map.entry("active_flag", true),
                        Map.entry("add_time", "2020-09-08 08:17:52"), Map.entry("update_time", "0000-00-00 00:00:00"),
                        Map.entry("added_by_user_id", 967055),
                        Map.entry("pictures", Map.<String, Object>ofEntries(Map.entry("128",
                            "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cf14ac8f269_128.jpg"),
                            Map.entry("512",
                                "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cfb2ac8f269_512.jpg"))),
                        Map.entry("value", 101))),
                    Map.entry("country_code", "USA"), Map.entry("first_char", "b"),
                    Map.entry("update_time", "2020-09-08 12:14:11"), Map.entry("add_time", "2020-02-25 10:04:08"), Map
                        .entry("visible_to", 3.0),
                    Map.entry("next_activity_date", LocalDate.of(2019, 11, 29)),
                    Map.entry("next_activity_time", "11:30:00"), Map.entry("next_activity_id", 128), Map.entry(
                        "last_activity_id", 34),
                    Map.entry("last_activity_date", LocalDate.of(2019, 11, 28)), Map.entry("label", 7),
                    Map.entry("address", "Mustamäe tee 3a, 10615 Tallinn"), Map.entry("address_subpremise", ""),
                    Map.entry("address_street_number", "3a"), Map.entry("address_route", "Mustamäe tee"),
                    Map.entry("address_sublocality", "Kristiine"), Map.entry("address_locality", "Tallinn"),
                    Map.entry("address_admin_area_level_1", "Harju maakond"),
                    Map.entry("address_admin_area_level_2", ""), Map.entry("address_country", "Estonia"), Map.entry(
                        "address_postal_code", 10616.0),
                    Map.entry("address_formatted_address", "Mustamäe tee 3a, 10616 Tallinn, Estonia"), Map
                        .entry("owner_name", "John Doe"),
                    Map.entry("cc_email", "org@pipedrivemail.com")))),
            Map.entry("additional_data",
                Map.<String, Object>ofEntries(Map.entry("pagination",
                    Map.<String, Object>ofEntries(Map.entry("start", 0), Map.entry("limit", 100),
                        Map.entry("more_items_in_collection", false), Map.entry("next_start", 100))))),
            Map.entry(
                "related_objects", Map
                    .<String, Object>ofEntries(
                        Map.entry("organization",
                            Map.<String, Object>ofEntries(Map.entry("1", Map.<String, Object>ofEntries(
                                Map.entry("id", 1), Map.entry("name", "Org Name"), Map.entry("people_count", 1),
                                Map.entry("owner_id", 123), Map.entry("address", "Mustamäe tee 3a, 10615 Tallinn"),
                                Map.entry("active_flag", true), Map.entry("cc_email", "org@pipedrivemail.com"))))),
                        Map.entry("user", Map.<String, Object>ofEntries(Map.entry("123",
                            Map.<String, Object>ofEntries(Map.entry("id", 123), Map.entry("name", "Jane Doe"),
                                Map.entry("email", "jane@pipedrive.com"), Map.entry("has_pic", 1),
                                Map.entry("pic_hash", "2611ace8ac6a3afe2f69ed56f9e08c6b"),
                                Map.entry("active_flag", true))))),
                        Map.entry("picture", Map.<String, Object>ofEntries(Map.entry("1", Map.<String, Object>ofEntries(
                            Map.entry("id", 1), Map.entry("item_type", "person"), Map.entry("item_id", 25),
                            Map.entry("active_flag", true), Map.entry("add_time", "2020-09-08 08:17:52"),
                            Map.entry("update_time", "0000-00-00 00:00:00"), Map.entry("added_by_user_id", 967055),
                            Map.entry("pictures", Map.<String, Object>ofEntries(Map.entry(
                                "128",
                                "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cfb4ac8f269_128.jpg"),
                                Map.entry("512",
                                    "https://pipedrive-profile-pics.s3.example.com/f8893852574273f2747bf6ef09d11cfb4ac8f269_512.jpg")))))))))));
}
