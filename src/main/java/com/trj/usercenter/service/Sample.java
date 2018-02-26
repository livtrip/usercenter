package com.trj.usercenter.service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author xierongli
 * @version $$Id: usercenter, v 0.1 18/2/7 上午9:47 mark1xie Exp $$
 */

public class Sample {

    //设置APPID/AK/SK
    public static final String APP_ID = "f9a734b0a8a04358a6b54f5420b72ecc";
    public static final String API_KEY = "ODX0sqE5jYMAd0PTbGmrBkLl";
    public static final String SECRET_KEY = "Zh3XNLzU00jZd5fBtD2t3S0jrxAGdE4I";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        //通用图片识别
//        basicImageOcr(client);
//        identityOcr(client);
//        bankCardOcr(client);
        drivingLicenseOcr(client);
    }

    public static void basicImageOcr(AipOcr client)  {
        String path = null;
        try {
            path = ResourceUtils.getFile("classpath:static/images/test.jpg").getAbsolutePath();
            JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
            System.out.println(res.toString(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void identityOcr(AipOcr client){
        // 参数为本地图片路径
        String image = null;
        try {
            // 传入可选参数调用接口
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("detect_direction", "true");
            options.put("detect_risk", "false");
            String idCardSide = "front";
            image = ResourceUtils.getFile("classpath:static/images/test.jpg").getAbsolutePath();
            JSONObject res = client.idcard(image, idCardSide, options);
            System.out.println(res.toString(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void bankCardOcr(AipOcr client){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        // 参数为本地图片路径
        String image = null;
        try {
            image = ResourceUtils.getFile("classpath:static/images/bank.jpg").getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject res = client.bankcard(image, options);
        System.out.println(res.toString(2));
    }

    public static void drivingLicenseOcr(AipOcr client){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");


        // 参数为本地图片路径
        String image = null;
        try {
            image = ResourceUtils.getFile("classpath:static/images/driver.jpg").getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject res = client.drivingLicense(image, options);
        System.out.println(res.toString(2));

    }
}
