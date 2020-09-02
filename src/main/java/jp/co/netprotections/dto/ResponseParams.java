package jp.co.netprotections.dto;

import java.util.List;

public class ResponseParams {
	private int count;
	private List<CreatureDTO> results;

	public ResponseParams(int count, List<CreatureDTO> results) {
		this.count = count;
		this.results = results;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<CreatureDTO> getResults() {
		return results;
	}
	public void setResults(List<CreatureDTO> results) {
		this.results = results;
	}

}
