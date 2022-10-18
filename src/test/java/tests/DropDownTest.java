package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;


public class DropDownTest {

    private WebDriver driver;
    private String website = "http://the-internet.herokuapp.com/dropdown";

    @BeforeClass
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void checkAvailabilityAllElementsTest(){
        driver.get(website);
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        Assert.assertEquals(dropdown.getAllSelectedOptions(), "[1, 2]");
    }

    @Test
    public void chooseFirstElementTest(){
        driver.get(website);

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("1");
    }

    @Test
    public void chooseSecondElementTest(){
        driver.get(website);
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("2");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
