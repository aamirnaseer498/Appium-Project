import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateDialer {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.samsung.android.dialer");
        uiAutomator2Options.setAppActivity("com.samsung.android.dialer.DialtactsActivity");

        AndroidDriver androidDriver;

        try {
            androidDriver= new AndroidDriver(new URL("http://192.168.137.1:4723/"),uiAutomator2Options);
            Thread.sleep(2000);

            WebElement zeroDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/zero"));
            zeroDigitButton.click();
            Thread.sleep(500);
            WebElement threeDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/three"));
            threeDigitButton.click();
            Thread.sleep(500);
            threeDigitButton.click();
            Thread.sleep(500);
            threeDigitButton.click();
            Thread.sleep(500);
            WebElement oneDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/one"));
            oneDigitButton.click();
            Thread.sleep(500);
            WebElement nineDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/nine"));
            nineDigitButton.click();
            Thread.sleep(500);
            WebElement fourDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/four"));
            fourDigitButton.click();
            Thread.sleep(500);
            WebElement twoDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/two"));
            twoDigitButton.click();
            Thread.sleep(500);
            threeDigitButton.click();
            Thread.sleep(500);
            fourDigitButton.click();
            Thread.sleep(500);
            WebElement sixDigitButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/six"));
            sixDigitButton.click();
            Thread.sleep(500);

            WebElement dialButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.dialer:id/dialButton"));
            dialButton.click();

            Thread.sleep(5000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
