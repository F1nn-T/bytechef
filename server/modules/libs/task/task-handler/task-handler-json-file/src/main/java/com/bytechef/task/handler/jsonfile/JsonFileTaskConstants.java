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

package com.bytechef.task.handler.jsonfile;

/**
 * @author Ivica Cardic
 */
public class JsonFileTaskConstants {

    public static final String FILE_TYPE = "fileType";
    public static final String IS_ARRAY = "isArray";
    public static final String PATH = "path";
    public static final String PAGE_SIZE = "pageSize";
    public static final String PAGE_NUMBER = "pageNumber";
    public static final String SOURCE = "source";
    public static final String JSON_FILE = "jsonFile";
    public static final float VERSION_1_0 = 1.0f;
    public static final String READ = "read";
    public static final String WRITE = "write";

    public enum FileType {
        JSON,
        JSONL,
    }
}
