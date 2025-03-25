plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.10"
    application // ✅ Add this to enable `run` task
}

group = "com.rbbozkurt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    sourceSets.all {
        languageSettings.optIn("kotlinx.serialization.ExperimentalSerializationApi")
    }
    jvmToolchain(17)
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}

sourceSets {
    main {
        resources {
            srcDirs("configs")
        }
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

application {
    // ✅ Make sure this matches your main class file's fully qualified name
    mainClass.set("com.rbbozkurt.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
