package com.ifly.edu.netty.example.bookticket;

/**
 *
 * @author pangzhw
 * @date 2015年7月12日
 */
import java.io.Serializable;
import java.util.Date;
/**
 * 订票POJO对象
 * @author xwalker
 */
public class Ticket implements Serializable {
    private static final long serialVersionUID = 4228051882802183587L;
    private String trainNumber;//火车车次
    private int carriageNumber;//车厢编号
    private String seatNumber;//座位编号
    private String number;//车票编号
    private User user;//订票用户
    private Date bookTime;//订票时间
    private Date startTime;//开车时间
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
 
    public Date getBookTime() {
        return bookTime;
    }
    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTrainNumber() {
        return trainNumber;
    }
    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
    public int getCarriageNumber() {
        return carriageNumber;
    }
    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
