package com.ifly.edu.jsoup;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/5/8
 **/
public class QuoteModel implements Serializable{
    private static final long serialVersionUID = -4832213746464431526L;

    private Long id;
    private String currency;
    private String happenDate;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private BigDecimal marketCap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(String happenDate) {
        this.happenDate = happenDate;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        return "QuoteModel{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", happenDate='" + happenDate + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", marketCap=" + marketCap +
                '}';
    }
}
