import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "E://Alisia//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://staa-dev-agency.neobytesolutions.com/login");
        driver.manage().window().maximize();
        //Login
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!lugera!");
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();

    }

}