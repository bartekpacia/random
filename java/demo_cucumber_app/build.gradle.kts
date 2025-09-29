plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val libJar = files("../demo_cucumber_steps/target/steps-1.0.0.jar")
if (libJar.asFileTree.isEmpty) {
    throw RuntimeException("JAR doesn't exist: ${libJar.files}")
}
dependencies {
    testImplementation("junit:junit:4.13.1")
    testImplementation("io.cucumber:cucumber-java:7.22.1")
    testImplementation("io.cucumber:cucumber-junit:7.22.1")
    testImplementation(libJar)
}
