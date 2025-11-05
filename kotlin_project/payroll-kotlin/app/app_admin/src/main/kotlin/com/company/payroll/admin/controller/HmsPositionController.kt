package com.company.payroll.admin.controller

import com.company.payroll.mbg.dto.HmsPositionDetailDTO
import com.company.payroll.mbg.model.HmsPositionDetail
import com.company.payroll.position.service.HmsPositionService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/position")
class HmsPositionController(@Autowired private val hmsPositionService: HmsPositionService)
{

    // hms_position_detail ---------------------------------------------------------------------------------------------
    @GetMapping(params = ["offset", "limit"])
    fun getAllPositionDetailsByOffsetAndLimit(@RequestParam(name = "offset", required = false) offset: Int,
                                              @RequestParam(name = "limit",
                                                            required = false) limit: Int): ResponseEntity<String>
    {
        return ResponseEntity.ok("nothing: $offset & $limit");
    }

    // for reference getting multiple selection of items through request param
//    @GetMapping(params = ["list_ids"])
//    fun getTestWithMultiParam(@RequestParam("list_ids") ids: List<String>): ResponseEntity<String>
//    {
//
//        for (id in ids)
//        {
//            println("the id: $id");
//        }
//        return ResponseEntity.ok("success");
//    }

    @GetMapping("/{id}")
    fun getPositionDetailByPrimaryKey(@PathVariable id: Long): ResponseEntity<HmsPositionDetailDTO>
    {
        val response: ResponseEntity<HmsPositionDetailDTO>;
        val result = hmsPositionService.getPositionDetailById(id);

        response = if (result == null)
        {
            ResponseEntity.status(404).body(null);
        }
        else
        {
            ResponseEntity.ok(result);
        }

        return response;
    }

    @PostMapping
    fun createPositionDetail(@CookieValue("uid") uid: String,
                             @RequestBody hmsPositionDetailDTO: HmsPositionDetailDTO): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val duplicateValue = hmsPositionService.getPositionDetailByName(hmsPositionDetailDTO.name);

        if (duplicateValue != null)
        {
            response = ResponseEntity.status(400).body("duplicate value, cannot be insert");
        }
        else
        {
            // @TODO for getting uid from token
            val decodedUid: Long? = String(Base64.getDecoder().decode(uid)).toLongOrNull();

            val hmsPositionDetail =
                HmsPositionDetail(null, hmsPositionDetailDTO.name, hmsPositionDetailDTO.description, null, decodedUid);
            val status = hmsPositionService.createPositionDetail(hmsPositionDetail);
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

    @PutMapping("/{id}")
    fun updatePositionDetailById(@CookieValue("uid") uid: String,
                                 @RequestHeader("Authorization") token: String,
                                 @PathVariable("id") id: Long,
                                 @RequestBody hmsPositionDetailDTO: HmsPositionDetailDTO): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val currentPositionDetail = hmsPositionService.getPositionDetailById(id);
        val duplicateValue = hmsPositionService.getPositionDetailByName(hmsPositionDetailDTO.name);

        when
        {
            (id != hmsPositionDetailDTO.id) ->
            {
                response = ResponseEntity.status(405).body("update failed as the method not allowed");
            }

            (currentPositionDetail == null) ->
            {
                response = ResponseEntity.status(404).body("the data with specified id was not available");
            }

            (duplicateValue != null && hmsPositionDetailDTO.id != duplicateValue.id) ->
            {
                response = ResponseEntity.status(400).body("duplicate value, cannot be update");
            }

            else ->
            {
                val decodedUid: Long? = String(Base64.getDecoder().decode(uid)).toLongOrNull();

                val hmsPositionDetail = HmsPositionDetail(hmsPositionDetailDTO.id,
                                                          hmsPositionDetailDTO.name,
                                                          hmsPositionDetailDTO.description,
                                                          LocalDateTime.now(),
                                                          decodedUid);
                val status = hmsPositionService.updatePositionDetail(hmsPositionDetail);
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
    fun removePositionDetailById(@PathVariable("id") id: Long): ResponseEntity<String>
    {
        val response: ResponseEntity<String>;

        val currentPositionDetail = hmsPositionService.getPositionDetailById(id);
        val staffPositionDetails = hmsPositionService.getStaffPositionDetailByPositionDetailId(id);

        when
        {
            (currentPositionDetail == null) ->
            {
                response = ResponseEntity.status(404).body("the data with specified id was not available");
            }

            (! staffPositionDetails.isNullOrEmpty()) ->
            {
                response = ResponseEntity.status(400).body("position detail is in used by staff, cannot be delete");
            }

            else ->
            {
                val status = hmsPositionService.deletePositionDetailById(id);
                response = if (status == 1)
                {
                    ResponseEntity.ok("delete success");
                }
                else
                {
                    ResponseEntity.status(400).body("delete failed");
                }
            }
        }

        return response;
    }

    // hms_position_staff ----------------------------------------------------------------------------------------------
    @GetMapping("/staff/{staffId}", params = ["order"])
    fun getStaffPositionDetailByStaffIdWithOrder(@PathVariable("staffId") staffId: Long,
                                                 @RequestParam("order") order: String): ResponseEntity<List<String>>
    {
        val response: ResponseEntity<List<String>>;
        // get list of staff positions by staff id with sort order
        // if null return 404 not found
        // if not null, return to result

        println("staffId: $staffId & order is: $order")

        val list = listOf("elem1", "elem2");
        return ResponseEntity.ok(list);
    }

    @PostMapping("/{positionId}/staff/{staffId}")
    fun createStaffPositionDetailByIdAndStaffId(@PathVariable("positionId") id: Long,
                                                @PathVariable("staffId") staffId: Long): ResponseEntity<String>
    {
        println("id: $id and staffId: $staffId");

        // add staff position detail with position id and staff id
        // if 1 == success, 0 == fail

        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/{id}/staff/{staffId}")
    fun deleteStaffPositionDetailByIdAndStaffId(@PathVariable("id") id: Long,
                                                @PathVariable("staffId") staffId: Long): ResponseEntity<String>
    {
        println("id: $id and staffId: $staffId");

        // delete staff position by position id and staff id
        // if 1 == success, 0 == fail

        return ResponseEntity.ok("success");
    }
}