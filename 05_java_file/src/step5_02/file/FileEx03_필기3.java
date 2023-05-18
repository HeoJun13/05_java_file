package step5_02.file;

import java.io.FileWriter;

//# 파일 저장하기 : 연습문제1


public class FileEx03_필기3 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이민수", "이영희"};
		int[] ages = {20,30,40};
		
		String FileName = "Filenames04";
		
		String data = "";
		
		for (int i = 0; i < names.length; i++) {
			data += names[i];
			data += "/";
			data += ages[i];
			if (i != names.length -2); {
				data += ",";	
			}
		}
		System.out.println(data);
		
	}

}
