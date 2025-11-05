package com.company.payroll.position.service.impl

import com.company.payroll.mbg.dto.HmsPositionDetailDTO
import com.company.payroll.mbg.dto.mapper.HmsPositionDetailDTOMapper
import com.company.payroll.mbg.mapper.HmsPositionDetailMapper
import com.company.payroll.mbg.mapper.HmsPositionStaffMapper
import com.company.payroll.mbg.model.HmsPositionDetail
import com.company.payroll.mbg.model.HmsPositionStaff
import com.company.payroll.position.service.HmsPositionService
import com.company.payroll.common.util.SnowFlakeIdGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class HmsPositionServiceImpl(private val snowFlakeIdGenerator: SnowFlakeIdGenerator,
                             @Autowired private val positionDetailMapper: HmsPositionDetailMapper,
                             @Autowired private val positionStaffDetailMapper: HmsPositionStaffMapper):
    HmsPositionService
{

    override fun getPositionDetailById(id: Long): HmsPositionDetailDTO?
    {
        val positionDetail = positionDetailMapper.selectByPrimaryKey(id);
        return positionDetail?.let { HmsPositionDetailDTOMapper.toDTO(it) };
    }

    override fun getPositionDetailByName(name: String): HmsPositionDetailDTO?
    {
        val positionDetail = positionDetailMapper.selectByName(name);
        return positionDetail?.let { HmsPositionDetailDTOMapper.toDTO(it) };
    }

    override fun createPositionDetail(hmsPositionDetail: HmsPositionDetail): Int
    {
        val positionDetail = HmsPositionDetail(snowFlakeIdGenerator.nextId(),
                                               hmsPositionDetail.name,
                                               hmsPositionDetail.description,
                                               LocalDateTime.now(),
                                               hmsPositionDetail.modifiedBy);

        return positionDetailMapper.insert(positionDetail);
    }

    override fun updatePositionDetail(hmsPositionDetail: HmsPositionDetail): Int
    {
        return positionDetailMapper.updateByPrimaryKeyWithBLOBs(hmsPositionDetail);
    }

    override fun deletePositionDetailById(id: Long): Int
    {
        return positionDetailMapper.deleteByPrimaryKey(id);
    }

    override fun getStaffPositionDetailByOrder(staffId: Long, sortOrder: String): List<HmsPositionStaff>
    {
        TODO("Not yet implemented")
    }

    override fun getStaffPositionDetailByPositionDetailId(positionDetailId: Long): List<HmsPositionStaff>?
    {
        return positionStaffDetailMapper.selectByPositionId(positionDetailId);
    }

    override fun insertStaffPosition(hmsPositionStaff: HmsPositionStaff): Int
    {
        TODO("Not yet implemented")
    }

    override fun updateStaffPositions(hmsPositionStaffs: List<HmsPositionStaff>): Int
    {
        TODO("Not yet implemented")
    }

    override fun deleteStaffPosition(id: Long): Int
    {
        return positionStaffDetailMapper.deleteByPrimaryKey(id);
    }
}