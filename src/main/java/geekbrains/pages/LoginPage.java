package geekbrains.pages;

import geekbrains.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    @FindBy(xpath = "//*[@name='user[email]']")
    public WebElement loginEmail;

    @FindBy(xpath = "//*[@name='user[password]']")
    public WebElement loginPassword;

    @FindBy(xpath = "//*[@id='new_user']//*[@value='Войти']")
    public WebElement loginEnterButton;


    public LoginPage() throws IOException {
        Init init = new Init();
        PageFactory.initElements(init.getDriver(), this);
    }
}
