import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class AutomateMessages {

    public static void main(String[] args) {

        UiAutomator2Options uiAutomator2Options= new UiAutomator2Options();

        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setPlatformVersion("13");
        uiAutomator2Options.setDeviceName("Galaxy A04e");
        uiAutomator2Options.setAppPackage("com.samsung.android.messaging");
        uiAutomator2Options.setAppActivity("com.android.mms.ui.ConversationComposer");

        AndroidDriver androidDriver;

        try {

            androidDriver= new AndroidDriver(new URL("http://192.168.3.20:4723/"),uiAutomator2Options);
            Thread.sleep(2000);

            WebElement composeButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.messaging:id/fab"));
            composeButton.click();
            Thread.sleep(500);

            WebElement recipientField= androidDriver.findElement(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to"));
            recipientField.sendKeys("03331942346");
            Thread.sleep(500);

            WebElement messageField= androidDriver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text"));
            messageField.sendKeys("This is a test message");
            Thread.sleep(500);

            WebElement sendButton= androidDriver.findElement(AppiumBy.id("com.samsung.android.messaging:id/send_button"));
            sendButton.click();
            Thread.sleep(500);

            Thread.sleep(5000);
            androidDriver.quit();

        } catch (MalformedURLException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
