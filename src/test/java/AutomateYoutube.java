import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateYoutube {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.google.android.youtube");
        uiAutomator2Options.setAppActivity("com.google.android.youtube.HomeActivity");
        uiAutomator2Options.setAutoGrantPermissions(true);

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL("http://192.168.100.134:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(7500);

            WebElement feedArea= androidDriver.findElement(AppiumBy.id("com.google.android.youtube:id/pane_fragment_container"));
            deviceOperation.swipeDown(feedArea);
            Thread.sleep(2000);
            deviceOperation.swipeDown(feedArea);
            Thread.sleep(2000);
            deviceOperation.swipeDown(feedArea);
            Thread.sleep(2000);
            deviceOperation.swipeUp(feedArea);
            Thread.sleep(2000);

            Thread.sleep(2500);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
