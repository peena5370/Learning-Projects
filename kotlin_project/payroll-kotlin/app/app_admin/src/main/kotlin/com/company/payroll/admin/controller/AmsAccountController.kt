package com.company.payroll.admin.controller

import com.company.payroll.mbg.constant.RoleType
import com.company.payroll.mbg.model.AmsAccountCredential
import com.company.payroll.mbg.model.AmsAccountStaff
import com.company.payroll.mbg.model.AmsAccountStaffProfile
import net.sf.jsqlparser.statement.select.Offset
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
@RequestMapping("/account")
class AmsAccountController
{
    @PostMapping
    fun addAccountStaff(amsAccountStaff: AmsAccountStaff): ResponseEntity<String>
    {
        // created together with account_staff_profile
        TODO("to be implemented")
    }

    @GetMapping("/{id}")
    fun getAccountStaffById(amsAccountStaff: AmsAccountStaff): ResponseEntity<AmsAccountStaff>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["offset", "limit"])
    fun getAccountStaffByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                        @RequestParam("limit",
                                                      required = false) limit: Int): ResponseEntity<List<AmsAccountStaff>>
    {
        TODO("to be implemented")
    }

    @PutMapping
    fun updateAccountStaff(amsAccountStaff: AmsAccountStaff): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}")
    fun deleteAccountStaffById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        // delete together with account_staff_profile
        TODO("to be implemented")
    }

    @GetMapping("/profile", params = ["account-id"])
    fun getAccountStaffProfileByAccountId(@RequestParam("account-id") accountId: Long): ResponseEntity<AmsAccountStaffProfile>
    {
        TODO("to be implemented")
    }

    @PutMapping("/profile/{id}")
    fun updateAccountStaffProfileById(amsAccountStaffProfile: AmsAccountStaffProfile): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/credential")
    fun addAccountCredential(): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/credential/types")
    fun getAllAccountCredentialType(): ResponseEntity<List<String>>
    {
        val result: MutableList<String> = mutableListOf();

        for (entry in RoleType.entries.toList())
        {
            result.add(entry.getValue())
        }

        return ResponseEntity.ok(result)
    }

    @GetMapping("/credential/{accountId}")
    fun getAllAccountCredentialByAccountId(@PathVariable("accountId") accountId: Long): ResponseEntity<List<AmsAccountCredential>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/credential/{id}")
    fun updateAccountCredentialById(amsAccountCredential: AmsAccountCredential): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/credential/{id}")
    fun removeAccountCredentialById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}