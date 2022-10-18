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

public class AddRemoveElementsTest {
    private WebDriver driver;
    private String website = "http://the-internet.herokuapp.com/add_remove_elements/";

    @BeforeClass
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void addOneElementTest(){
        driver.get(website);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        WebElement element = driver.findElement(By.xpath("//button[text()='Delete']"));
        Boolean display = element.isDisplayed();
        Assert.assertEquals(display, true);
    }

    @Test
    public void addTwoElementsTest(){
        driver.get(website);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        Boolean isPresent = driver.findElements(By.xpath("//button[text()='Delete']")).size() >1;
        Assert.assertEquals(isPresent, true);
    }

    @Test
    public void deleteOneElementTest(){
        driver.get(website);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        Boolean isPresent = driver.findElements(By.xpath("//button[text()='Delete']")).size() >0;
        Assert.assertEquals(isPresent, false);

    }

    @Test
    public void deleteTwoElementTest(){
        driver.get(website);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        Boolean isPresent = driver.findElements(By.xpath("//button[text()='Delete']")).size() >0;
        Assert.assertEquals(isPresent, false);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
