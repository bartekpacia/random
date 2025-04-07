plugins {
    id("application")
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("org.example.Main")
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    // testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:3.27.3")

    testImplementation(platform("io.cucumber:cucumber-bom:7.21.1"))
    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        showStandardStreams = true
    }
}
