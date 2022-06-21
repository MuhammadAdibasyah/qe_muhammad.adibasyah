package test.mobile.driver;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverPool  {
    public static AndroidDriver create() {
        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        String appiumUrl = "http://127.0.0.1:4723/wd/hub/";

        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configProperties.getAndroid().getAppPackage());
//        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configProperties.getAndroid().getAppActivity());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + File.separator + "app/Kanbo.apk");
        caps.setCapability(String.valueOf(Setting.WAIT_FOR_IDLE_TIMEOUT), 1);


        try {
            driver = new AndroidDriver<AndroidElement>(new URL(appiumUrl), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
