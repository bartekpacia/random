plugins {
    id("java")
    kotlin("jvm")
}

group = "pacia.tech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains:annotations:26.0.1")

    testImplementation("junit:junit:4.13.1")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    archiveBaseName = "examplelib"
    archiveVersion = "1.0.0"
}
kotlin {
    jvmToolchain(17)
}