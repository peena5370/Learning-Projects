package com.company.payroll.admin.controller

import com.company.payroll.config.service.HmsConfigService
import com.company.payroll.mbg.model.HmsConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/config")
class HmsConfigController(@Autowired private val hmsConfigService: HmsConfigService)
{
    @GetMapping
    fun getAllConfig(): ResponseEntity<List<HmsConfig>>
    {
        val result: ResponseEntity<List<HmsConfig>>;

        val list = hmsConfigService.getAllConfigSetup();

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

    @GetMapping(params = ["type"])
    fun getAllConfigByType(@RequestParam("type") type: String): ResponseEntity<List<HmsConfig>>
    {
        val result: ResponseEntity<List<HmsConfig>>;

        val list = hmsConfigService.getAllConfigByType(type);

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

    @PutMapping("/{id}")
    fun updateConfigById(@RequestBody hmsConfig: HmsConfig): ResponseEntity<String>
    {
        val result: ResponseEntity<String>;

        val status = hmsConfigService.updateConfigById(hmsConfig);

        result = if (status == 0)
        {
            ResponseEntity.status(400).body("failed to update value");
        }
        else
        {
            ResponseEntity.ok("success update the value");
        }

        return result;
    }
}