package com.artharyoung.sdk.Utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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
     * @param toEncrypt
     * @return
     */
    public static String md5(final String toEncrypt) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(toEncrypt.getBytes());
            final byte[] bytes = digest.digest();
            final StringBuilder sb = new StringBuilder();
            for(byte cell:bytes){
                sb.append(String.format("%02X", cell));
            }
            return sb.toString().toLowerCase();
        } catch (Exception exc) {
            return ""; // Impossibru!
        }
    }

    /**
     * 获取签名文件夹meta-inf目录下的文件名，可用来读取渠道文件
     * @param context
     * @return
     */
    public static String getChannel(Context context) {
        ApplicationInfo appinfo = context.getApplicationInfo();
        String sourceDir = appinfo.sourceDir;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith("mtchannel")) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String[] split = ret.split("_");
        if (split != null && split.length >= 2) {
            return ret.substring(split[0].length() + 1);

        } else {
            return "";
        }
    }

    /**
     * Return pseudo unique ID ：需要 api>=9
     *
     * @return ID
     */
    public static String getUniquePsuedoID() {
        // If all else fails, if the user does have lower than API 9 (lower
        // than Gingerbread), has reset their device or 'Secure.ANDROID_ID'
        // returns 'null', then simply the ID returned will be solely based
        // off their Android device information. This is where the collisions
        // can happen.
        // Thanks http://www.pocketmagic.net/?p=1662!
        // Try not to use DISPLAY, HOST or ID - these items could change.
        // If there are collisions, there will be overlapping data
        String m_szDevIDShort = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10)
                + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) +
                (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) +
                (Build.PRODUCT.length() % 10);

        // Thanks to @Roman SL!
        // http://stackoverflow.com/a/4789483/950427
        // Only devices with API >= 9 have android.os.Build.SERIAL
        // http://developer.android.com/reference/android/os/Build.html#SERIAL
        // If a user upgrades software or roots their device, there will be a duplicate entry
        String serial;
        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();

            // Go ahead and return the serial for api => 9
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            // String needs to be initialized
            serial = "serial"; // some value
        }

        // Thanks @Joe!
        // http://stackoverflow.com/a/2853253/950427
        // Finally, combine the values we have found by using the UUID class to create a unique identifier
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }
}
