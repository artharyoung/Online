package com.artharyoung.sdk.Utils;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;

/**
 * Created by arthar on 2017/6/27.
 */

public class Util {


    /**
     * 输入流转字符串
     * @param in inputStream
     * @return string
     */
    public static String inputStreamToString(InputStream in) {

        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder sb = new StringBuilder();

            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

    /**
     * 解析成对象
     * @param jsonString jsonString
     * @param cls bean class
     * @param <T> class
     * @return return bean
     */
    public static <T> T getBeanFromJson(String jsonString, Class<T> cls) {
        return new Gson().fromJson(jsonString, cls);
    }

    /**
     * 将对象转成json格式的字符串
     * @param object object
     * @return return string
     */
    public static String beanToString(Object object) {

        return new Gson().toJson(object);
    }

    /**
     * 获取资源id
     * @param context
     * @param defType
     * @param name
     * @return
     */
    public static int getId(Context context, String defType, String name){

        return context.getResources().getIdentifier(name, defType, context.getPackageName());
    }

    /**
     * 利用MD5码的不可逆性，将输入的账号用MD5加密后存储在服务器
     *
     * @param string
     * @return
     */
    public static String getMD5String(String string) {
        char hexDigits[] = {'0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes();
            //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            char str[] = new char[md.length * 2];
            int k = 0;

            for (int i : md) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
