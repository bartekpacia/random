plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val f = file("../cucumber_steps/lib/build/libs/lib.jar")
if (!f.exists()) {
    throw RuntimeException("Build JAR for cucumber_steps first!")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("junit:junit:4.13.1")
    testImplementation("io.cucumber:cucumber-java:7.22.1")
    testImplementation("io.cucumber:cucumber-junit:7.22.1")
    testImplementation(files("../cucumber_steps/lib/build/libs/lib.jar"))
}

tasks.test {
    useJUnitPlatform()
}