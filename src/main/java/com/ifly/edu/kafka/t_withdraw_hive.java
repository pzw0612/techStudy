package com.ifly.edu.kafka;

import java.math.BigDecimal;
import java.util.Date;

public class t_withdraw_hive {
	private static final long serialVersionUID = 1584915718314924608L;

	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	private Long withdraw_id;
	private String asset;
	private String from_address;
	private String to_address;
	private String txhash;
	private Integer status;
	private BigDecimal amount;
	private Integer process;
	private String memo;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	
	public String getTxhash() {
		return txhash;
	}
	public void setTxhash(String txhash) {
		this.txhash = txhash;
	}
	public Long getWithdraw_id() {
		return withdraw_id;
	}
	public void setWithdraw_id(Long withdraw_id) {
		this.withdraw_id = withdraw_id;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getFrom_address() {
		return from_address;
	}
	public void setFrom_address(String from_address) {
		this.from_address = from_address;
	}
	public String getTo_address() {
		return to_address;
	}
	public void setTo_address(String to_address) {
		this.to_address = to_address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getProcess() {
		return process;
	}
	public void setProcess(Integer process) {
		this.process = process;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}

