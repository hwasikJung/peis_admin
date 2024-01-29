package com.sqisoft.peis_admin.comn;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo {

	private String resultMsg = "";
	private boolean resultFlag = false;
	private Object resultData = null;
}
