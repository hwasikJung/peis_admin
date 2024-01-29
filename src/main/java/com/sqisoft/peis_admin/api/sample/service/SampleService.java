package com.sqisoft.peis_admin.api.sample.service;

import com.sqisoft.peis_admin.api.sample.dto.SampleDto;
import com.sqisoft.peis_admin.api.sample.mapper.SampleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName    : com.sqisoft.PEIS_ADMIN.api.sample.service
 * fileName       : SampleSerivceImpl
 * author         : hs.jung
 * date           : 2024-01-29 오전 11:37
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        hs.jung       최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SampleService {

    private final SampleMapper sampleMapper;

    public List<SampleDto> selectSampleList() {
        log.debug("service selectSampleList");
        return sampleMapper.selectSampleList();
    }
}
