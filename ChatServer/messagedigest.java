
import java.security.*;

import javax.crypto.*;

import java.io.UnsupportedEncodingException;

public class messagedigest {
	public static byte [] digest (String message)  {		
		try {
			byte[] plainText = message.getBytes("UTF8");
			// get a message digest object using the MD5 algorithm
			MessageDigest messageDigest = MessageDigest.getInstance("MD5"); //Creates the message digest
			messageDigest.update( plainText); //Calculates the message digest with a plaintext string
			return messageDigest.digest(); //Reads the message digest
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
