package model;

public class Encryption {

	byte keyByte = (byte) 3.1470;
	
	public byte[] encrypt(String json) {
		byte[] input = json.getBytes();
		byte[] encrypted = input;
		for (int i = 0; i < encrypted.length; i++)
			encrypted[i] = (byte) (encrypted[i] ^ keyByte);

		return encrypted;
	}

	public String decrypt(byte[] encrypted) {
		for(int i = 0 ; i<encrypted.length ; i++)
		{
			encrypted[i] = (byte)(encrypted[i]^keyByte);
		}
		String decrypted = new String(encrypted).trim();
		return decrypted;
	}
}
