package com.hyper.srot.shoppingapp.utils;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class EncryptionUtility
{
private EncryptionUtility(){}
public static SecretKey getKey() throws Exception
{
KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
keyGenerator.init(128); // You can choose 128, 192, or 256 bits
return keyGenerator.generateKey();
}
public static String encrypt(String password,SecretKey secretKey) throws Exception
{
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
return Base64.getEncoder().encodeToString(encryptedBytes);
}
public static String decrypt(String encryptedPassword,SecretKey secretKey) throws Exception
{
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
byte[] decryptedBytes = cipher.doFinal(decodedBytes);
return new String(decryptedBytes, StandardCharsets.UTF_8);
}
}