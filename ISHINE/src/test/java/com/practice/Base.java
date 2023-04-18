package com.practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class Base extends IshinePortal {

	public static String ScreenshotFile(String name) throws IOException {

		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		String format = tm.format(date);
		System.out.println(format);

		String userdir = System.getProperty("user.dir");

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = userdir + "\\Screenshot\\" + "image_" + format + ".png";
		Files.copy(screenshot, new File(path));

		return path;

	}



}
