import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.0"
    application
}

group = "me.igor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    val ktorVersion = "1.5.3"
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")

    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Google Cloud
    implementation(platform("com.google.cloud:libraries-bom:20.1.0"))
    implementation("com.google.cloud:google-cloud-datastore")

    // Tracing
    val openCensusVersion = "0.28.3"
    implementation("io.opencensus:opencensus-api:$openCensusVersion")
    implementation("io.opencensus:opencensus-exporter-trace-stackdriver:$openCensusVersion")
    runtimeOnly("io.opencensus:opencensus-impl:$openCensusVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}