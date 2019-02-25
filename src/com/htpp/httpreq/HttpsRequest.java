package com.htpp.httpreq;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Author lvgordon
 * @Date 14:07 2019-02-25
 * @Description
 * 发送GET和POST的HTTPS的请求
 **/
public class HttpsRequest {

    //https发送get请求没有编码方式参数
    public static String sendGet(String path,String param){
       return sendGet(path,param,"utf-8");
    }

    //HTTPS请求Get带有编码格式
    public static String sendGet(String path,String param,String chartset){
        HttpsURLConnection httpsConn = null;
        BufferedReader bufferedReader = null;
        try {
            SSLContext ssl = SSLContext.getInstance("TLS");
            ssl.init(new KeyManager[0],new TrustManager[]{new DefaultTrustManager()},new SecureRandom());
            SSLContext.setDefault(ssl);
            String allpath = path +"?"+param;
            URL url = new URL(allpath);
            httpsConn = (HttpsURLConnection) url.openConnection();
            httpsConn.setRequestProperty("accept","*/*");
            httpsConn.setRequestProperty("connection","Keep-Alive");
            httpsConn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpsConn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            httpsConn.connect();
            if (httpsConn.getResponseCode()==HttpsURLConnection.HTTP_OK) {
                StringBuffer strbuffer = new StringBuffer();
                bufferedReader = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), chartset));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    strbuffer.append(line);
                }
                return strbuffer.toString();
            }else{
                System.out.println("当前请求失败，失败码是："+httpsConn.getResponseCode());
                return null;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                httpsConn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //post请求
    public static String sendPost(String path,String param){
        return sendPost(path,param,"utf-8");
    }


    //post请求charset
    public static String sendPost(String path,String param,String charset){
        HttpsURLConnection httpConn = null;
        BufferedReader reader = null;
        PrintWriter pw = null;
        try {
            SSLContext ssl = SSLContext.getInstance("TLS");
            ssl.init(new KeyManager[0],new TrustManager[]{new DefaultTrustManager()},new SecureRandom());
            SSLContext.setDefault(ssl);
            URL url = new URL(path);
            httpConn = (HttpsURLConnection) url.openConnection();
            httpConn.setRequestProperty("accept","*/*");
            httpConn.setRequestProperty("connection","Keep-Alive");
            httpConn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            httpConn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

            pw = new PrintWriter(httpConn.getOutputStream());
            pw.write(param);
            pw.flush();
            reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),charset));
            if (httpConn.getResponseCode()== HttpURLConnection.HTTP_OK){
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine())!=null){
                    stringBuffer.append(line);
                }
                return stringBuffer.toString();
            }else{
                System.out.println("当前HTTPS发送post请求失败，失败码为："+httpConn.getResponseCode());
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                pw.close();
                httpConn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

class DefaultTrustManager implements X509TrustManager{

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}