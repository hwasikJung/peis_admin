package com.sqisoft.peis_admin.api.sample.controller;

import com.sqisoft.peis_admin.api.sample.service.SampleService;
import com.sqisoft.peis_admin.comn.ResultVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * packageName    : com.sqisoft.PEIS_ADMIN.api.sample.controller
 * fileName       : SamepleController
 * author         : hs.jung
 * date           : 2024-01-29 오전 11:35
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        hs.jung       최초 생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/api/sample")
    public String sample() {
        ResultVo resultVo = new ResultVo();
        resultVo.setResultData(sampleService.selectSampleList());
        resultVo.setResultFlag(true);
        resultVo.setResultMsg("성공");
        log.debug("ResultVo.toString()) :: " + resultVo);
        return resultVo.toString();
    }
}
