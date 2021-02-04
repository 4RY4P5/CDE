package com.cognizant.stock.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	@Id
	@Column(name="st_id")
	private int id;
	
	@Column(name="st_date")
	private Date stDate ;
	
	@Column(name="st_code")
	private String stCode;
	
	@Column(name="st_open")
	private double stOpen;
	
	@Column(name="st_close")
	private double stClose;
	
	@Column(name="st_volume")
	private long stVolume;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStDate() {
		return stDate;
	}

	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}

	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public double getStOpen() {
		return stOpen;
	}

	public void setStOpen(double stOpen) {
		this.stOpen = stOpen;
	}

	public double getStClose() {
		return stClose;
	}

	public void setStClose(double stClose) {
		this.stClose = stClose;
	}

	public long getStVolume() {
		return stVolume;
	}

	public void setStVolume(long stVolume) {
		this.stVolume = stVolume;
	}

	@Override
	public String toString() {
		return "Stock [stDate=" + stDate + ", stCode=" + stCode + ", stOpen=" + stOpen + ", stClose=" + stClose
				+ ", stVolume=" + stVolume + "]";
	}

	public Stock(Date stDate, String stCode, double stOpen, double stClose, long stVolume) {
		super();
		this.stDate = stDate;
		this.stCode = stCode;
		this.stOpen = stOpen;
		this.stClose = stClose;
		this.stVolume = stVolume;
	}
	 public Stock() {
		 
	 }
}
