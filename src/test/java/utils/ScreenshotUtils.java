package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class ScreenshotUtils extends BaseTest{

	
	public static void CaptureScreenshot() throws IOException
	{
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "_").replace(":", "_");
	//	System.out.println(currentdate);
		File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(".//Screenshot/"+screenshotfilename+".png") );
	}
}
