import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateClock {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.sec.android.app.clockpackage");
        uiAutomator2Options.setAppActivity(".ClockPackage");

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL(" http://192.168.100.134:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(2000);

            WebElement alarmTimeText= androidDriver.findElement(AppiumBy.id("com.sec.android.app.clockpackage:id/alarm_item_time"));
            deviceOperation.longPress(alarmTimeText);
            Thread.sleep(500);

            WebElement deleteButton= androidDriver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.sec.android.app.clockpackage:id/navigation_bar_item_icon_view\"])[2]"));
            deviceOperation.tap(deleteButton);
            Thread.sleep(500);

            Thread.sleep(2000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
