package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputsTest {
    private WebDriver driver;
    private String website = "http://the-internet.herokuapp.com/inputs";

    @BeforeClass
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void setNumbersTest(){
        driver.get(website);
        WebElement inputElement = driver.findElement(By.tagName("input"));
        inputElement.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputElement.getAttribute("value"), 1);
    }

    @Test
    public void setNotNumbersTest(){
        driver.get(website);
        driver.findElement(By.tagName("input"));
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
