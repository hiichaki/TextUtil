package com.text.main;

import com.text.util.FileUtil;
import com.text.util.TextUtil;

public class App {

	public static String pathWithJSP = System.getProperty("user.home") + "/work";

	public static String properties = FileUtil.readFile(pathWithJSP + "/ApplicationResources.properties");

	public static void main(String[] args) {
		for (String jsp : FileUtil.allJspFiles(pathWithJSP)) {
			System.out.println("Parsing: "+jsp);
			String text = FileUtil.readFile(pathWithJSP + "/" +jsp);
			String text2 = TextUtil.doReplace(text);

			if (text2!=null) {
				FileUtil.write(text2, pathWithJSP + "/" + jsp);
			} else {
				System.out.println("nothing changed");
			}
			System.out.println();
		}
	}

}
