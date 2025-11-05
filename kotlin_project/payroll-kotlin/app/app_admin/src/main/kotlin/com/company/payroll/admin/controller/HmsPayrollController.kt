package com.company.payroll.admin.controller

import com.company.payroll.mbg.model.HmsPayrollStaff
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/payroll")
class HmsPayrollController
{
    @PostMapping(params = ["is-bulk"])
    fun addPayrollStaff(@RequestParam("is-bulk") isBulk: String,
                        hmsPayrollStaffs: List<HmsPayrollStaff>?,
                        hmsPayrollStaff: HmsPayrollStaff?): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/{id}")
    fun getPayrollStaffById(@PathVariable("id") id: Long): ResponseEntity<HmsPayrollStaff>
    {
        TODO("to be implemented")
    }

    @GetMapping("/date-issue", params = ["date-start", "date-end", "offset", "limit"])
    fun getPayrollStaffByDateIssueAndOffsetAndLimit(@RequestParam("date-start", required = true) dateStart: LocalDate,
                                                    @RequestParam("date-end", required = true) dateEnd: LocalDate,
                                                    @RequestParam("offset", required = false) offset: Int,
                                                    @RequestParam("limit",
                                                                  required = false) limit: Int): ResponseEntity<List<HmsPayrollStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/payroll-period", params = ["date-start", "date-end", "offset", "limit"])
    fun getPayrollStaffByPayPeriodAndOffsetAndLimit(@RequestParam("date-start", required = true) dateStart: LocalDate,
                                                    @RequestParam("date-end", required = true) dateEnd: LocalDate,
                                                    @RequestParam("offset", required = false) offset: Int,
                                                    @RequestParam("limit",
                                                                  required = false) limit: Int): ResponseEntity<List<HmsPayrollStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["staff-id", "offset", "limit"])
    fun getPayrollStaffByStaffId(@RequestParam("staff-id", required = true) staffId: Long,
                                 @RequestParam("offset", required = false) offset: Int,
                                 @RequestParam("limit",
                                               required = false) limit: Int): ResponseEntity<List<HmsPayrollStaff>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/{id}")
    fun updatePayrollStaffById(hmsPayrollStaff: HmsPayrollStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}")
    fun deletePayrollStaffById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}