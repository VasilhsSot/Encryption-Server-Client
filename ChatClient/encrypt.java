

import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.*;


public class encrypt {
	public static KeyPair generatekey () {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(1024);
			KeyPair key = keyGen.generateKeyPair();
			return key;
		}
			catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
                
                
	}
        
        public static byte [] encryption (Key key, byte[] plainText) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
            try {       
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(Cipher.ENCRYPT_MODE, key);
                        byte[] cipherText = cipher.doFinal(plainText);
                        System.out.println (cipherText.length);
                        return cipherText;
                }
                catch (NoSuchAlgorithmException e) {
                	return null;
                }
            }
        
        public static byte [] decryption (Key key, byte[] plainText) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException   {
            try{
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(Cipher.DECRYPT_MODE, key);
                        byte[] cipherText = cipher.doFinal(plainText);
                        return cipherText;
                        
        }
            catch (NoSuchAlgorithmException e) {
            	return null;
            }
            }
                             
        }