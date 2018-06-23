package com.ifly.edu.kafka;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


public class t_deposit_hive{
	private static final long serialVersionUID = 1584915718314924608L;

	public Long iden;

	private String address;

	private BigDecimal amount;
	private String ordernum;//对应t_mmm_data的order_num
	private String tx_hash;
	private Integer tx_index;
	private Integer output_index;
	private Integer block_height;
	private BigDecimal tx_time;
	private String asset;
	private Integer status;
	private Date create_time;

	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTx_hash() {
		return tx_hash;
	}
	public void setTx_hash(String tx_hash) {
		this.tx_hash = tx_hash;
	}
	public Integer getTx_index() {
		return tx_index;
	}
	public void setTx_index(Integer tx_index) {
		this.tx_index = tx_index;
	}
	public Integer getOutput_index() {
		return output_index;
	}
	public void setOutput_index(Integer output_index) {
		this.output_index = output_index;
	}
	public Integer getBlock_height() {
		return block_height;
	}
	public void setBlock_height(Integer block_height) {
		this.block_height = block_height;
	}
	public BigDecimal getTx_time() {
		return tx_time;
	}
	public void setTx_time(BigDecimal tx_time) {
		this.tx_time = tx_time;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Long getIden() {
		return iden;
	}

	public void setIden(Long iden) {
		this.iden = iden;
	}

	public t_deposit_hive() {
	}

	public t_deposit_hive(Long iden, String address, BigDecimal amount, String ordernum, String tx_hash, Integer tx_index, Integer output_index, Integer block_height, BigDecimal tx_time, String asset, Integer status, Date create_time) {
		this.iden = iden;
		this.address = address;
		this.amount = amount;
		this.ordernum = ordernum;
		this.tx_hash = tx_hash;
		this.tx_index = tx_index;
		this.output_index = output_index;
		this.block_height = block_height;
		this.tx_time = tx_time;
		this.asset = asset;
		this.status = status;
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		try{
			return JsonUtil.writeValueAsString(this);
		}catch (Exception e){
			return null;
		}
	}
}

