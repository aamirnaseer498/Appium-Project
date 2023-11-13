import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateGalleryDoubleTap {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.sec.android.gallery3d");
        uiAutomator2Options.setAppActivity("com.samsung.android.gallery.app.activity.GalleryActivity");

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL(" http://192.168.100.134:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(2000);

            WebElement albumsButton= androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.sec.android.gallery3d:id/title\" and @text=\"Albums\"]"));
            deviceOperation.tap(albumsButton);
            Thread.sleep(500);

            WebElement ScreenshotsButton= androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.sec.android.gallery3d:id/title\" and @text=\"Screenshots\"]\n"));
            deviceOperation.tap(ScreenshotsButton);
            Thread.sleep(500);

            WebElement firstImage= androidDriver.findElement(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"com.sec.android.gallery3d:id/thumbnail_preview_layout\"])[6]\n"));
            deviceOperation.tap(firstImage);
            Thread.sleep(500);

            WebElement fullImage= androidDriver.findElement(AppiumBy.id("com.sec.android.gallery3d:id/top_center_decor_layout"));
            deviceOperation.doubleTap(fullImage);
            Thread.sleep(500);

            Thread.sleep(2000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
