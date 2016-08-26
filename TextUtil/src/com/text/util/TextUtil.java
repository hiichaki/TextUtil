package com.text.util;

import com.text.main.App;
import com.text.model.Indexes;

public class TextUtil {

	public static String doReplace(String text) {
		boolean changed = false;
		for (int i = 0; i < StaticVars.BEGIN_TAG.length; ++i) {
			Indexes indexes = new Indexes(text, StaticVars.BEGIN_TAG[i], "/>");

			while (indexes.isValid()) {
				try {
					for (Integer j = 0; j < StaticVars.BEGIN_PHRASE.length; ++j) {
						String tag = indexes.getOccurence();
						String phrase = new Indexes(tag, StaticVars.BEGIN_PHRASE[j], "\"").getOccurence().replace("\"",
								"");
						String propertyVar = getVariableFromProperties(phrase);
						if (propertyVar != null) {
							text = text.replace(phrase, propertyVar);
							changed = true;
							System.out.println(phrase + "| replaced with |" + propertyVar);
						}
					}
				} catch (NullPointerException ex) {
					System.out.println("NPE");
				}

				indexes.next();
			}
		}

		if (changed) {
			return text;
		}
		
		return null;
		
	}

	public static String getVariableFromProperties(String phrase) {
		int index = App.PROPERTIES.indexOf(phrase + "\n");
		if (index > 0) {
			int beginIndex;
			int endIndex = -1;
			for (int i = index; i > 0; --i) {
				if (App.PROPERTIES.charAt(i) == '=') {
					endIndex = i;
				}
				if (App.PROPERTIES.charAt(i) == '\n') {
					beginIndex = i + 1;
					return App.PROPERTIES.substring(beginIndex, endIndex);
				}
			}
		}
		return null;

	}

}
