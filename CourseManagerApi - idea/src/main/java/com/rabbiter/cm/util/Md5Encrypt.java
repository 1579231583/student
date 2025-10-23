package com.rabbiter.cm.util;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Md5Encrypt {
    private static String byteToHexString(byte b) {
        int bInt = b;
        if (bInt < 0) {
            b ^= (1 << 7);
            bInt = b + (1 << 7);
        }

        String lowBit = Integer.toHexString(bInt / 16);
        String highBit = Integer.toHexString(bInt % 16);

        return lowBit + highBit;
    }


    /**
     * 解密
     *
     * @param password
     * @return
     */
    public static String decry(String password) throws NoSuchAlgorithmException {

        try {
            // 创建MD5加密对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //将输入字符串转换为字节数组
            byte[] inputBytes = password.getBytes();
            // 计算MD5摘要
            byte[] digestBytes = md.digest(inputBytes);
            // 将摘要转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digestBytes) {
                sb.append(String.format("%02x", b & 0xff));
            }
            // 返回解密结果
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }



    public String computeHexString(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] resultBytes = md5.digest(str.getBytes(StandardCharsets.UTF_8));

            StringBuilder builder = new StringBuilder();
            for (byte b : resultBytes) {
                builder.append(byteToHexString(b));
            }

            return builder.toString();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }
}
