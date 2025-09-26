plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.cucumber:cucumber-java:7.22.1")
}

tasks.compileJava {
    options.release = 17
}