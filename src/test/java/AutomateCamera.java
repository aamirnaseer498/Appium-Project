import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateCamera {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.sec.android.app.camera");
        uiAutomator2Options.setAppActivity("com.android.camera.CameraActivity");
        uiAutomator2Options.setAutoGrantPermissions(true);

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL("http://192.168.100.134:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(2000);

            WebElement cameraArea= androidDriver.findElement(AppiumBy.id("com.sec.android.app.camera:id/mdp_preview_content"));
            deviceOperation.zoomIn(cameraArea);
            Thread.sleep(500);
            deviceOperation.zoomOut(cameraArea);
            Thread.sleep(500);

            Thread.sleep(2000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
