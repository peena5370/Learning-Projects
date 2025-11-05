package com.company.payroll.admin.controller

import com.company.payroll.department.service.HmsDepartmentService
import com.company.payroll.mbg.dto.HmsDepartmentDetailDTO
import com.company.payroll.mbg.dto.HmsDepartmentRegionDTO
import com.company.payroll.mbg.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/department")
class HmsDepartmentController(@Autowired private val hmsDepartmentService: HmsDepartmentService)
{
    @PostMapping
    fun addDepartmentDetail(@RequestBody hmsDepartmentDetailDTO: HmsDepartmentDetailDTO): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val duplicateValue =
            hmsDepartmentService.getDepartmentDetailByDepartmentName(hmsDepartmentDetailDTO.departmentName);

        if (duplicateValue != null)
        {
            response = ResponseEntity.status(400).body("duplicated department name, cannot be insert");
        }
        else
        {
            // @TODO for getting uid from token
            val decodedUid: Long? = String(Base64.getDecoder().decode("MTIzNDU2Nzg5MjIzNDQ1MzIx")).toLongOrNull();

            val departmentDetail = HmsDepartmentDetail(null,
                                                       hmsDepartmentDetailDTO.departmentName,
                                                       hmsDepartmentDetailDTO.locationAddress,
                                                       hmsDepartmentDetailDTO.dateFormed,
                                                       hmsDepartmentDetailDTO.dateClosed,
                                                       hmsDepartmentDetailDTO.regionId,
                                                       LocalDateTime.now(),
                                                       decodedUid,
                                                       null);

            val status = hmsDepartmentService.createDepartmentDetail(departmentDetail);

            response = if (status == 1)
            {
                ResponseEntity.ok("insert success");
            }
            else
            {
                ResponseEntity.status(400).body("insert failed");
            }
        }

        return response;
    }

    @GetMapping
    fun getAllDepartmentDetailBySortFieldAndOffsetAndLimit(@RequestParam("field", required = false) field: String?,
                                                           @RequestParam("sort") sort: String?,
                                                           @RequestParam("offset", required = false) offset: Int?,
                                                           @RequestParam("limit",
                                                                         required = false) limit: Int?): ResponseEntity<List<HmsDepartmentDetailDTO>>
    {
        val response: ResponseEntity<List<HmsDepartmentDetailDTO>>;

        val list = hmsDepartmentService.getAllDepartmentDetailBySortFieldAndOffsetAndLimit(field, sort, offset, limit);

        response = if (list.isNullOrEmpty())
        {
            ResponseEntity.status(404).body(null);
        }
        else
        {
            ResponseEntity.ok(list);
        }

        return response;
    }

    @GetMapping("/{id}")
    fun getDepartmentDetailById(@PathVariable("id") id: Long): ResponseEntity<HmsDepartmentDetailDTO>
    {
        val response: ResponseEntity<HmsDepartmentDetailDTO>;

        val departmentDetail = hmsDepartmentService.getDepartmentDetailById(id);

        response = if (departmentDetail == null)
        {
            ResponseEntity.status(404).body(null);
        }
        else
        {
            ResponseEntity.ok(departmentDetail);
        }

        return response;
    }

    @PutMapping("/{id}")
    fun updateDepartmentDetailById(@RequestBody hmsDepartmentDetailDTO: HmsDepartmentDetailDTO,
                                   @PathVariable("id") id: Long): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val currentDepartmentDetail = hmsDepartmentService.getDepartmentDetailById(id);
        val duplicateValue =
            hmsDepartmentService.getDepartmentDetailByDepartmentName(hmsDepartmentDetailDTO.departmentName);

        when
        {
            (id != hmsDepartmentDetailDTO.id) ->
            {
                response = ResponseEntity.status(403).body("update failed as the method not allowed");
            }

            (currentDepartmentDetail == null) ->
            {
                response = ResponseEntity.status(404).body("the data with specified id was not available");
            }

            (duplicateValue != null && hmsDepartmentDetailDTO.id != duplicateValue.id) ->
            {
                response = ResponseEntity.status(400).body("duplicate value, cannot be update");
            }

            else ->
            {
                // @TODO for getting uid from token
                val decodedUid: Long? = String(Base64.getDecoder().decode("MTIzNDU2Nzg5MjIzNDQ1MzIx")).toLongOrNull();

                val departmentDetail = HmsDepartmentDetail(hmsDepartmentDetailDTO.id,
                                                           hmsDepartmentDetailDTO.departmentName,
                                                           hmsDepartmentDetailDTO.locationAddress,
                                                           hmsDepartmentDetailDTO.dateFormed,
                                                           hmsDepartmentDetailDTO.dateClosed,
                                                           hmsDepartmentDetailDTO.regionId,
                                                           LocalDateTime.now(),
                                                           decodedUid,
                                                           null);

                val status = hmsDepartmentService.updateDepartmentDetailById(departmentDetail);

                response = if (status == 1)
                {
                    ResponseEntity.ok("update success");
                }
                else
                {
                    ResponseEntity.status(400).body("update failed");
                }
            }
        }

        return response;
    }

    @DeleteMapping("/{id}")
    fun deleteDepartmentDetailById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val departmentLeaders = hmsDepartmentService.getDepartmentLeadersByDepartmentId(id);
        val departmentStaffs = hmsDepartmentService.getDepartmentStaffsByDepartmentId(id);

        if ((! departmentLeaders.isNullOrEmpty()) || (! departmentStaffs.isNullOrEmpty()))
        {
            response = ResponseEntity.status(400)
                .body("department with id: $id unable to delete as being used by department leaders/staffs.");
        }
        else
        {
            val status = hmsDepartmentService.deleteDepartmentDetailById(id);
            response = if (status == 1)
            {
                ResponseEntity.ok("delete success");
            }
            else
            {
                ResponseEntity.status(400).body("delete failed");
            }
        }

        return response;
    }

    @PostMapping("/region")
    fun addDepartmentRegion(@RequestBody hmsDepartmentRegionDTO: HmsDepartmentRegionDTO): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val duplicateValue = hmsDepartmentService.getDepartmentRegionByRegionCode(hmsDepartmentRegionDTO.regionCode);

        if (duplicateValue != null)
        {
            response = ResponseEntity.status(400).body("duplicated region code, cannot be insert");
        }
        else
        {
            // @TODO for getting uid from token
            val decodedUid: Long? = String(Base64.getDecoder().decode("MTIzNDU2Nzg5MjIzNDQ1MzIx")).toLongOrNull();

            val departmentRegion = HmsDepartmentRegion(null,
                                                       hmsDepartmentRegionDTO.regionCode,
                                                       hmsDepartmentRegionDTO.regionName,
                                                       LocalDateTime.now(),
                                                       decodedUid);

            val status = hmsDepartmentService.createDepartmentRegion(departmentRegion);

            response = if (status == 1)
            {
                ResponseEntity.ok("insert success");
            }
            else
            {
                ResponseEntity.status(400).body("insert failed");
            }
        }

        return response;
    }

    @GetMapping("/region")
    fun getAllDepartmentRegionByOffsetAndLimit(@RequestParam("field", required = false) field: String?,
                                               @RequestParam("sort", required = false) sort: String?,
                                               @RequestParam("offset", required = false) offset: Int?,
                                               @RequestParam("limit",
                                                             required = false) limit: Int?): ResponseEntity<List<HmsDepartmentRegionDTO>>
    {
        val response: ResponseEntity<List<HmsDepartmentRegionDTO>>;

        val list = hmsDepartmentService.getDepartmentRegionBySortFieldAndOffsetAndLimit(field, sort, offset, limit);

        response = if (list.isNullOrEmpty())
        {
            ResponseEntity.status(404).body(null);
        }
        else
        {
            ResponseEntity.ok(list);
        }

        return response;
    }

    @GetMapping("/region/{id}")
    fun getDepartmentRegionById(@PathVariable("id") id: Long): ResponseEntity<HmsDepartmentRegionDTO>
    {
        val response: ResponseEntity<HmsDepartmentRegionDTO>;

        val departmentRegion = hmsDepartmentService.getDepartmentRegionById(id);

        response = if (departmentRegion == null)
        {
            ResponseEntity.status(404).body(null);
        }
        else
        {
            ResponseEntity.ok(departmentRegion);
        }

        return response;
    }

    @PutMapping("/region/{id}")
    fun updateDepartmentRegionById(@RequestBody hmsDepartmentRegion: HmsDepartmentRegionDTO): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/region/{id}")
    fun deleteDepartmentRegionById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        // check is in used in department detail
        TODO("to be implemented")
    }

    @PostMapping("/{id}", params = ["leader-id"])
    fun createDepartmentLeaderByDepartmentIdAndLeaderId(@PathVariable("id") departmentId: Long,
                                                        @RequestParam("leader-id") leaderId: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/{id}", params = ["leader-ids"])
    fun createDepartmentLeaderByDepartmentIdAndLeaderIds(@PathVariable("id") departmentId: Long,
                                                         @RequestParam("leader-ids") leaderIds: List<Long>): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["leader-id"])
    fun getDepartmentDetailByLeaderId(@RequestParam("leader-id") leaderId: Long): ResponseEntity<HmsDepartmentLeader>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["department-id", "is-leader", "offset", "limit"])
    fun getAllDepartmentLeaderByDepartmentId(@RequestParam("department-id", required = true) departmentId: Long,
                                             @RequestParam("is-leader", required = true) isLeader: String,
                                             @RequestParam("offset", required = false) offset: Int,
                                             @RequestParam("limit",
                                                           required = false) limit: Int): ResponseEntity<List<HmsDepartmentLeader>>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}", params = ["leader-id"])
    fun deleteDepartmentLeaderByDepartmentIdAndLeaderId(@PathVariable("id") departmentId: Long,
                                                        @RequestParam("leader-id") leaderId: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}", params = ["leader-ids"])
    fun deleteDepartmentLeaderByDepartmentIdAndLeaderIds(@PathVariable("id") departmentId: Long,
                                                         @RequestParam("leader-ids") leaderIds: List<Long>): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/{id}", params = ["staff-id"])
    fun createDepartmentStaffByDepartmentIdAndStaffId(@PathVariable("id") departmentId: Long,
                                                      @RequestParam("staff-id") staffId: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/{id}", params = ["staff-ids"])
    fun createDepartmentStaffByDepartmentIdAndStaffIds(@PathVariable("id") departmentId: Long,
                                                       @RequestParam("staff-ids") staffIds: List<Long>): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["staff-id"])
    fun getDepartmentDetailByStaffId(@RequestParam("staff-id") staffId: Long): ResponseEntity<HmsDepartmentStaff>
    {
        TODO("to be implemented")
    }

    @GetMapping(params = ["department-id", "is-staff", "offset", "limit"])
    fun getAllDepartmentStaffByDepartmentId(@RequestParam("department-id", required = true) departmentId: Long,
                                            @RequestParam("is-staff", required = true) isStaff: String,
                                            @RequestParam("offset", required = false) offset: Int,
                                            @RequestParam("limit",
                                                          required = false) limit: Int): ResponseEntity<List<HmsDepartmentStaff>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/{id}", params = ["staff-id"])
    fun updateDepartmentStaffByDepartmentIdAndStaffId(@PathVariable("id") departmentId: Long,
                                                      @RequestParam("staff-id") staffId: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PutMapping("/{id}", params = ["staff-ids"])
    fun updateDepartmentStaffByDepartmentIdAndStaffIds(@PathVariable("id") departmentId: Long,
                                                       @RequestParam("staff-ids") staffIds: List<Long>): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}