package com.rany.uic.common.util;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.crypto.asymmetric.RSA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Description
 * @Author Wythe
 * @Version V1.0.0
 * @Since 1.0
 * @Date 02/05/2021
 */
public class RsaUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RsaUtils.class);

    /**
     * 将字符串转换成RSAPublicKey类型
     *
     * @param base64s
     * @return
     * @throws Exception
     */
    public static RSAPublicKey getRSAPublicKeyByBase64(String base64s) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec((new sun.misc.BASE64Decoder()).decodeBuffer(base64s));
        RSAPublicKey publicKey = null;
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        try {
            publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (InvalidKeySpecException var4) {
            LOGGER.error("Generate public key failed." + var4.getMessage());
        }
        return publicKey;
    }

    /**
     * 将字符串转换成RSAPrivateKey类型
     *
     * @param base64s
     * @return
     * @throws Exception
     */
    public static RSAPrivateKey getRSAPrivateKeyByBase64(String base64s) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec((new sun.misc.BASE64Decoder()).decodeBuffer(base64s));
        RSAPrivateKey privateKey = null;
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        try {
            privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException var4) {
            LOGGER.error("Generate private key failed." + var4.getMessage());
        }
        return privateKey;
    }

    public static RSA getRsa(File file) {
        FileReader fileReader = new FileReader(file);
        String privateKey = fileReader.readString().trim();
        RSA rsa = new RSA(privateKey, null);
        return rsa;
    }
}
