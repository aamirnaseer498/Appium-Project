import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateGalleryZoomInOut {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.sec.android.gallery3d");
        uiAutomator2Options.setAppActivity("com.samsung.android.gallery.app.activity.GalleryActivity");
        uiAutomator2Options.setAutoGrantPermissions(true);
        uiAutomator2Options.noReset();

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL(" http://192.168.100.134:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(2000);

            WebElement firstImage= androidDriver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.sec.android.gallery3d:id/thumbnail\"])[3]"));
            deviceOperation.tap(firstImage);
            Thread.sleep(500);

            WebElement imageArea= androidDriver.findElement(AppiumBy.id("com.sec.android.gallery3d:id/top_center_decor_layout"));
            deviceOperation.zoomIn(imageArea);
            Thread.sleep(500);

            Thread.sleep(2000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
