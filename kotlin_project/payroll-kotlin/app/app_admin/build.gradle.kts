plugins {
    id("java")
}

group = "com.company.payroll"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":utilities:security"))
    implementation(project(":utilities:mbg"))

    implementation(project(":module:attendance"))
    implementation(project(":module:config"))
    implementation(project(":module:department"))
    implementation(project(":module:position"))
}