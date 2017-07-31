package com.ifly.edu.netty.example.bookticket;


import java.io.Serializable;
/**
 * 火车pojo对象
 * @author xwalker
 */
public class Train implements Serializable {
    private static final long serialVersionUID = 1510326612440404416L;
    private String number;//火车车次
    private int ticketCounts;//余票数量
    public Train(String number,int ticketCounts){
        this.number=number;
        this.ticketCounts=ticketCounts;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getTicketCounts() {
        return ticketCounts;
    }
    public void setTicketCounts(int ticketCounts) {
        this.ticketCounts = ticketCounts;
    }
 
}
