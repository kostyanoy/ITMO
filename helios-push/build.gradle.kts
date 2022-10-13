plugins {
    id("java")
    id("java-gradle-plugin")
    id("maven-publish")
}

group = "org.itmo"
version = "1.0"

publishing.repositories.maven("$buildDir/repo")

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
}

gradlePlugin {
    plugins {
        create("helios-push") {
            id = "com.itmo.helios-push"
            implementationClass = "org.itmo.plugin.Helios"
        }
    }
}