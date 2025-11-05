plugins {
    id("java")
}

group = "com.company.payroll"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":utilities:common"))
    implementation(project(":utilities:mbg"))
    implementation(project(":utilities:security"))
}