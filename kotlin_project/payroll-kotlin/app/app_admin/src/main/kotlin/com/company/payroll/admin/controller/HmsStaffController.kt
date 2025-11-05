package com.company.payroll.admin.controller

import com.company.payroll.mbg.model.HmsStaffAppraisal
import com.company.payroll.mbg.model.HmsStaffDetail
import com.company.payroll.mbg.model.HmsStaffFilestore
import com.company.payroll.mbg.model.HmsStaffTrainingDetail
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/staff")
class HmsStaffController
{
    @PostMapping("/appraisal")
    fun addStaffAppraisal(hmsStaffAppraisal: HmsStaffAppraisal): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/appraisal/{id}")
    fun getStaffAppraisalById(@PathVariable("id") id: Long): ResponseEntity<HmsStaffAppraisal>
    {
        TODO("to be implemented")
    }

    @GetMapping("/appraisal", params = ["offset", "limit"])
    fun getStaffAppraisalByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                          @RequestParam("limit",
                                                        required = false) limit: Int): ResponseEntity<List<HmsStaffAppraisal>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/appraisal", params = ["staff-id"])
    fun getStaffAppraisalByStaffId(@RequestParam("staff-id", required = true) staffId: Long)
    {
        TODO("to be implemented")
    }

    @PutMapping("/appraisal/{id}")
    fun updateStaffAppraisalById(hmsStaffAppraisal: HmsStaffAppraisal): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/appraisal/{id}")
    fun deleteStaffAppraisalById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping
    fun addStaffDetail(hmsStaffDetail: HmsStaffDetail): ResponseEntity<String>
    {
        // will done together with create staff banking, staff salary, and if got file, will insert together with staff filestore
        TODO("to be implemented")
    }

    @GetMapping("/{id}")
    fun getStaffDetailById(@PathVariable("id") id: Long): ResponseEntity<HmsStaffDetail>
    {
        // will get together with all the staff related information, banking, salary, file store file
        TODO("to be implemented")
    }

    @GetMapping(params = ["offset", "limit"])
    fun getAllStaffDetailByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                          @RequestParam("limit",
                                                        required = false) limit: Int): ResponseEntity<List<HmsStaffDetail>>
    {
        // only list out some of the important information for table view, which may includes staff detail, banking and salary
        TODO("to be implemented")
    }

    @PutMapping("/{id}")
    fun updateStaffDetailById(hmsStaffDetail: HmsStaffDetail): ResponseEntity<String>
    {
        // may check and update data based on the information passed in, for example, if only staff detail got changes, just
        // change the staff detail, if all of the information got changes, then update them all with transaction
        TODO("to be implemented")
    }

    @DeleteMapping("/{id}")
    fun deleteStaffDetailById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        // #1 this one will be iterated through the whole system on checking in loan, attendance, payroll, resignation, training and timeoff
        // if got one of the date inside the other places, not allow user to delete
        // #2 will delete all together with account, account profile, department leader/staff, position staff, banking, salary, file store,
        // and at last only delete detail
        TODO("to be implemented")
    }

    @PostMapping("/training")
    fun addStaffTrainingDetail(hmsStaffTrainingDetail: HmsStaffTrainingDetail): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/training/{id}")
    fun getStaffTrainingDetailById(@PathVariable("id") id: Long): ResponseEntity<HmsStaffTrainingDetail>
    {
        TODO("to be implemented")
    }

    @GetMapping("/training", params = ["offset", "limit"])
    fun getStaffTrainingDetailByOffsetAndLimit(@RequestParam("offset", required = false) offset: Int,
                                               @RequestParam("limit",
                                                             required = false) limit: Int): ResponseEntity<List<HmsStaffTrainingDetail>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/training", params = ["staff-id"])
    fun getStaffTrainingDetailByStaffId(@RequestParam("staff-id",
                                                      required = true) staffId: Long): ResponseEntity<List<HmsStaffTrainingDetail>>
    {
        TODO("to be implemented")
    }

    @PutMapping("/training/{id}")
    fun updateStaffTrainingDetailById(hmsStaffTrainingDetail: HmsStaffTrainingDetail): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/training/{id}")
    fun deleteStaffTrainingDetailById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @PostMapping("/{staffId}/file-store/upload", params = ["is-multiple"])
    fun uploadStaffFile(@PathVariable("staffId") staffId: Long,
                        @RequestParam("is-multiple", required = true) isMultiple: String,
                        @RequestParam("file", required = false) file: MultipartFile?,
                        @RequestParam("files", required = false) files: Array<MultipartFile>?): ResponseEntity<String>
    {
        TODO("to be implemented")
    }

    @GetMapping("/file-store/{staffId}")
    fun getStaffFileByStaffId(@PathVariable("staffId") staffId: Long): ResponseEntity<List<HmsStaffFilestore>>
    {
        TODO("to be implemented")
    }

    @GetMapping("/file-store/{id}/download")
    fun downloadStaffFileById(@PathVariable("id") id: Long): ResponseEntity<Resource>
    {
        TODO("to be implemented")
    }

    @DeleteMapping("/file-store/{id}")
    fun deleteFileStoreById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        TODO("to be implemented")
    }
}