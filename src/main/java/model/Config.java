package model;

import java.util.Date;

public class Config {
	
	public Config() {}
	
	private int id;
	private Date startDate;
	private int freq;
	private int provFlag;	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getProvFlag() {
		return provFlag;
	}
	public void setProvFlag(int provFlag) {
		this.provFlag = provFlag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
