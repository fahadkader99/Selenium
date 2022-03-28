package automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Common_Methods {

    public static byte[] takeScreenShot(){

        byte[] srcFile = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.BYTES);

        return srcFile;
    }
}
