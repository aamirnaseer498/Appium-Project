import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppInstallDevice {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setApp("C:\\Users\\user\\Downloads\\Snapseed_2.21.0.566275366_Apkpure.apk");

        AndroidDriver androidDriver;

        try {
            androidDriver= new AndroidDriver(new URL("http://192.168.115.12:4723/"),uiAutomator2Options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}
