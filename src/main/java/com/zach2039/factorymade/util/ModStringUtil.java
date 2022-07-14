package com.zach2039.factorymade.util;

import net.minecraft.world.item.DyeColor;

public class ModStringUtil {
	public static String capitalize(String str) {
		if(str == null || str.isEmpty()) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String capitalizeWords(String str){
		String words[] = str.split("\\s");

		String capitalizeWord = "";

		for(String w : words){
			String first = w.substring(0,1);
			String afterfirst = w.substring(1);
			capitalizeWord += first.toUpperCase() + afterfirst + " ";
		}

		return capitalizeWord.trim();
	}

	public static String getColorName(DyeColor color) {
		String variantName = color.getSerializedName().replace('_', ' ');
		String colorName = ModStringUtil.capitalizeWords(variantName);
		return colorName;
	}

}
