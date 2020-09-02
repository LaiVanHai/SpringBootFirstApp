package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.CreatureDTO;
import jp.co.netprotections.dto.ErrorResponseParams;
import jp.co.netprotections.dto.RequestParams;
import jp.co.netprotections.dto.ResponseParams;

@RestController
@RequestMapping("/api/v1")
public class HumanJudgeAPIController {
	@RequestMapping(value = "/judge", method = RequestMethod.POST)
	public Object judgeHuman(@RequestBody RequestParams requestBody) {
		List<CreatureDTO> creatureArr = requestBody.getCheck_data();
		List<CreatureDTO> resultList = new ArrayList<CreatureDTO>();
		int humanCount = 0;
		String message = "";
		List<String> detailsMsg = new ArrayList<String>();
		
		for (int i = 0; i < creatureArr.size(); i++) {
			CreatureDTO currenCreature = creatureArr.get(i);
			String name = currenCreature.getName();
			String type = currenCreature.getType();
			if ( name == null || type == null || name.trim().equals("")) {
				message = "Validation Failed";
				detailsMsg.add("check_data["+ Integer.toString(i) + "]では：「type」と「name」はブランクしないでください！");
				continue;
			}
			if ( !type.equals("human") && !type.equals("animal") ) {
				message = "Validation Failed";
				detailsMsg.add("check_data["+ Integer.toString(i) + "]の「type」では：「human」または「animal」を入力してくだい！");
				continue;
			}
			if (type.equals("human")) {
				humanCount++;
				resultList.add(currenCreature);
			}
		}
		
		if ( !message.equals("") ) {
			return new ErrorResponseParams(message, detailsMsg);
		}
		
		return new ResponseParams(humanCount, resultList);
	}
}
