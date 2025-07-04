plugins {
    id("java")
    kotlin("jvm")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.hamcrest:hamcrest:3.0")

    // JUnit 4
    testImplementation("junit:junit:4.13")

    // AssertJ
    testImplementation("org.assertj:assertj-core:3.26.3")

    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.google.code.findbugs:jsr305:3.0.2")

    implementation("org.jetbrains:annotations:26.0.2")

    // Sample lib
    implementation(files("../java/examplelib/build/libs/examplelib-1.0.0.jar"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    jvmToolchain(21)
    compilerOptions {  }
}
