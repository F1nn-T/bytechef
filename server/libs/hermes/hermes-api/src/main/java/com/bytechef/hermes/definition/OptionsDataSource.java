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

package com.bytechef.hermes.definition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ivica Cardic
 */
@Schema(
        name = "FunctionOptionsDataSource",
        description = "Defines function that should dynamically load options for the property.")
public class OptionsDataSource {

    private List<String> loadOptionsDependsOn;

    @JsonIgnore
    private Function<Object, Object> loadOptionsFunction;

    @SuppressWarnings("unchecked")
    public OptionsDataSource loadOptionsDependsOn(String... propertyNames) {
        this.loadOptionsDependsOn = List.of(propertyNames);

        return this;
    }

    @SuppressWarnings("unchecked")
    public OptionsDataSource loadOptionsFunction(Function<Object, Object> loadOptionsFunction) {
        this.loadOptionsFunction = loadOptionsFunction;

        return this;
    }

    @Schema(
            name = "loadOptionsDependsOn",
            description = "The list of property names on which value change the property options should load/reload.")
    public List<String> getLoadOptionsDependsOn() {
        return loadOptionsDependsOn;
    }

    /**
     * The function that should dynamically load options for the property.
     *
     * @return a load options function implementation
     */
    public Function<Object, Object> getLoadOptionsFunction() {
        return loadOptionsFunction;
    }
}
