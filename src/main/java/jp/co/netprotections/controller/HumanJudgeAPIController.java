package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.dto.RequestParams;
import jp.co.netprotections.dto.ResponseParams;

@RestController
@RequestMapping("/api/v1")
public class HumanJudgeAPIController {
	@RequestMapping(value = "/judge", method = RequestMethod.POST)
	public ResponseParams judgeHuman(@RequestBody RequestParams requestBody) {
		ResponseParams responseBody = new ResponseParams();
		List<CreatureDTO> creatureArr = requestBody.getCheck_data();
		List<CreatureDTO> resultList = new ArrayList<CreatureDTO>();
		int humanCount = 0;
		
		for (int i = 0; i < creatureArr.size(); i++) {
			CreatureDTO currenCreature = creatureArr.get(i);
			if (currenCreature.getType().equals("human")) {
				humanCount++;
				resultList.add(currenCreature);
			}
		}
		
		responseBody.setCount(humanCount);
		responseBody.setResults(resultList);
		return responseBody;
	}
}
