package com.text.main;

import java.nio.file.Path;

import com.text.util.FileUtil;
import com.text.util.TextUtil;

public class App {

	public static String PATH_WITH_JSP = System.getProperty("user.home") + "/work";

	public static String PROPERTIES = FileUtil.readFile(PATH_WITH_JSP + "/ApplicationResources.properties");

	public static void main(String[] args) {

		for (Path jsp : FileUtil.allJspFiles(PATH_WITH_JSP)) {
			System.out.println("Parsing: " + jsp.getFileName() + " | " + jsp.toString());
			String text = FileUtil.readFile(jsp.toString());
			String text2 = TextUtil.doReplace(text);

			if (text2 != null) {
				FileUtil.write(text2, jsp.toString());
			} else {
				System.out.println("nothing changed");
			}
			System.out.println();
		}
		
	}

	
}
