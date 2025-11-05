package com.company.payroll.mbg.constant

enum class RoleType: com.company.payroll.mbg.constant.EnumValue
{
    COMMON_USER
    {
        override fun getValue() = "common_user"
    },
    MANAGER_ADMIN
    {
        override fun getValue() = "manager_admin"
    },
    MANAGER_LEADER
    {
        override fun getValue() = "manager_leader"
    },
    SYS_ADMIN
    {
        override fun getValue() = "system_admin"
    },
    SYS_USER
    {
        override fun getValue() = "system_user"
    }
}