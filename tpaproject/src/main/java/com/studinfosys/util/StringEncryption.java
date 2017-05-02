package com.studinfosys.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringEncryption {
  private StringEncryption() {
  }

  /**
   * This method used to get md5 algorthim.
   * 
   * @param input
   *          input
   * @throws UnsupportedEncodingException
   *           UnsupportedEncodingException
   * @throws NoSuchAlgorithmException
   *           NoSuchAlgorithmException
   */
  public static String getEngryptedString(String input) throws UnsupportedEncodingException,
      NoSuchAlgorithmException {
    byte[] bytesOfMsg = (input).getBytes("UTF-8");
    MessageDigest md = null;
    md = MessageDigest.getInstance("MD5");
    byte[] theDigest = md.digest(bytesOfMsg);
    StringBuilder sb = new StringBuilder(2 * theDigest.length);
    for (byte b : theDigest) {
      sb.append(String.format("%02x", b & 0xff));
    }
    return sb.toString();
  }
	
  
  public static String getFileExtension(String fileName) {
        
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
  
}
