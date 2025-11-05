import org.jetbrains.kotlin.gradle.dsl.jvm.JvmTargetValidationMode
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile


plugins {
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.2.21"
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.spring") version "2.0.0"
}

repositories {
    mavenCentral()
}

subprojects {
    val jaxbVersion = "4.0.6"
    val pageHelperVersion = "2.1.1"
    val openApiVersion = "2.8.14"
    val jacksonVersion = "3.0.1"
    val loggingVersin = "7.0.13"

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.allopen")

    repositories {
        mavenCentral()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencies {

        implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.glassfish.jaxb:jaxb-runtime:$jaxbVersion")
        implementation("com.github.pagehelper:pagehelper-spring-boot-starter:$pageHelperVersion")
        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$openApiVersion")
        implementation("tools.jackson.module:jackson-module-kotlin:$jacksonVersion")
        implementation("io.github.oshai:kotlin-logging-jvm:$loggingVersin")
        compileOnly("org.projectlombok:lombok")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
        runtimeOnly("io.github.oshai:kotlin-logging-jvm:$loggingVersin")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.security:spring-security-test")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<KotlinJvmCompile>().configureEach {
        jvmTargetValidationMode.set(JvmTargetValidationMode.WARNING)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.bootJar { enabled = false }
    tasks.jar { enabled = true }
}


dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
kotlin {
    jvmToolchain(17)
}