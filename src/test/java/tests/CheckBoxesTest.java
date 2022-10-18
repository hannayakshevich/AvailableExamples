package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxesTest {
    private WebDriver driver;
    private String website = "http://the-internet.herokuapp.com/checkboxes";

    @BeforeClass
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void verifyFirstCheckboxTest(){
        driver.get(website);
        WebElement element = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
        Boolean isFound = element.isDisplayed();
        Assert.assertEquals(isFound, false);
    }

    @Test
    public void clickFirstCheckboxTest(){
        driver.get(website);
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        WebElement element = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
        Boolean isFound = element.isDisplayed();
        Assert.assertEquals(isFound, true);
    }

    @Test
    public void verifySecondCheckboxTest(){
        driver.get(website);
        WebElement element = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
        Boolean isFound = element.isDisplayed();
        Assert.assertEquals(isFound, true);
    }

    @Test
    public void clickSecondCheckboxTest(){
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        WebElement element = driver.findElement(By.cssSelector("[type=checkbox]:checked"));
        Boolean isFound = element.isDisplayed();
        Assert.assertEquals(isFound, false);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
