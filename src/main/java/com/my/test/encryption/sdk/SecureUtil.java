package com.my.test.encryption.sdk;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * 算法工具类
 *
 * @author Chengfei.Sun on 2015/12/02.
 */
public class SecureUtil {
    /**
     * 算法常量： MD5
     */
    private static final String ALGORITHM_MD5 = "MD5";
    /**
     * 算法常量： SHA1
     */
    private static final String ALGORITHM_SHA1 = "SHA-1";

    /**
     * 算法常量：SHA1withRSA
     */
    private static final String BC_PROV_ALGORITHM_SHA1RSA = "SHA1withRSA";

    /**
     * md5计算.
     *
     * @param datas 待计算的数据
     * @return 计算结果
     */
    public static byte[] md5(byte[] datas) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM_MD5);
            md.reset();
            md.update(datas);
            return md.digest();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.writeErrorLog("MD5计算失败", e);
            return null;
        }
    }

    /**
     * sha1计算.
     *
     * @param data 待计算的数据
     * @return 计算结果
     */
    public static byte[] sha1(byte[] data) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM_SHA1);
            md.reset();
            md.update(data);
            return md.digest();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.writeErrorLog("SHA1计算失败", e);
            return null;
        }
    }

    /**
     * sha1计算后进行16进制转换
     *
     * @param data     待计算的数据
     * @param encoding 编码
     * @return 计算结果
     */
    public static byte[] sha1X16(String data, String encoding) {
        byte[] bytes = sha1(data, encoding);
        StringBuilder sha1StrBuff = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (Integer.toHexString(0xFF & bytes[i]).length() == 1) {
                sha1StrBuff.append("0").append(
                        Integer.toHexString(0xFF & bytes[i]));
            } else {
                sha1StrBuff.append(Integer.toHexString(0xFF & bytes[i]));
            }
        }
        try {
            return sha1StrBuff.toString().getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * md5计算
     *
     * @param datas    待计算的数据
     * @param encoding 字符集编码
     * @return
     */
    public static byte[] md5(String datas, String encoding) {
        try {
            return md5(datas.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            LogUtil.writeErrorLog("MD5计算失败", e);
            return null;
        }
    }

    /**
     * sha1计算
     *
     * @param datas    待计算的数据
     * @param encoding 字符集编码
     * @return
     */
    public static byte[] sha1(String datas, String encoding) {
        try {
            return sha1(datas.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            LogUtil.writeErrorLog("SHA1计算失败", e);
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param privateKey 私钥
     * @param data       待签名数据
     * @return 结果
     * @throws Exception
     */
    public static byte[] signBySoft(PrivateKey privateKey, byte[] data)
            throws Exception {
        byte[] result = null;
        Signature st = Signature.getInstance(BC_PROV_ALGORITHM_SHA1RSA);
        st.initSign(privateKey);
        st.update(data);
        result = st.sign();
        return result;
    }

    /**
     * 验证签名
     *
     * @param publicKey 公钥
     * @param signData  签名数据
     * @param srcData   摘要
     * @return
     * @throws Exception
     */
    public static boolean validateSignBySoft(PublicKey publicKey, byte[] signData, byte[] srcData) throws Exception {
        Signature st = Signature.getInstance(BC_PROV_ALGORITHM_SHA1RSA);
        st.initVerify(publicKey);
        st.update(srcData);
        return st.verify(signData);
    }

    /**
     * 验证签名
     *
     * @param publicKey 公钥
     * @param signData  签名数据
     * @param srcData   待签名原文
     * @param encoding  编码格式
     * @return
     * @throws Exception
     */
    public static boolean validateSignBySoft(PublicKey publicKey, String signData, String srcData, String encoding) throws Exception {
        return validateSignBySoft(publicKey, SecureUtil.base64Decode(signData.getBytes(encoding)),
                SecureUtil.sha1X16(srcData, encoding));
    }

    /**
     * BASE64解码
     *
     * @param inputByte 待解码数据
     * @return 解码后的数据
     * @throws IOException
     */
    public static byte[] base64Decode(byte[] inputByte) throws IOException {
        return Base64.decodeBase64(inputByte);
    }

    /**
     * BASE64编码
     *
     * @param inputByte 待编码数据
     * @return 解码后的数据
     * @throws IOException
     */
    public static byte[] base64Encode(byte[] inputByte) throws IOException {
        return Base64.encodeBase64(inputByte);
    }
}
