group = "com.bytechef.server"
description = "ByteChef server app"

springBoot {
    mainClass.set("com.bytechef.server.ServerApplication")
}

dependencies {
    implementation("io.awspring.cloud:spring-cloud-aws-starter-s3")
    implementation("io.awspring.cloud:spring-cloud-aws-starter-secrets-manager")
    implementation("io.awspring.cloud:spring-cloud-aws-starter-sqs")
    implementation(libs.org.springdoc.springdoc.openapi.starter.common)
    implementation("org.springframework.ai:spring-ai-openai-spring-boot-starter:${rootProject.libs.versions.spring.ai.get()}")
    implementation("org.springframework.ai:spring-ai-pgvector-store-spring-boot-starter:${rootProject.libs.versions.spring.ai.get()}")
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-config"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-converter"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-git"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-repository:atlas-configuration-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-configuration:atlas-configuration-service"))
    implementation(project(":server:libs:atlas:atlas-coordinator:atlas-coordinator-config"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-repository:atlas-execution-repository-jdbc"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-config"))
    implementation(project(":server:libs:atlas:atlas-execution:atlas-execution-service"))
    implementation(project(":server:libs:atlas:atlas-file-storage:atlas-file-storage-impl"))
    implementation(project(":server:libs:atlas:atlas-worker:atlas-worker-config"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-instance-impl"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-rest:automation-configuration-rest-impl"))
    implementation(project(":server:libs:automation:automation-configuration:automation-configuration-service"))
    implementation(project(":server:libs:automation:automation-connection:automation-connection-rest"))
    implementation(project(":server:libs:automation:automation-connection:automation-connection-service"))
    implementation(project(":server:libs:automation:automation-security-web:automation-security-web-impl"))
    implementation(project(":server:libs:automation:automation-swagger"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-coordinator"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-execution:automation-workflow-execution-rest"))
    implementation(project(":server:libs:automation:automation-workflow:automation-workflow-execution:automation-workflow-execution-service"))
    implementation(project(":server:libs:config:app-config"))
    implementation(project(":server:libs:config:async-config"))
    implementation(project(":server:libs:config:automation-demo-config"))
    implementation(project(":server:libs:config:cache-config"))
    implementation(project(":server:libs:config:environment-config"))
    implementation(project(":server:libs:config:jackson-config"))
    implementation(project(":server:libs:config:jdbc-config"))
    implementation(project(":server:libs:config:liquibase-config"))
    implementation(project(":server:libs:config:logback-config"))
    implementation(project(":server:libs:config:messages-config"))
    implementation(project(":server:libs:config:security-config"))
    implementation(project(":server:libs:config:static-resources-config"))
    implementation(project(":server:libs:config:tenant-single-security-config"))
    implementation(project(":server:libs:core:commons:commons-data"))
    implementation(project(":server:libs:core:encryption:encryption-filesystem"))
    implementation(project(":server:libs:core:encryption:encryption-impl"))
    implementation(project(":server:libs:core:encryption:encryption-property"))
    implementation(project(":server:libs:core:file-storage:file-storage-base64-service"))
    implementation(project(":server:libs:core:file-storage:file-storage-filesystem-service"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-amqp"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-jms"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-kafka"))
    implementation(project(":server:libs:core:message:message-broker:message-broker-redis"))
    implementation(project(":server:libs:core:message:message-event:message-event-impl"))
    implementation(project(":server:libs:core:rest:rest-impl"))
    implementation(project(":server:libs:core:tenant:tenant-single-service"))
    implementation(project(":server:libs:embedded:embedded-connected-user:embedded-connected-user-rest"))
    implementation(project(":server:libs:embedded:embedded-connected-user:embedded-connected-user-service"))
    implementation(project(":server:libs:embedded:embedded-configuration:embedded-configuration-instance-impl"))
    implementation(project(":server:libs:embedded:embedded-configuration:embedded-configuration-public-rest"))
    implementation(project(":server:libs:embedded:embedded-configuration:embedded-configuration-rest:embedded-configuration-rest-impl"))
    implementation(project(":server:libs:embedded:embedded-configuration:embedded-configuration-service"))
    implementation(project(":server:libs:embedded:embedded-connection:embedded-connection-rest"))
    implementation(project(":server:libs:embedded:embedded-execution:embedded-execution-public-rest"))
    implementation(project(":server:libs:embedded:embedded-execution:embedded-execution-service"))
    implementation(project(":server:libs:embedded:embedded-security-web:embedded-security-web-impl"))
    implementation(project(":server:libs:embedded:embedded-swagger"))
    implementation(project(":server:libs:embedded:embedded-unified:embedded-unified-rest"))
    implementation(project(":server:libs:embedded:embedded-unified:embedded-unified-service"))
    implementation(project(":server:libs:embedded:embedded-user:embedded-user-rest"))
    implementation(project(":server:libs:embedded:embedded-workflow:embedded-workflow-coordinator"))
    implementation(project(":server:libs:embedded:embedded-workflow:embedded-workflow-execution:embedded-workflow-execution-rest"))
    implementation(project(":server:libs:embedded:embedded-workflow:embedded-workflow-execution:embedded-workflow-execution-service"))
    implementation(project(":server:libs:platform:platform-ai:platform-ai-rest"))
    implementation(project(":server:libs:platform:platform-ai:platform-ai-service"))
    implementation(project(":server:libs:platform:platform-category:platform-category-service"))
    implementation(project(":server:libs:platform:platform-component:platform-component-service"))
    implementation(project(":server:libs:platform:platform-connection:platform-connection-service"))
    implementation(project(":server:libs:platform:platform-configuration:platform-configuration-rest:platform-configuration-rest-impl"))
    implementation(project(":server:libs:platform:platform-configuration:platform-configuration-service"))
    implementation(project(":server:libs:platform:platform-data-storage:platform-data-storage-file-storage:platform-data-storage-file-storage-service"))
    implementation(project(":server:libs:platform:platform-data-storage:platform-data-storage-jdbc:platform-data-storage-jdbc-service"))
    implementation(project(":server:libs:platform:platform-feature-flags"))
    implementation(project(":server:libs:platform:platform-file-storage:platform-file-storage-impl"))
    implementation(project(":server:libs:platform:platform-oauth2:platform-oauth2-service"))
    implementation(project(":server:libs:platform:platform-scheduler:platform-scheduler-impl"))
    implementation(project(":server:libs:platform:platform-security-web:platform-security-web-impl"))
    implementation(project(":server:libs:platform:platform-swagger"))
    implementation(project(":server:libs:platform:platform-tag:platform-tag-service"))
    implementation(project(":server:libs:platform:platform-user:platform-user-rest:platform-user-rest-impl"))
    implementation(project(":server:libs:platform:platform-user:platform-user-service"))
    implementation(project(":server:libs:platform:platform-webhook:platform-webhook-impl"))
    implementation(project(":server:libs:platform:platform-webhook:platform-webhook-rest:platform-webhook-rest-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-coordinator:platform-workflow-coordinator-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-task-dispatcher:platform-workflow-task-dispatcher-service"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-test:platform-workflow-test-rest"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-test:platform-workflow-test-service"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-rest:platform-workflow-execution-rest-impl"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-execution:platform-workflow-execution-service"))
    implementation(project(":server:libs:platform:platform-workflow:platform-workflow-worker:platform-workflow-worker-impl"))

    implementation(project(":server:libs:modules:components:accelo"))
    implementation(project(":server:libs:modules:components:active-campaign"))
    implementation(project(":server:libs:modules:components:acumbamail"))
    implementation(project(":server:libs:modules:components:affinity"))
    implementation(project(":server:libs:modules:components:ai:agent"))
    implementation(project(":server:libs:modules:components:ai:agent:chat-memory"))
    implementation(project(":server:libs:modules:components:ai:agent:chat-memory:chat-memory-in-memory"))
    implementation(project(":server:libs:modules:components:ai:agent:chat-memory:chat-memory-vectorstore"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-modular"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-modular:query-transformer"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-modular:query-expander"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-modular:query-augmenter"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-modular:document-retriever"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-modular:document-joiner"))
    implementation(project(":server:libs:modules:components:ai:agent:rag:rag-questionanswer"))
    //implementation(project(":server:libs:modules:components:ai:llm:amazon-bedrock"))
    implementation(project(":server:libs:modules:components:ai:llm:anthropic"))
    implementation(project(":server:libs:modules:components:ai:llm:azure-open-ai"))
    implementation(project(":server:libs:modules:components:ai:llm:deepseek"))
    implementation(project(":server:libs:modules:components:ai:llm:groq"))
    implementation(project(":server:libs:modules:components:ai:llm:hugging-face"))
    implementation(project(":server:libs:modules:components:ai:llm:mistral"))
    implementation(project(":server:libs:modules:components:ai:llm:nvidia"))
    implementation(project(":server:libs:modules:components:ai:llm:ollama"))
    implementation(project(":server:libs:modules:components:ai:llm:open-ai"))
    implementation(project(":server:libs:modules:components:ai:llm:stability"))
    implementation(project(":server:libs:modules:components:ai:llm:vertex:gemini"))
    implementation(project(":server:libs:modules:components:ai:llm:watsonx"))
    implementation(project(":server:libs:modules:components:ai:universal:universal-image"))
    implementation(project(":server:libs:modules:components:ai:universal:universal-text"))
    implementation(project(":server:libs:modules:components:ai:vectorstore:pinecone"))
    implementation(project(":server:libs:modules:components:ai:vectorstore:qdrant"))
    implementation(project(":server:libs:modules:components:ai:vectorstore:reader"))
    implementation(project(":server:libs:modules:components:ai:vectorstore:transformer:enricher"))
    implementation(project(":server:libs:modules:components:ai:vectorstore:transformer:splitter"))
    implementation(project(":server:libs:modules:components:ai:vectorstore:weaviate"))
    implementation(project(":server:libs:modules:components:airtable"))
    implementation(project(":server:libs:modules:components:aitable"))
    implementation(project(":server:libs:modules:components:apollo"))
    implementation(project(":server:libs:modules:components:app-event"))
    implementation(project(":server:libs:modules:components:approval-link"))
    implementation(project(":server:libs:modules:components:asana"))
    implementation(project(":server:libs:modules:components:aws:aws-s3"))
    implementation(project(":server:libs:modules:components:baserow"))
    implementation(project(":server:libs:modules:components:bash"))
    implementation(project(":server:libs:modules:components:beamer"))
    implementation(project(":server:libs:modules:components:box"))
    implementation(project(":server:libs:modules:components:calendly"))
    implementation(project(":server:libs:modules:components:capsule-crm"))
    implementation(project(":server:libs:modules:components:chat"))
    implementation(project(":server:libs:modules:components:clickup"))
    implementation(project(":server:libs:modules:components:copper"))
    implementation(project(":server:libs:modules:components:csv-file"))
    implementation(project(":server:libs:modules:components:data-mapper"))
    implementation(project(":server:libs:modules:components:data-storage"))
    implementation(project(":server:libs:modules:components:data-stream"))
    implementation(project(":server:libs:modules:components:date-helper"))
    implementation(project(":server:libs:modules:components:delay"))
    implementation(project(":server:libs:modules:components:discord"))
    implementation(project(":server:libs:modules:components:dropbox"))
    implementation(project(":server:libs:modules:components:email"))
    implementation(project(":server:libs:modules:components:encharge"))
    implementation(project(":server:libs:modules:components:figma"))
    implementation(project(":server:libs:modules:components:file-storage"))
    implementation(project(":server:libs:modules:components:filesystem"))
    implementation(project(":server:libs:modules:components:freshdesk"))
    implementation(project(":server:libs:modules:components:freshsales"))
    implementation(project(":server:libs:modules:components:github"))
    implementation(project(":server:libs:modules:components:gitlab"))
    implementation(project(":server:libs:modules:components:google:google-calendar"))
    implementation(project(":server:libs:modules:components:google:google-contacts"))
    implementation(project(":server:libs:modules:components:google:google-docs"))
    implementation(project(":server:libs:modules:components:google:google-drive"))
    implementation(project(":server:libs:modules:components:google:google-forms"))
    implementation(project(":server:libs:modules:components:google:google-mail"))
    implementation(project(":server:libs:modules:components:google:google-sheets"))
    implementation(project(":server:libs:modules:components:google:google-slides"))
    implementation(project(":server:libs:modules:components:google:google-tasks"))
    implementation(project(":server:libs:modules:components:http-client"))
    implementation(project(":server:libs:modules:components:hubspot"))
    implementation(project(":server:libs:modules:components:hunter"))
    implementation(project(":server:libs:modules:components:image-helper"))
    implementation(project(":server:libs:modules:components:infobip"))
    implementation(project(":server:libs:modules:components:insightly"))
    implementation(project(":server:libs:modules:components:intercom"))
    implementation(project(":server:libs:modules:components:jira"))
    implementation(project(":server:libs:modules:components:jotform"))
    implementation(project(":server:libs:modules:components:json-file"))
    implementation(project(":server:libs:modules:components:json-helper"))
    implementation(project(":server:libs:modules:components:keap"))
    implementation(project(":server:libs:modules:components:logger"))
    implementation(project(":server:libs:modules:components:mailchimp"))
    implementation(project(":server:libs:modules:components:map"))
    implementation(project(":server:libs:modules:components:math-helper"))
    implementation(project(":server:libs:modules:components:microsoft:microsoft-excel"))
    implementation(project(":server:libs:modules:components:microsoft:microsoft-one-drive"))
    implementation(project(":server:libs:modules:components:microsoft:microsoft-outlook-365"))
    implementation(project(":server:libs:modules:components:microsoft:microsoft-share-point"))
    implementation(project(":server:libs:modules:components:microsoft:microsoft-teams"))
    implementation(project(":server:libs:modules:components:microsoft:microsoft-to-do"))
    implementation(project(":server:libs:modules:components:monday"))
    implementation(project(":server:libs:modules:components:myob"))
    implementation(project(":server:libs:modules:components:mysql"))
    implementation(project(":server:libs:modules:components:nifty"))
    implementation(project(":server:libs:modules:components:nutshell"))
    implementation(project(":server:libs:modules:components:object-helper"))
    implementation(project(":server:libs:modules:components:ods-file"))
    implementation(project(":server:libs:modules:components:one-simple-api"))
    implementation(project(":server:libs:modules:components:pdf-helper"))
    implementation(project(":server:libs:modules:components:petstore"))
    implementation(project(":server:libs:modules:components:pipedrive"))
    implementation(project(":server:libs:modules:components:pipeliner"))
    implementation(project(":server:libs:modules:components:postgresql"))
    implementation(project(":server:libs:modules:components:pushover"))
    implementation(project(":server:libs:modules:components:quickbooks"))
    implementation(project(":server:libs:modules:components:rabbitmq"))
    implementation(project(":server:libs:modules:components:random-helper"))
    implementation(project(":server:libs:modules:components:reckon"))
    implementation(project(":server:libs:modules:components:resend"))
    implementation(project(":server:libs:modules:components:request"))
    implementation(project(":server:libs:modules:components:salesflare"))
    implementation(project(":server:libs:modules:components:salesforce"))
    implementation(project(":server:libs:modules:components:schedule"))
    implementation(project(":server:libs:modules:components:script"))
    implementation(project(":server:libs:modules:components:sendgrid"))
    implementation(project(":server:libs:modules:components:shopify"))
    implementation(project(":server:libs:modules:components:slack"))
    implementation(project(":server:libs:modules:components:spotify"))
    implementation(project(":server:libs:modules:components:stripe"))
    implementation(project(":server:libs:modules:components:teamwork"))
    implementation(project(":server:libs:modules:components:text-helper"))
    implementation(project(":server:libs:modules:components:todoist"))
    implementation(project(":server:libs:modules:components:trello"))
    implementation(project(":server:libs:modules:components:twilio"))
    implementation(project(":server:libs:modules:components:typeform"))
    implementation(project(":server:libs:modules:components:var"))
    implementation(project(":server:libs:modules:components:vtiger"))
    implementation(project(":server:libs:modules:components:webflow"))
    implementation(project(":server:libs:modules:components:webhook"))
    implementation(project(":server:libs:modules:components:whatsapp"))
    implementation(project(":server:libs:modules:components:xero"))
    implementation(project(":server:libs:modules:components:xlsx-file"))
    implementation(project(":server:libs:modules:components:xml-file"))
    implementation(project(":server:libs:modules:components:xml-helper"))
    implementation(project(":server:libs:modules:components:zendesk-sell"))
    implementation(project(":server:libs:modules:components:zeplin"))
    implementation(project(":server:libs:modules:components:zoho:zoho-crm"))

    implementation(project(":server:libs:modules:task-dispatchers:approval"))
    implementation(project(":server:libs:modules:task-dispatchers:branch"))
    implementation(project(":server:libs:modules:task-dispatchers:condition"))
    implementation(project(":server:libs:modules:task-dispatchers:each"))
    implementation(project(":server:libs:modules:task-dispatchers:fork-join"))
    implementation(project(":server:libs:modules:task-dispatchers:loop"))
    implementation(project(":server:libs:modules:task-dispatchers:map"))
    implementation(project(":server:libs:modules:task-dispatchers:parallel"))
    implementation(project(":server:libs:modules:task-dispatchers:subflow"))

    implementation(project(":server:ee:libs:automation:automation-configuration:automation-configuration-public-rest"))
    implementation(project(":server:ee:libs:automation:automation-configuration:automation-configuration-rest"))
    implementation(project(":server:ee:libs:automation:automation-configuration:automation-configuration-service"))
    implementation(project(":server:ee:libs:automation:automation-api-platform:automation-api-platform-configuration:automation-api-platform-configuration-rest"))
    implementation(project(":server:ee:libs:automation:automation-api-platform:automation-api-platform-configuration:automation-api-platform-configuration-service"))
    implementation(project(":server:ee:libs:automation:automation-api-platform:automation-api-platform-handler:automation-api-platform-handler-rest"))
    implementation(project(":server:ee:libs:automation:automation-api-platform:automation-api-platform-handler:automation-api-platform-handler-security-web:automation-api-platform-handler-security-web-impl"))
    implementation(project(":server:ee:libs:config:observability-config"))
    implementation(project(":server:ee:libs:config:tenant-multi-data-config"))
    implementation(project(":server:ee:libs:config:tenant-multi-message-event-config"))
    implementation(project(":server:ee:libs:config:tenant-multi-security-config"))
    implementation(project(":server:ee:libs:core:cloud:cloud-aws"))
    implementation(project(":server:ee:libs:core:file-storage:file-storage-aws:file-storage-aws-api"))
    implementation(project(":server:ee:libs:core:file-storage:file-storage-aws:file-storage-aws-impl"))
    implementation(project(":server:ee:libs:core:message:message-broker:message-broker-aws"))
    implementation(project(":server:ee:libs:core:tenant:tenant-multi-service"))
    implementation(project(":server:ee:libs:platform:platform-api-connector:platform-api-connector-configuration:platform-api-connector-configuration-rest"))
    implementation(project(":server:ee:libs:platform:platform-api-connector:platform-api-connector-configuration:platform-api-connector-configuration-service"))
    implementation(project(":server:ee:libs:platform:platform-api-connector:platform-api-connector-file-storage:platform-api-connector-file-storage-impl"))
    implementation(project(":server:ee:libs:platform:platform-api-connector:platform-api-connector-handler"))
    implementation(project(":server:ee:libs:platform:platform-audit:platform-audit-service"))
    implementation(project(":server:ee:libs:platform:platform-code-workflow:platform-code-workflow-configuration:platform-code-workflow-configuration-service"))
    implementation(project(":server:ee:libs:platform:platform-code-workflow:platform-code-workflow-file-storage:platform-code-workflow-file-storage-impl"))
    implementation(project(":server:ee:libs:platform:platform-configuration:platform-configuration-rest"))
    implementation(project(":server:ee:libs:platform:platform-configuration:platform-configuration-service"))
    implementation(project(":server:ee:libs:platform:platform-custom-component:platform-custom-component-handler"))
    implementation(project(":server:ee:libs:platform:platform-custom-component:platform-custom-component-configuration:platform-custom-component-configuration-public-rest"))
    implementation(project(":server:ee:libs:platform:platform-custom-component:platform-custom-component-configuration:platform-custom-component-configuration-rest"))
    implementation(project(":server:ee:libs:platform:platform-custom-component:platform-custom-component-configuration:platform-custom-component-configuration-service"))
    implementation(project(":server:ee:libs:platform:platform-custom-component:platform-custom-component-file-storage:platform-custom-component-file-storage-impl"))
    implementation(project(":server:ee:libs:platform:platform-scheduler:platform-scheduler-aws"))

    implementation(project(":server:ee:libs:modules:components:api-platform"))
    implementation(project(":server:ee:libs:modules:components:code-workflow"))

    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.zaxxer:HikariCP")
    runtimeOnly("org.apache.activemq:artemis-jakarta-server")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly(libs.org.springdoc.springdoc.openapi.starter.webmvc.ui)
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.boot:spring-boot-starter-amqp")
    runtimeOnly("org.springframework.boot:spring-boot-starter-artemis")
    runtimeOnly("org.springframework.boot:spring-boot-starter-cache")
    runtimeOnly("org.springframework.boot:spring-boot-starter-quartz")
    runtimeOnly("org.springframework.boot:spring-boot-starter-mail")
    runtimeOnly("org.springframework.kafka:spring-kafka")

    testImplementation(project(":server:libs:test:test-int-support"))
}
