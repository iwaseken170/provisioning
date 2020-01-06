package model;

import java.util.Date;

public class NewConfig {
	
	private int id;
	private Date startDate;
	private int freq;
	private int provFlag;
	
	public NewConfig(int id, Date startDate, int freq, int provFlag) {
		this.id = id;
		this.startDate = startDate;
		this.freq = freq;
		this.provFlag = provFlag;
	}
	
	public NewConfig() {
		freq = 1;
		provFlag = 1;
	}
	
	public NewConfig(int provFlag) {
		provFlag = 1;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
}
