import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateSettings {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.android.settings");
        uiAutomator2Options.setAppActivity(".Settings");

        AndroidDriver androidDriver;

        DeviceOperation deviceOperation;

        try {

            androidDriver= new AndroidDriver(new URL("http://192.168.3.20:4723/"),uiAutomator2Options);
            deviceOperation= new DeviceOperation(androidDriver);
            Thread.sleep(2000);

            WebElement connectionsButton= androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Connections\"]"));
            deviceOperation.tap(connectionsButton);
            Thread.sleep(500);

            WebElement bluetoothText= androidDriver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id=\"com.android.settings:id/switch_divider_normal\"])[2]"));
            deviceOperation.tap(bluetoothText);
            Thread.sleep(500);

            WebElement bluetoothSwitch= androidDriver.findElement(AppiumBy.id("com.android.settings:id/switch_widget"));
            deviceOperation.tap(bluetoothSwitch);
            Thread.sleep(3000);

            String resultText= androidDriver.findElement(AppiumBy.id("com.android.settings:id/switch_text")).getText();

            if (resultText.equals("On")){
                System.out.println("Bluetooth Enabled");
            }else if (resultText.equals("Off")){
                System.out.println("Bluetooth Disabled");
            }

            deviceOperation.tap(bluetoothSwitch);
            Thread.sleep(3000);

            resultText= androidDriver.findElement(AppiumBy.id("com.android.settings:id/switch_text")).getText();

            if (resultText.equals("On")){
                System.out.println("Bluetooth Enabled");
            }else if (resultText.equals("Off")){
                System.out.println("Bluetooth Disabled");
            }

            Thread.sleep(5000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
