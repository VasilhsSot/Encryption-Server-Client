
/*

 * Source code from http://www.dreamincode.net/forums/topic/259777-a-simple-chat-program-with-clientserver-gui-optional/
 */
import java.io.*;
import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/*
 * This class defines the different type of messages that will be exchanged between the
 * Clients and the Server. 
 * When talking from a Java Client to a Java Server a lot easier to pass Java objects, no 
 * need to count bytes or to wait for a line feed at the end of the frame
 */
public class ChatMessage implements Serializable {

	protected static final long serialVersionUID = 1112122200L;

	// The different types of message sent by the Client
	// WHOISIN to receive the list of the users connected
	// MESSAGE an ordinary message
	// LOGOUT to disconnect from the Server
	static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;
	private int type;
	private String message;
	private byte [] fingerprint;
	
	// constructor
	ChatMessage(int type, String message, Key key) {
		this.type = type;
		try {
			this.message= new String (encrypt.encryption(key, message.getBytes("UTF8")),"UTF8");
		} 
		catch (InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.fingerprint= encrypt.encryption(key ,messagedigest.digest(message));
		} catch (InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void decryptmessage (Key key) {
		try {
			message= new String (encrypt.decryption(key ,message.getBytes("UTF8")),"UTF8");
			fingerprint= encrypt.decryption(key, fingerprint);
		} catch (InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// getters
	int getType() {
		return type;
	}
	String getMessage() {
		return message;
	}
}
