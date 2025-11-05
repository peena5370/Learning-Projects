package com.company.payroll.admin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HmsLoginController
{
    @PostMapping("/back-end/login")
    fun validateBackendLogin(): ResponseEntity<String>
    {
        // need a param here
        TODO("to be implemented")
    }

    @PostMapping("/user/login")
    fun validateUserLogin(): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/back-end/logout")
    fun invalidateBackendLogin(): ResponseEntity<String>
    {
        // will invalidate the token expiry date time here
        TODO("to be implemented")
    }

    @PostMapping("/user/logout")
    fun invalidateUserLogin(): ResponseEntity<String>
    {
        // will invalidate the token expiry date time here
        TODO("to be implemented")
    }

    @PostMapping("/generate-token")
    fun generateAccessToken(): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/refresh-token")
    fun refreshAccessToken(): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}