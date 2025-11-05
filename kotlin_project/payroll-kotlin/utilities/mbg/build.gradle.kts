import org.jetbrains.kotlin.noarg.gradle.NoArgExtension

plugins {
    id("java")
    id( "org.jetbrains.kotlin.plugin.noarg") version "2.0.0"
}

group = "com.company.payroll"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3")
}

configure<NoArgExtension> {
    annotation("com.company.payroll.mbg.annotation.NoArg")
    invokeInitializers = true
}

allOpen {
    annotation("com.company.payroll.mbg.annotation.NoArg")
}