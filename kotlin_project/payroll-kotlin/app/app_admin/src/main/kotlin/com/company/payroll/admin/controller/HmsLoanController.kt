package com.company.payroll.admin.controller

import com.company.payroll.mbg.model.HmsLoanStaff
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
@RequestMapping("/loan")
class HmsLoanController
{
    @PostMapping
    fun addLoanDetail(hmsLoanStaff: HmsLoanStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/apply-date", params = ["date-start", "date-end", "offset", "limit"])
    fun getLoanDetailByApplyDateWithDateRange(@RequestParam("date-start", required = true) dateStart: LocalDate,
                                              @RequestParam("date-end", required = true) dateEnd: LocalDate,
                                              @RequestParam("offset", required = false) offset: Int,
                                              @RequestParam("limit",
                                                            required = false) limit: Int): ResponseEntity<List<HmsLoanStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/approved-date", params = ["date-start", "date-end", "offset", "limit"])
    fun getLoanDetailByApprovedDateWithDateRange(@RequestParam("date-start", required = true) dateStart: LocalDate,
                                                 @RequestParam("date-end", required = true) dateEnd: LocalDate,
                                                 @RequestParam("offset", required = false) offset: Int,
                                                 @RequestParam("limit",
                                                               required = false) limit: Int): ResponseEntity<List<HmsLoanStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/{id}")
    fun getLoanDetailById(@PathVariable("id") id: Long): ResponseEntity<HmsLoanStaff>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["staff-id"])
    fun getLoanDetailByStaffId(@RequestParam("staff-id",
                                             required = true) staffId: Long): ResponseEntity<List<HmsLoanStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["status", "offset", "limit"])
    fun getLoanDetailByStatusAndOffsetAndLimit(@RequestParam("status", required = true) status: String,
                                               @RequestParam("offset", required = false) offset: Int,
                                               @RequestParam("limit",
                                                             required = false) limit: Int): ResponseEntity<List<HmsLoanStaff>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/{id}")
    fun updateLoanDetailById(hmsLoanStaff: HmsLoanStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}")
    fun deleteLoanDetailById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        // check user, if is normal staff, check the status, if is pending allow delete, else cannot delete
        // if is admin, can delete in any status
        TODO("to be implemented")
    }
}