package com.company.payroll.attendance.service.impl

import com.company.payroll.attendance.service.HmsAttendanceStaffService
import com.company.payroll.mbg.dto.HmsAttendanceStaffDTO
import com.company.payroll.mbg.dto.mapper.HmsAttendanceStaffDTOMapper
import com.company.payroll.mbg.mapper.HmsAttendanceStaffMapper
import com.company.payroll.mbg.model.HmsAttendanceStaff
import com.company.payroll.common.util.SnowFlakeIdGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class HmsAttendanceStaffServiceImpl(private val snowFlakeIdGenerator: SnowFlakeIdGenerator,
                                    @Autowired private val hmsAttendanceStaffMapper: HmsAttendanceStaffMapper):
    HmsAttendanceStaffService
{
    override fun insertAttendanceByStaffId(staffId: Long): Int
    {
        val result: Int;
        val todayDate: LocalDate = LocalDate.now();

        val list = hmsAttendanceStaffMapper.selectByStaffIdAndAttendanceDate(staffId, todayDate);
        if (list.isNullOrEmpty())
        {
            val attendanceStaff =
                HmsAttendanceStaff(snowFlakeIdGenerator.nextId(), todayDate, LocalDateTime.now(), 1, staffId);

            result = hmsAttendanceStaffMapper.insert(attendanceStaff);
        }
        else
        {
            val lastElem = list.last();
            lastElem.attendanceOrder;

            val attendanceStaff = HmsAttendanceStaff(snowFlakeIdGenerator.nextId(),
                                                     todayDate,
                                                     LocalDateTime.now(),
                                                     lastElem.attendanceOrder + 1,
                                                     staffId);

            result = hmsAttendanceStaffMapper.insert(attendanceStaff);
        }

        return result;
    }

    override fun getAttendanceByStaffIdAndDateRange(staffId: Long,
                                                    dateStart: LocalDate,
                                                    dateEnd: LocalDate,
                                                    offset: Int?,
                                                    limit: Int?): List<HmsAttendanceStaffDTO>?
    {
        val result = mutableListOf<HmsAttendanceStaffDTO>();

        val attendanceStaffs =
            hmsAttendanceStaffMapper.selectByStaffIdAndDateRange(staffId, dateStart, dateEnd, offset ?: 0, limit ?: 5);

        if (attendanceStaffs.isNullOrEmpty())
        {
            return null;
        }
        else
        {
            val attendanceStaffDTOs = mutableListOf<HmsAttendanceStaffDTO>();

            for (attendanceStaff in attendanceStaffs)
            {
                attendanceStaffDTOs.add(HmsAttendanceStaffDTOMapper.toDTO(attendanceStaff));
            }

            result.addAll(attendanceStaffDTOs);
        }

        return result;
    }

    override fun getSumOfTotalWorkingHoursForStaffByStaffIdAndDateRange(staffId: Long,
                                                                        dateStart: LocalDate,
                                                                        dateEnd: LocalDate): Double?
    {
        TODO("Not yet implemented")
    }
}