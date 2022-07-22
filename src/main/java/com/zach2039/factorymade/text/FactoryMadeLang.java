package com.zach2039.factorymade.text;

import com.zach2039.factorymade.FactoryMade;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;

/**
 * Adapted from Mekanism's APILang under the following license:
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2017-2020 Aidan C. Brady
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public enum FactoryMadeLang {
	;

	private final String key;

	FactoryMadeLang(final String type, final String path) {
		this(Util.makeDescriptionId(type, new ResourceLocation(FactoryMade.MODID, path)));
	}

	FactoryMadeLang(final String key) {
		this.key = key;
	}

	public String getTranslationKey() {
		return key;
	}

	private static String prefix() {
		return FactoryMade.MODID + ".";
	}
}
