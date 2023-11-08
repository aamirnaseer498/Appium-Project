import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateCalculator {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.google.android.calculator");
        uiAutomator2Options.setAppActivity("com.android.calculator2.Calculator");

        AndroidDriver androidDriver;

        try {
            androidDriver= new AndroidDriver(new URL("http://192.168.137.1:4723/"),uiAutomator2Options);
            Thread.sleep(2000);

            WebElement sevenDigitButton= androidDriver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7"));
            sevenDigitButton.click();
            Thread.sleep(1000);
            WebElement plusButton= androidDriver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
            plusButton.click();
            Thread.sleep(1000);
            WebElement threeDigitButton= androidDriver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_3"));
            threeDigitButton.click();
            Thread.sleep(1000);
            WebElement equalButton= androidDriver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
            equalButton.click();
            Thread.sleep(1000);
            String resultText= androidDriver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();

            if (resultText.equals("10")){
                System.out.println("Test Passed");
            }else {
                System.out.println("Test Failed");
            }

            Thread.sleep(2000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
