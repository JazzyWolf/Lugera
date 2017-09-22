import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestUploadVacancyUrl {
    public static void main (String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E://Alisia//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://staa-dev-agency.neobytesolutions.com//login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://staa-dev-agency.neobytesolutions.com/login");
        //driver.manage().window().maximize();

        //Login
        System.out.println("This is the Login");
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!lugera!");
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();

        //Click on Upload Vacancy toolbar
        driver.findElement(By.xpath("//*[@id=\"toolBar\"]/div[1]")).click();

        //Click on radio button Extract from url
        driver.findElement(By.xpath("//*[@id=\"fieldTwo\"]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"upload_document_form\"]/div/div[2]/div/div[2]/input[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"upload_document_form\"]/div/div[2]/div/div[2]/input[2]")).sendKeys("https://www.work.ua/jobs/971254");
        System.out.println("Extract from URL");
        //Click on Ok in modal window
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='ui approve positive button']")).click();

        //Click on Documents tab
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/nav/a[3]")).click();

        //Click on Fetch Requests
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]/div[2]/a")).click();
    }
}
