import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "org.itmo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    val koinVersion = "3.2.2"
    implementation("io.insert-koin:koin-core:$koinVersion")
}

application {
    mainClass.set("lab4.MainKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "lab4.MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
