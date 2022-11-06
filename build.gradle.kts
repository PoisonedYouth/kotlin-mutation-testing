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
    setProperty("junit5PluginVersion", "0.12")
    setProperty("testPlugin", "junit5")
    setProperty("targetClasses", listOf("com.poisonedyouth.*"))
    setProperty("outputFormats", listOf("HTML"))
    setProperty("failWhenNoMutations", false)
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}