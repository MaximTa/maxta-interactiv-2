package geekbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Init {

    public Properties props = new Properties();
    private static WebDriver driver;

    public Init(){
        startFirefoxDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    private void startFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "scr/main/resources/drivers/geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile geekBrainsATprofile = profile.getProfile("selenium");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(geekBrainsATprofile);

        Map<String,Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_settings.popups", 1);
        prefs.put("download.default_directory", "C:\\CustomFolderForFirefoxDownloads");
        driver = new FirefoxDriver(options);
    }
   // private void startIEDriver(){
     //   System.setProperty("webdriver.ie.driver", "scr/main/resources/drivers/IEDriverServer.exe");
       // InternetExplorerOptions options = new InternetExplorerOptions();
       // options.withInitialBrowserUrl();
      //  driver = new InternetExplorerDriver(options);
      //  driver.navigate().to("https://geekbrains.ru/");

  //  }
    public static void main(String[] args) {

        Init init = new Init();
    }
}
