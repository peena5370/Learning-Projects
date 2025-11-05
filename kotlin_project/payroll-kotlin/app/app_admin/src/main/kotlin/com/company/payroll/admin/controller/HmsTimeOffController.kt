package com.company.payroll.admin.controller

import com.company.payroll.mbg.model.HmsTimeoffStaff
import com.company.payroll.mbg.model.HmsTimeoffType
import com.company.payroll.mbg.model.HmsTimeoffTypeBalance
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/time-off")
class HmsTimeOffController
{
    @PostMapping
    fun addTimeOffStaff(hmsTimeoffStaff: HmsTimeoffStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/{id}")
    fun getTimeOffStaffById(@PathVariable("id") id: Long): ResponseEntity<HmsTimeoffStaff>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["offset", "limit"])
    fun getTimeOffStaffByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                        @RequestParam("limit",
                                                      required = false) limit: Int): ResponseEntity<List<HmsTimeoffStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["staff-id"])
    fun getTimeOffStaffByStaffId(@RequestParam("staff-id",
                                               required = true) staffId: Long): ResponseEntity<List<HmsTimeoffStaff>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/{id}")
    fun updateTimeOffStaffById(hmsTimeoffStaff: HmsTimeoffStaff): ResponseEntity<String>
    {
        // will change the time off type balance based on the status approval
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}", params = ["staff-id"])
    fun deleteTimeOffStaffById(@PathVariable("id") id: Long,
                               @RequestParam("staff-id", required = false) staffId: Long): ResponseEntity<String>
    {
        // here will have 2 types of delete, 1 is for staff, the other one is for admin.
        // admin able to delete any status of time off, and staff will check for parameter, if the url having staff-id,
        // will go to check the status, if the time off not yet approved or changed to another status, will allow staff to delete
        // the time off
        TODO("to be implemented")
    }

    @PostMapping("/type")
    fun addTimeOffType(hmsTimeoffType: HmsTimeoffType): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/type/{id}")
    fun getTimeOffTypeById(@PathVariable("id") id: Long): ResponseEntity<HmsTimeoffType>
    {
        TODO("to be implemented")
    }

    @GetMapping("/type", params = ["offset", "limit"])
    fun getTimeOffTypeByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                       @RequestParam("limit",
                                                     required = false) limit: Int): ResponseEntity<List<HmsTimeoffType>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/type/{id}")
    fun updateTimeOffTypeById(hmsTimeoffType: HmsTimeoffType): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/type/{id}")
    fun deleteTimeOffTypeById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        // will go to check is any time off staff using that type, if got block the delete process
        // will remove together with the time off type balance
        TODO("to be implemented")
    }

    @PostMapping("/balance")
    fun addTimeOffStaffBalance(hmsTimeoffTypeBalance: HmsTimeoffTypeBalance): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/balance/staff/{staffId}")
    fun getTimeOffStaffBalanceByStaffId(@PathVariable("staffId") staffId: Long): ResponseEntity<List<HmsTimeoffTypeBalance>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/balance/{id}")
    fun updateTimeOffStaffBalanceById(hmsTimeoffTypeBalance: HmsTimeoffTypeBalance): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}