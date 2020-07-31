package geekbrains.actions;

import geekbrains.Init;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Clicks {
    public void click (WebElement element) throws InterruptedException {
        Actions actions = new Actions(Init.getDriver());
        JavascriptExecutor executor = (JavascriptExecutor) Init.getDriver();
        boolean isClicked = false;
        long startTime = new Waits().Now();
        while (((new Waits().Now() - startTime)/1000)< Waits.medium_wait) {
            try {
                Assert.assertTrue(element.isDisplayed());
                actions.moveToElement(element).build().perform();
                executor.executeScript("arguments[0].scrollIntoView(); ", element);
                executor.executeScript("arguments[0].focus(); ", element);
                executor.executeScript("arguments[0].click(); ", element);
                isClicked = true;
                break;
            } catch (Exception e) {
                LOGGER.info ("Клик не отрабатывает с первого раза - делаю повторный клик");
}
            Thread.sleep(500);
        }
        Assert.assertTrue("Не произошло клика", isClicked);
    }
}