import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomatePlayer {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.mxtech.videoplayer.ad");
        uiAutomator2Options.setAppActivity("com.mxtech.videoplayer.ad.ActivityWelcomeMX");
        uiAutomator2Options.setAutoGrantPermissions(true);

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL("http://192.168.100.134:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(2500);

            WebElement musicButton= androidDriver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.mxtech.videoplayer.ad:id/music_tab\"]/android.widget.ImageView"));
            deviceOperation.tap(musicButton);
            Thread.sleep(5000);

            WebElement trackText= androidDriver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mxtech.videoplayer.ad:id/rv_content\"]/android.view.ViewGroup[1]"));
            deviceOperation.tap(trackText);
            Thread.sleep(500);

            WebElement trackSeekBar= androidDriver.findElement(AppiumBy.id("com.mxtech.videoplayer.ad:id/music_progress"));
            deviceOperation.seekForward(trackSeekBar);
            Thread.sleep(500);
            deviceOperation.seekBackward(trackSeekBar);
            Thread.sleep(500);

            Thread.sleep(2500);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
