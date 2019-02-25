package com.htpp.method;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.htpp.httpreq.HttpsRequest;
import com.htpp.bean.ALIPayBean;
import com.htpp.bean.AliQueryBean;
import com.htpp.bean.AliRefundBean;
import com.htpp.config.Config;

public class ALIPay {

    //支付接口
    public static String aliPayMoney(ALIPayBean bean){
        AlipayClient alipayClient = new DefaultAlipayClient(Config.ALI_PUBLIC_PATH,Config.APPID,Config.ALI_PRIVATE_KEY,"utf-8",Config.ALI_PUBLIC_KEY,"RSA2");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(Config.ALI_RETURN_URL);
        alipayRequest.setNotifyUrl(Config.ALI_NOTIFY_URL);
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":"+bean.getOut_trade_no()+"," +
                "    \"product_code\":"+bean.getProduct_code()+"," +
                "    \"total_amount\":"+bean.getTotal_amount()+"," +
                "    \"subject\":"+bean.getSubject()+"," +
                "    \"body\":"+bean.getBody()+"," +
                "    \"passback_params\":"+bean.getPassback_params()+"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":"+bean.getSys_service_provider_id()+"," +
                "    \"hb_fq_num\":"+bean.getHb_fq_num()+"," +
                "    \"hb_fq_seller_percent\":"+bean.getHb_fq_seller_percent()+"," +
                "    \"goods_type\":"+bean.getGoods_type()+"," +
                "    \"timeout_express\":"+bean.getTimeout_express()+"," +
                "    \"enable_pay_channels\":"+bean.getEnable_pay_channels()+"," +
                "    \"disable_pay_channels\":"+bean.getDisable_pay_channels()+"," +
                "    \"auth_token\":"+bean.getAuth_token()+"," +
                "    \"qr_pay_mode\":"+bean.getQr_pay_mode()+"," +
                "    \"qrcode_width\":"+bean.getQrcode_width()+"" +
                "    }"+
                "  }");//填充业务参数
        String param = "";
        try {
            param = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        String result = HttpsRequest.sendPost(Config.ALI_PUBLIC_PATH,param);
        return result;
    }

    //查询订单
    public static AlipayTradeQueryResponse aliPayForQuery(AliQueryBean bean){
        AlipayClient alipayClient = new DefaultAlipayClient(Config.ALI_PUBLIC_PATH,Config.APPID,Config.ALI_PRIVATE_KEY,"JSON","UTF-8",Config.ALI_PUBLIC_KEY,"RSA2");
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();//创建API对应的request
        alipayRequest.setBizContent("{" +
                "\"out_trade_no\":"+bean.getOut_trade_no()+"," +
                "\"trade_no\":"+bean.getTrade_no()+"," +
                "\"org_pid\":"+bean.getOrg_pid()+"" +
                "  }");
        try {
            AlipayTradeQueryResponse response = alipayClient.execute(alipayRequest);
            if (response.isSuccess()){
               return response;
            }else{
                return null;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    //退款
    public static AlipayTradeRefundResponse aliPayForRefund(AliRefundBean bean){
        AlipayClient alipayClient = new DefaultAlipayClient(Config.ALI_PUBLIC_PATH,Config.APPID,Config.ALI_PRIVATE_KEY,"json","utf-8",Config.ALI_PUBLIC_KEY,"RSA2");
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":"+bean.getOut_trade_no()+"," +
                "\"trade_no\":"+bean.getTrade_no()+"," +
                "\"refund_amount\":"+bean.getRefund_amount()+"," +
                "\"refund_currency\":"+bean.getRefund_currency()+"," +
                "\"refund_reason\":"+bean.getRefund_reason()+"," +
                "\"out_request_no\":"+bean.getOut_request_no()+"," +
                "\"operator_id\":"+bean.getOperator_id()+"," +
                "\"store_id\":"+bean.getStore_id()+"," +
                "\"terminal_id\":"+bean.getTerminal_id()+"," +
                "      \"goods_detail\":[{" +
                "        \"goods_id\":"+bean.getGoods_id()+"," +
                "\"alipay_goods_id\":"+bean.getAlipay_goods_id()+"," +
                "\"goods_name\":"+bean.getGoods_name()+"," +
                "\"quantity\":"+bean.getQuantity()+"," +
                "\"price\":"+bean.getPrice()+"," +
                "\"goods_category\":"+bean.getGoods_category()+"," +
                "\"categories_tree\":"+bean.getCategories_tree()+"," +
                "\"body\":"+bean.getBody()+"," +
                "\"show_url\":"+bean.getShow_url()+"" +
                "        }]," +
                "      \"refund_royalty_parameters\":[{" +
                "        \"royalty_type\":"+bean.getRoyalty_type()+"," +
                "\"trans_out\":"+bean.getTrans_out()+"," +
                "\"trans_out_type\":"+bean.getTrans_out_type()+"," +
                "\"trans_in_type\":"+bean.getTrans_in_type()+"," +
                "\"trans_in\":"+bean.getTrans_in()+"," +
                "\"amount\":"+bean.getAmount()+"," +
                "\"amount_percentage\":"+bean.getAmount_percentage()+"," +
                "\"desc\":"+bean.getDesc()+"" +
                "        }]," +
                "\"org_pid\":"+bean.getOrg_pid()+"" +
                "  }");
        try {
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            if (response.isSuccess()){
                return response;
            }else{
                System.out.println("请求失败");
                return null;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }


}
