plugins {
    id("java")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.jetbrains:annotations:26.0.2")
    implementation("org.jspecify:jspecify:1.0.0")
}

tasks.test {
    useJUnitPlatform()
}