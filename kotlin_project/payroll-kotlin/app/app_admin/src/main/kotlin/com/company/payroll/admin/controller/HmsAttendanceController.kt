package com.company.payroll.admin.controller

import com.company.payroll.attendance.service.HmsAttendanceStaffService
import com.company.payroll.mbg.dto.HmsAttendanceStaffDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/attendance")
class HmsAttendanceController(@Autowired private val hmsAttendanceStaffService: HmsAttendanceStaffService)
{
    @PostMapping(params = ["staff-id"])
    fun addAttendanceByStaffId(@RequestParam("staff-id", required = true) staffId: Long): ResponseEntity<String>
    {
        val result: ResponseEntity<String>;

        val status = hmsAttendanceStaffService.insertAttendanceByStaffId(staffId);

        result = if (status == 0)
        {
            ResponseEntity.status(400).body("unable to insert attendance record for staff-id: $staffId");
        }
        else
        {
            ResponseEntity.ok("success inserted attendance record for staff-id: $staffId");
        }

        return result;
    }

    @GetMapping
    fun getAttendanceByStaffIdAndDateRange(@RequestParam("staff-id", required = true) staffId: Long,
                                           @RequestParam("date-start", required = true) dateStart: LocalDate,
                                           @RequestParam("date-end", required = true) dateEnd: LocalDate,
                                           @RequestParam("offset", required = false) offset: Int?,
                                           @RequestParam("limit",
                                                         required = false) limit: Int?): ResponseEntity<List<HmsAttendanceStaffDTO>>
    {
        val result: ResponseEntity<List<HmsAttendanceStaffDTO>>;

        val list =
            hmsAttendanceStaffService.getAttendanceByStaffIdAndDateRange(staffId, dateStart, dateEnd, offset, limit);

        result = if (list.isNullOrEmpty())
        {
            ResponseEntity.status(404).body(null);
        }
        else
        {
            ResponseEntity.ok(list);
        }

        return result;
    }

    // @todo for new sum of the attendance hours based on staff date range and staff id
}