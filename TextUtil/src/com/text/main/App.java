package com.text.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.text.util.TextUtil;

public class App {

	public static void main(String[] args) {
		String text = TextUtil.readFile("");

	}

	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(fileEntry.getName());
			}
		}
	}

	public void allFiles() {
		try {
			Files.walk(Paths.get("/home/you/Desktop")).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					System.out.println(filePath);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
