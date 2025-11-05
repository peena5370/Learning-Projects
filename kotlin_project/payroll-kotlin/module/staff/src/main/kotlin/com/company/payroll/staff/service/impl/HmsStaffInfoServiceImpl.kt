package com.company.payroll.staff.service.impl

import com.company.payroll.mbg.model.HmsStaffDetail
import com.company.payroll.mbg.model.HmsPositionStaff
import com.company.payroll.staff.service.HmsStaffInfoService
import com.company.payroll.common.util.SnowFlakeIdGenerator
import org.springframework.stereotype.Service

@Service
class HmsStaffInfoServiceImpl(

    private val snowFlakeIdGenerator: SnowFlakeIdGenerator
//    @Autowired
/*private val hmsStaffJobTitleMapper: HmsStaffJobTitleMapper*/): HmsStaffInfoService
{
    override fun findStaffById(staffId: Long): HmsStaffDetail? {
        return null;
    }

    override fun insertStaffJobTitle(staffJobTitle: HmsPositionStaff): Int {
        staffJobTitle.id = snowFlakeIdGenerator.nextId();
//        return hmsStaffJobTitleMapper.insert(staffJobTitle);
        return 0;
    }
}