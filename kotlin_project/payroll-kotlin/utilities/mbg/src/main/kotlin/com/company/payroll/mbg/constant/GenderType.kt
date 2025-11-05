package com.company.payroll.mbg.constant

enum class GenderType: com.company.payroll.mbg.constant.EnumValue
{
    FEMALE
    {
        override fun getValue() = "female"
    },
    MALE
    {
        override fun getValue() = "male"
    },
    OTHER
    {
        override fun getValue() = "other"
    }
}