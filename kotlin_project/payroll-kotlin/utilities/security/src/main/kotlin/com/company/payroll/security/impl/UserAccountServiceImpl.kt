package com.company.payroll.security.impl

import com.company.payroll.mbg.mapper.AmsAccountStaffMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(@Autowired private val accountStaffMapper: AmsAccountStaffMapper): UserDetailsService
{
    override fun loadUserByUsername(username: String): UserDetails
    {
        val account = accountStaffMapper.selectByUsername(username)
        if (account.password.isEmpty())
        {
            throw UsernameNotFoundException("Username: \'$username\' is not exist in database.")
        }

        return User(account.username, account.password, ArrayList())
    }
}