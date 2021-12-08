package flipkart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AddToCart {

    WebDriver driver;
    @Test
    void shoppingPage() {

        //Amazon
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone 12" + Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(text(),'New Apple iPhone 12 Pro (128GB) - Graphite')]")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("add-to-cart-button")).click();



    }
    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

    }
    @AfterTest
    void closeBrowser()  {
        System.out.println("Successfully Adding");
        //driver.quit();
    }


}