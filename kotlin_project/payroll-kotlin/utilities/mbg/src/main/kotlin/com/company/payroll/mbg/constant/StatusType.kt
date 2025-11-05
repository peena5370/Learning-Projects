package com.company.payroll.mbg.constant

enum class StatusType: com.company.payroll.mbg.constant.StatusValue
{
    ONGOING
    {
        override fun getByteValue(): UByte = 0u
    },
    APPROVED
    {
        override fun getByteValue(): UByte = 1u
    },
    REJECTED
    {
        override fun getByteValue(): UByte = 2u
    },
    COMPLETED
    {
        override fun getByteValue(): UByte = 1u
    },
    LOCKED
    {
        override fun getByteValue(): UByte = 2u
    }
}