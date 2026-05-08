package com.the703.basic016_ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class JavaIOEx001 {

	public static void main(String[] args) {
		//#1. 걍로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd_HHmmss"); //포멧설정
		long millis = System.currentTimeMillis(); // 시스템시간가져오기
		String folder_rel ="src/com/the703/basic016_ex/"; 	//상대경로 - 현재작업 폴더기준
		String file_path  = sdf.format(millis) + "app.log";		
		
		File folder = new File(folder_rel);
		File file   = new File(folder_rel + file_path);
		//#2. 파일+폴더준비
		try {
			if(!folder.exists()) {folder.mkdirs();}
			if(!file.exists()) {file.createNewFile();}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//#3. char 단위로 파일쓰기
		// sdf.format(millis) + "로그파일입니다." 시간이나오게		
		try {
			Writer writer = new FileWriter(file);
			writer.write(sdf.format(millis) + "로그파일입니다"); //20260508_1716 로그파일입니다.
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//#4. char 단위로 파일읽기
		try {
			Reader reader = new FileReader(file);
			int cnt=0;
			while( (cnt = reader.read()) != -1) {
				System.out.print((char)cnt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
