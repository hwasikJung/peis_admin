package com.sqisoft.peis_admin;

import com.sqisoft.peis_admin.api.sample.dto.SampleDto;
import com.sqisoft.peis_admin.api.sample.service.SampleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PeisAdminApplicationTests {

	private final SampleService sampleService;

	@Autowired
	PeisAdminApplicationTests(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@Test
	void contextLoads() {
		List<SampleDto> sampleDtos = sampleService.selectSampleList();
		Assertions.assertThat(sampleDtos).isNotEmpty();
	}
}
