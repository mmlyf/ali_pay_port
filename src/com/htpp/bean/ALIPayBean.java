package com.htpp.bean;

public class ALIPayBean {
    private String out_trade_no;
    private String product_code;
    private String total_amount;
    private String subject;
    private String body;
    private String goods_detail;
    private String passback_params;

    private String goods_type;
    private String timeout_express;
    private String enable_pay_channels;
    private String disable_pay_channels;
    private String auth_token;
    private String qr_pay_mode;
    private String qrcode_width;

    //业务扩展的三个参数
    private String sys_service_provider_id;
    private String hb_fq_num;
    private String hb_fq_seller_percent;

    public String getOut_trade_no() {
        return out_trade_no!=null?out_trade_no:"";
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getProduct_code() {
        return product_code!=null?product_code:"";
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getTotal_amount() {
        return total_amount!=null?total_amount:"";
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject!=null?subject:"";
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body!=null?body:"";
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGoods_detail() {
        return goods_detail!=null?goods_detail:"";
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getPassback_params() {
        return passback_params!=null?passback_params:"";
    }

    public void setPassback_params(String passback_params) {
        this.passback_params = passback_params;
    }

    public String getSys_service_provider_id() {
        return sys_service_provider_id!=null?sys_service_provider_id:"";
    }

    public void setSys_service_provider_id(String sys_service_provider_id) {
        this.sys_service_provider_id = sys_service_provider_id;
    }

    public String getHb_fq_num() {
        return hb_fq_num!=null?hb_fq_num:"";
    }

    public void setHb_fq_num(String hb_fq_num) {
        this.hb_fq_num = hb_fq_num;
    }

    public String getHb_fq_seller_percent() {
        return hb_fq_seller_percent!=null?hb_fq_seller_percent:"";
    }

    public void setHb_fq_seller_percent(String hb_fq_seller_percent) {
        this.hb_fq_seller_percent = hb_fq_seller_percent;
    }

    public String getGoods_type() {
        return goods_type!=null?goods_type:"";
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getTimeout_express() {
        return timeout_express!=null?timeout_express:"";
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public String getEnable_pay_channels() {
        return enable_pay_channels!=null?enable_pay_channels:"";
    }

    public void setEnable_pay_channels(String enable_pay_channels) {
        this.enable_pay_channels = enable_pay_channels;
    }

    public String getDisable_pay_channels() {
        return disable_pay_channels!=null?disable_pay_channels:"";
    }

    public void setDisable_pay_channels(String disable_pay_channels) {
        this.disable_pay_channels = disable_pay_channels;
    }

    public String getAuth_token() {
        return auth_token!=null?auth_token:"";
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getQr_pay_mode() {
        return qr_pay_mode!=null?qr_pay_mode:"";
    }

    public void setQr_pay_mode(String qr_pay_mode) {
        this.qr_pay_mode = qr_pay_mode;
    }

    public String getQrcode_width() {
        return qrcode_width!=null?qrcode_width:"";
    }

    public void setQrcode_width(String qrcode_width) {
        this.qrcode_width = qrcode_width;
    }
}
