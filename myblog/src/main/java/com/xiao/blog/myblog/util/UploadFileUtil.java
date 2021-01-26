package com.xiao.blog.myblog.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtil {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws IOException {
		  File targetFile = new File(filePath);  
	        if(!targetFile.exists()){    
	            targetFile.mkdirs();    
	        }       
	        FileOutputStream out = new FileOutputStream(filePath+fileName);
	        out.write(file);
	        out.flush();
	        out.close();

	}
}
