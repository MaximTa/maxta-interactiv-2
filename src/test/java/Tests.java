import geekbrains.Init;

import geekbrains.Locators;
import geekbrains.actions.Waits;
import ru.sbtqa.tag.datajack.Stash;
import geekbrains.actions.Clicks;
import geekbrains.actions.DeepLinks;
import geekbrains.pages.LoginPage;
import org.junit.Assert;

import java.io.IOException;

public class Tests {

    init.getDriver().navigate().to("https://geekbrains.ru/");

    Waits waits = new Waits();
    Locators locators = new Locators();
    Init init = new Init();
    Clicks clicks = new Clicks();

    Stash.put("username",init.props.getProperty("geekbrains.login"));
    Stash.put("password",init.props.getProperty("geekbrains.password"));

    DeepLinks.Login();
     Assert.assertTrue(Stash.getValue("значение для проверки").equals("Курсы"));
    LoginPage loginPage = new LoginPage();
    clicks.click(loginPage.loginEnterButton);

     waits.waitForPageToLoad();

    clicks.click(loginPage.navigationBlock.courses);
    clicks.click(getWebElement(locators.qaEngineerLink));
    LoginPage loginPage = new LoginPage();

        Assert.assertTrue(Stash.getValue("значение для проверки").equals("Курсы"));

}
