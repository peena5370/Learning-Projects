plugins {
    id("java")
}

group = "com.company.payroll"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":utilities:mbg"))
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
}