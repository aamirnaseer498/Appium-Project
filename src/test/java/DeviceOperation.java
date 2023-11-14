import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DeviceOperation {

    AndroidDriver deviceAndroidDriver;

    public DeviceOperation(AndroidDriver androidDriver){
        deviceAndroidDriver= androidDriver;
    }

    public void tap(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(200)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 3
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

    public void doubleTap(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 3
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

    public void longPress(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofSeconds(2)));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 3
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

    public void zoomIn(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        PointerInput finger2= new PointerInput(PointerInput.Kind.TOUCH,"finger2");

        // step 3
        Sequence step1= new Sequence(finger1,1);
        step1.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        step1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        step1.addAction(new Pause(finger1,Duration.ofMillis(200)));
        step1.addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), centerOfElement.getX() + 200, centerOfElement.getY() + 200));
        step1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence step2= new Sequence(finger2,1);
        step2.addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        step2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        step2.addAction(new Pause(finger2,Duration.ofMillis(200)));
        step2.addAction(finger2.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), centerOfElement.getX() - 200, centerOfElement.getY() - 200));
        step2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 4
        deviceAndroidDriver.perform(Arrays.asList(step1,step2));
    }

    public void zoomOut(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        PointerInput finger2= new PointerInput(PointerInput.Kind.TOUCH,"finger2");

        // step 3
        Sequence step1= new Sequence(finger1,1);
        step1.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement.getX() + 100, centerOfElement.getY() + 100));
        step1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        step1.addAction(new Pause(finger1,Duration.ofMillis(200)));
        step1.addAction(finger1.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), centerOfElement));
        step1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence step2= new Sequence(finger2,1);
        step2.addAction(finger2.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement.getX() - 100, centerOfElement.getY() - 100));
        step2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        step2.addAction(new Pause(finger2,Duration.ofMillis(200)));
        step2.addAction(finger2.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), centerOfElement));
        step2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 4
        deviceAndroidDriver.perform(Arrays.asList(step1,step2));
    }

    public void swipeDown(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");

        // step 3
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(), centerOfElement.getX(), centerOfElement.getY() - 1000));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 4
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

    public void swipeUp(WebElement webElement){
        // step 1
        Point centerOfElement= new Point(webElement.getLocation().getX() + webElement.getSize().getWidth()/2,
                webElement.getLocation().getY() + webElement.getSize().getHeight()/2);

        // step 2
        PointerInput finger= new PointerInput(PointerInput.Kind.TOUCH,"finger");

        // step 3
        Sequence steps= new Sequence(finger,1);
        steps.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), centerOfElement));
        steps.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        steps.addAction(new Pause(finger,Duration.ofMillis(50)));
        steps.addAction(finger.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(), centerOfElement.getX(), centerOfElement.getY() + 1000));
        steps.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // step 4
        deviceAndroidDriver.perform(Collections.singleton(steps));
    }

}
