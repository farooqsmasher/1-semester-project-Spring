package com.tpa.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
                                               //implementation of jar//
public class FileUtil {

	// this method sets up the file path and traverse the content of file 
	//matches the keywords of the file 
	
	public Boolean auditFileAgainstKeywords(String filePath, String keyWords){
		BufferedReader br = null;
		String[]  keyWordsArr = keyWords.split(",");
		Boolean flag = true;
		String fileContent="";
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			
			while ((line = br.readLine()) != null) {
				fileContent = fileContent + line;
			}
			
			for(String item : keyWordsArr){
			if(!fileContent.contains(item)){
				flag=false;
				break;
			}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return flag;
	}
	
	
}
