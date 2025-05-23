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

package com.bytechef.platform.component.trigger;

import com.bytechef.commons.util.ConvertUtils;
import com.bytechef.commons.util.MapUtils;
import com.bytechef.component.definition.TriggerDefinition.WebhookBody;
import com.bytechef.component.definition.TriggerDefinition.WebhookMethod;
import com.bytechef.component.definition.TypeReference;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
@SuppressFBWarnings("EI")
public record WebhookRequest(
    Map<String, List<String>> headers, Map<String, List<String>> parameters, WebhookBodyImpl body,
    WebhookMethod method) {

    public static final String WEBHOOK_REQUEST = "webhookRequest";

    @Override
    public String toString() {
        return "WebhookRequest{" +
            "headers=" + MapUtils.toString(headers) +
            ", parameters=" + MapUtils.toString(parameters) +
            ", body=" + body +
            ", method=" + method +
            '}';
    }

    public static class WebhookBodyImpl implements WebhookBody {

        private Object content;
        private ContentType contentType;
        private String mimeType;
        private String rawContent;

        private WebhookBodyImpl() {
        }

        public WebhookBodyImpl(Object content, ContentType contentType, String mimeType, String rawContent) {
            this.content = content;
            this.contentType = contentType;
            this.mimeType = mimeType;
            this.rawContent = rawContent;
        }

        @Override
        public Object getContent() {
            return content;
        }

        @Override
        public <T> T getContent(Class<T> valueType) {
            return ConvertUtils.convertValue(content, valueType);
        }

        @Override
        public <T> T getContent(TypeReference<T> valueTypeRef) {
            return ConvertUtils.convertValue(content, valueTypeRef.getType());
        }

        @Override
        public ContentType getContentType() {
            return contentType;
        }

        @Override
        public String getMimeType() {
            return mimeType;
        }

        @Override
        public String getRawContent() {
            return rawContent;
        }

        @Override
        public String toString() {
            return "WebhookBodyImpl{" +
                "content=" + content +
                ", contentType=" + contentType +
                ", mimeType='" + mimeType + '\'' +
                ", rawContent='" + rawContent + '\'' +
                '}';
        }
    }
}
