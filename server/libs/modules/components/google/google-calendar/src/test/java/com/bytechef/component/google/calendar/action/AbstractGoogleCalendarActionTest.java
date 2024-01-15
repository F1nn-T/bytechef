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

package com.bytechef.component.google.calendar.action;

import static com.bytechef.hermes.component.definition.constant.AuthorizationConstants.ACCESS_TOKEN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.bytechef.hermes.component.definition.ActionContext;
import com.bytechef.hermes.component.definition.Parameters;
import com.google.api.services.calendar.Calendar;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Monika Domiter
 */
public abstract class AbstractGoogleCalendarActionTest {

    protected Calendar mockedCalendar = mock(Calendar.class);
    protected ActionContext mockedContext = mock(ActionContext.class);
    protected Parameters mockedParameters = mock(Parameters.class);

    @BeforeEach
    public void beforeEach() {

        when(mockedParameters.getRequiredString(ACCESS_TOKEN))
            .thenReturn("accessToken");
    }
}
