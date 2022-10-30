plugins {
    id("java")
    id("application")
    id("io.github.kostyanoy.helios-push") version "1.0.1"
}

group = "lab3"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest.attributes("Main-Class" to "lab3.Main")
}

tasks.helios {
    projectName = "lab3"
    isu = "367379"
    folderPath = "~/labs/programming"
    val arr = arrayOf(
        "src",
        "build/libs/lab3-1.0-SNAPSHOT.jar",
        "build.gradle.kts",
        "settings.gradle.kts",
        "gradlew",
        "gradle"
    )
    files = arr
}

