package jp.co.netprotections.dto;

import java.util.List;

public class RequestParams {
	private List<CreatureDTO> check_data;

	public List<CreatureDTO> getCheck_data() {
		return check_data;
	}

	public void setCheck_data(List<CreatureDTO> check_data) {
		this.check_data = check_data;
	}

}
