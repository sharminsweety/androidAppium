


package calculator;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AndroidDriver driver;

    //cntrl+alt+l for alignment

    @BeforeClass
    public void setAppium() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("udid", "YLD6YXF6MFEIRGTK");
            capabilities.setCapability("platformVersion", "13");
            capabilities.setCapability("deviceName", "narzo 50");
            capabilities.setCapability("appPackage", "com.bng.calculator");
            capabilities.setCapability("appActivity", "com.bng.calc.MainActivity");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
            capabilities.setCapability("noReset", "true");


            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.startRecordingScreen(); // eta AndroidDriver  er method eta dile record er kaj suru hoi
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterClass
    void tearDown() {

        driver.quit();
    }

    public  void takeScreenshot() {
        //eta sel ar appium e same method we can use it in web too
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //driver passe na as eta static method e ace ekhne driver ekta method
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";//bild auto screenshots directory banabe
            FileUtils.copyFile(scrFile, new File(currentDir + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

