plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.10.0")

    // mocks
    testImplementation ("org.mockito:mockito-junit-jupiter:5.5.0")
    testImplementation ("org.mockito:mockito-core:5.5.0")

    // mocks static
    testImplementation ("org.mockito:mockito-inline:5.2.0")

}

tasks.test {
    useJUnitPlatform()
}