package com.company.payroll.admin.controller

import com.company.payroll.mbg.model.HmsResignationStaff
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
@RequestMapping("/resignation")
class HmsResignationController
{

    @PostMapping
    fun addResignationStaff(hmsResignationStaff: HmsResignationStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["offset", "limit"])
    fun getAllResignationStaffByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                               @RequestParam("limit",
                                                             required = false) limit: Int): ResponseEntity<List<HmsResignationStaff>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/{id}")
    fun getResignationStaffById(@PathVariable("id") id: Long): ResponseEntity<HmsResignationStaff>
    {
        TODO("to be implemented")
    }

    @PutMapping("/{id}")
    fun updateResignationStaffById(hmsResignationStaff: HmsResignationStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}")
    fun deleteResignationStaffById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}