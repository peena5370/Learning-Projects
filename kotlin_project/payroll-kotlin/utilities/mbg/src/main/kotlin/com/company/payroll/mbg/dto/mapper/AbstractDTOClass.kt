package com.company.payroll.mbg.dto.mapper

abstract class AbstractDTOClass<T, R>
{
    abstract fun toDTO(t: T): R
}