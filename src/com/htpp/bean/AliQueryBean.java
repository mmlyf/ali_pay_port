package com.htpp.bean;

public class AliQueryBean {
    private String out_trade_no;
    private String trade_no;
    private String org_pid;

    public String getOut_trade_no() {
        return out_trade_no!=null?out_trade_no:"";
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no!=null?trade_no:"";
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOrg_pid() {
        return org_pid!=null?org_pid:"";
    }

    public void setOrg_pid(String org_pid) {
        this.org_pid = org_pid;
    }
}
