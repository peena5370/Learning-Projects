package com.company.payroll.department.service.impl

import com.company.payroll.common.util.SnowFlakeIdGenerator
import com.company.payroll.department.service.HmsDepartmentService
import com.company.payroll.mbg.dto.HmsDepartmentDetailDTO
import com.company.payroll.mbg.dto.HmsDepartmentRegionDTO
import com.company.payroll.mbg.dto.mapper.HmsDepartmentDetailDTOMapper
import com.company.payroll.mbg.dto.mapper.HmsDepartmentRegionDTOMapper
import com.company.payroll.mbg.mapper.HmsDepartmentDetailMapper
import com.company.payroll.mbg.mapper.HmsDepartmentLeaderMapper
import com.company.payroll.mbg.mapper.HmsDepartmentRegionMapper
import com.company.payroll.mbg.mapper.HmsDepartmentStaffMapper
import com.company.payroll.mbg.model.HmsDepartmentDetail
import com.company.payroll.mbg.model.HmsDepartmentLeader
import com.company.payroll.mbg.model.HmsDepartmentRegion
import com.company.payroll.mbg.model.HmsDepartmentStaff
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HmsDepartmentServiceImpl(private val snowFlakeIdGenerator: SnowFlakeIdGenerator,
                               @Autowired private val hmsDepartmentDetailMapper: HmsDepartmentDetailMapper,
                               @Autowired private val hmsDepartmentLeaderMapper: HmsDepartmentLeaderMapper,
                               @Autowired private val hmsDepartmentStaffMapper: HmsDepartmentStaffMapper,
                               @Autowired private val hmsDepartmentRegionMapper: HmsDepartmentRegionMapper):
    HmsDepartmentService
{
    override fun getAllDepartmentDetailBySortFieldAndOffsetAndLimit(field: String?,
                                                                    sort: String?,
                                                                    offset: Int?,
                                                                    limit: Int?): List<HmsDepartmentDetailDTO>?
    {
        val result = mutableListOf<HmsDepartmentDetailDTO>();

        // for filter the field and direction out from front end to prevent sql injection
        val sortField: String = when
        {
            field.equals("dept_name") -> "hdd.department_name";
            field.equals("address") -> "hdd.location_address";
            field.equals("date_formed") -> "hdd.date_formed";
            field.equals("date_closed") -> "hdd.date_closed";
            field.equals("region_code") -> "hdr.region_code";
            field.equals("region_name") -> "hdr.region_name";
            else -> "hdd.id";
        }

        val sortDirection: String = when
        {
            sort.equals("descending") -> "desc";
            else -> "asc";
        }

        val departmentList =
            hmsDepartmentDetailMapper.selectAllByOffsetAndLimit(sortField, sortDirection, offset ?: 0, limit ?: 5);

        if (departmentList.isNullOrEmpty())
        {
            return null;
        }
        else
        {
            for (departmentDetail in departmentList)
            {
                result.add(HmsDepartmentDetailDTOMapper.toDTO(departmentDetail));
            }
        }

        return result;
    }

    override fun getDepartmentDetailById(id: Long): HmsDepartmentDetailDTO?
    {
        val departmentDetail = hmsDepartmentDetailMapper.selectByPrimaryKey(id);
        return departmentDetail?.let { HmsDepartmentDetailDTOMapper.toDTO(it) };
    }

    override fun getDepartmentDetailByDepartmentName(departmentName: String): HmsDepartmentDetailDTO?
    {
        val departmentDetail = hmsDepartmentDetailMapper.selectByDepartmentName(departmentName);
        return departmentDetail?.let { HmsDepartmentDetailDTOMapper.toDTO(it) };
    }

    override fun createDepartmentDetail(hmsDepartmentDetail: HmsDepartmentDetail): Int
    {
        val departmentDetail = HmsDepartmentDetail(snowFlakeIdGenerator.nextId(),
                                                   hmsDepartmentDetail.departmentName,
                                                   hmsDepartmentDetail.locationAddress,
                                                   hmsDepartmentDetail.dateFormed,
                                                   hmsDepartmentDetail.dateClosed,
                                                   hmsDepartmentDetail.regionId,
                                                   hmsDepartmentDetail.modifiedDate,
                                                   hmsDepartmentDetail.modifiedBy,
                                                   null);

        return hmsDepartmentDetailMapper.insert(departmentDetail);
    }

    override fun updateDepartmentDetailById(hmsDepartmentDetail: HmsDepartmentDetail): Int
    {
        return hmsDepartmentDetailMapper.updateByPrimaryKey(hmsDepartmentDetail);
    }

    override fun deleteDepartmentDetailById(id: Long): Int
    {
        return hmsDepartmentDetailMapper.deleteByPrimaryKey(id);
    }

    override fun getDepartmentDetailByLeaderId(leaderId: Long): HmsDepartmentLeader?
    {
        TODO("Not yet implemented")
    }

    override fun getDepartmentLeadersByDepartmentId(departmentId: Long): List<HmsDepartmentLeader>?
    {
        return hmsDepartmentLeaderMapper.selectAllByDepartmentId(departmentId);
    }

    override fun addDepartmentLeader(departmentId: Long, leaderId: Long): Int
    {
        TODO("Not yet implemented")
    }

    override fun addDepartmentLeaders(departmentId: Long, leaderIds: List<Long>): Int
    {
        TODO("Not yet implemented")
    }

    override fun deleteDepartmentLeaderByDepartmentIdAndLeaderId(departmentId: Long, leaderId: Long): Int
    {
        TODO("Not yet implemented")
    }

    override fun deleteDepartmentLeadersByDepartmentIdAndLeaderIds(departmentId: Long, leaderIds: List<Long>): Int
    {
        TODO("Not yet implemented")
    }

    override fun getDepartmentRegionById(id: Long): HmsDepartmentRegionDTO?
    {
        val departmentRegion = hmsDepartmentRegionMapper.selectByPrimaryKey(id);
        return departmentRegion?.let { HmsDepartmentRegionDTOMapper.toDTO(it) };
    }

    override fun getDepartmentRegionByRegionCode(regionCode: String): HmsDepartmentRegion?
    {
        return hmsDepartmentRegionMapper.selectByRegionCode(regionCode);
    }

    override fun getDepartmentRegionBySortFieldAndOffsetAndLimit(field: String?,
                                                                 sort: String?,
                                                                 offset: Int?,
                                                                 limit: Int?): List<HmsDepartmentRegionDTO>?
    {
        val result = mutableListOf<HmsDepartmentRegionDTO>();

        // for filter the field and direction out from front end to prevent sql injection
        val sortField: String = when
        {
            field.equals("region_code") -> "region_code";
            field.equals("region_name") -> "region_name";
            else -> "id";
        }

        val sortDirection: String = when
        {
            sort.equals("descending") -> "desc";
            else -> "asc";
        }

        val departmentRegionList =
            hmsDepartmentRegionMapper.selectAllByOffsetAndLimit(sortField, sortDirection, offset ?: 0, limit ?: 5);

        if (departmentRegionList.isNullOrEmpty())
        {
            return null;
        }
        else
        {
            for (departmentRegion in departmentRegionList)
            {
                result.add(HmsDepartmentRegionDTOMapper.toDTO(departmentRegion));
            }
        }

        return result;
    }

    override fun createDepartmentRegion(hmsDepartmentRegion: HmsDepartmentRegion): Int
    {
        val departmentRegion = HmsDepartmentRegion(snowFlakeIdGenerator.nextId(),
                                                      hmsDepartmentRegion.regionCode,
                                                      hmsDepartmentRegion.regionName,
                                                      hmsDepartmentRegion.modifiedDate,
                                                      hmsDepartmentRegion.modifiedBy);

        return hmsDepartmentRegionMapper.insert(departmentRegion);
    }

    override fun updateDepartmentRegion(hmsDepartmentRegion: HmsDepartmentRegion): Int
    {
        return hmsDepartmentRegionMapper.updateByPrimaryKey(hmsDepartmentRegion);
    }

    override fun deleteDepartmentRegionById(id: Long): Int
    {
        return hmsDepartmentRegionMapper.deleteByPrimaryKey(id);
    }

    override fun getDepartmentStaffByStaffId(staffId: Long): HmsDepartmentStaff
    {
        TODO("Not yet implemented")
    }

    override fun getDepartmentStaffsByDepartmentId(departmentId: Long): List<HmsDepartmentStaff>?
    {
        return hmsDepartmentStaffMapper.selectAllByDepartmentId(departmentId);
    }

    override fun addDepartmentStaff(departmentId: Long, staffId: Long): Int
    {
        TODO("Not yet implemented")
    }

    override fun addDepartmentStaffs(departmentId: Long, staffIds: List<Long>): Int
    {
        TODO("Not yet implemented")
    }

    override fun deleteDepartmentStaffByDepartmentIdAndStaffId(departmentId: Long, staffId: Long): Int
    {
        TODO("Not yet implemented")
    }

    override fun deleteDepartmentStaffsByDepartmentIdAndStaffIds(departmentId: Long, staffIds: List<Long>): Int
    {
        TODO("Not yet implemented")
    }
}