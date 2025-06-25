plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("junit:junit:4.13.1")
    testImplementation("io.cucumber:cucumber-java:7.22.1")
    testImplementation("io.cucumber:cucumber-junit:7.22.1")
    testImplementation(files("/Users/Bartek.Pacia/projects/random/java/cucumber_steps/lib/build/libs/lib.jar"))
}

tasks.test {
    useJUnitPlatform()
}