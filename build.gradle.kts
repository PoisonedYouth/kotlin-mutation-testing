import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("info.solidsoft.pitest") version "1.7.4"
}

group = "com.poisonedyouth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

pitest {
    setProperty("junit5PluginVersion", "0.15")
    setProperty("testPlugin", "junit5")
    setProperty("targetClasses", listOf("com.poisonedyouth.*"))
    setProperty("outputFormats", listOf("HTML"))
    setProperty("failWhenNoMutations", false)
    setProperty("mutators", listOf("ALL"))
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}