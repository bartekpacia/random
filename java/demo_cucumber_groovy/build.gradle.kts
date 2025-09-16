plugins {
    id("java")
    id("groovy")
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

    implementation(localGroovy())
    testImplementation("io.cucumber:cucumber-groovy:6.10.4")
}

tasks.test {
    useJUnitPlatform()
}