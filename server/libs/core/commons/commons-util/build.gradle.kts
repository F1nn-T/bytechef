dependencies {
    api("com.fasterxml.jackson.core:jackson-databind")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
    api("com.jayway.jsonpath:json-path")

    implementation("org.apache.commons:commons-lang3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.slf4j:slf4j-api")

    testImplementation(project(":server:libs:config:jackson-config"))
}
