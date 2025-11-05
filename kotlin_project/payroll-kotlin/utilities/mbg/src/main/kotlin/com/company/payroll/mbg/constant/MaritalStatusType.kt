package com.company.payroll.mbg.constant

enum class MaritalStatusType: com.company.payroll.mbg.constant.EnumValue
{
    DIVORCED
    {
        override fun getValue() = "divorced"
    },
    MARRIED
    {
        override fun getValue() = "married"
    },
    SINGLE
    {
        override fun getValue() = "single"
    },
    OTHER
    {
        override fun getValue() = "other"
    }
}