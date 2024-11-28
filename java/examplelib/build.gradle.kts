plugins {
    id("java")
    kotlin("jvm")
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 3 + 4
    testImplementation("junit:junit:4.13.1")
    // JUnit5
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // AssertJ
    testImplementation("org.assertj:assertj-core:3.26.3")

    // TestNG
    testImplementation("org.testng:testng:7.10.2")

    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains:annotations:26.0.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    archiveBaseName = "examplelib"
    archiveVersion = "1.0.0"
}

tasks.compileJava {
    options.release = 23
    options.compilerArgs.add("--enable-preview")
}

kotlin {
    jvmToolchain(23)
}