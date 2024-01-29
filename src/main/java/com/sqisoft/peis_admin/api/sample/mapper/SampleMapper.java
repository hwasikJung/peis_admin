package com.sqisoft.peis_admin.api.sample.mapper;

import com.sqisoft.peis_admin.api.sample.dto.SampleDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * packageName    : com.sqisoft.PEIS_ADMIN.api.sample.mapper
 * fileName       : SampleRepotiry
 * author         : hs.jung
 * date           : 2024-01-29 오전 11:36
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        hs.jung       최초 생성
 */
@Mapper
public interface SampleMapper {
      List<SampleDto> selectSampleList();
}
