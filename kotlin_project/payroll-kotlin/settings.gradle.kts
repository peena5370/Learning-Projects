plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "kotlin-payroll"
include(":app:app_admin")
include(":utilities:common")
include(":utilities:mbg")
include(":utilities:security")
include(":module:attendance")
include(":module:staff")
include("module:department")
include("module:loan")
include("module:account")
include("module:config")
include("module:payroll")
include("module:position")
include("module:resignation")
include("module:timeoff")
