
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FilterTest {
    public static void main (String args[]) {

        System.setProperty("webdriver.chrome.driver", "E://Alisia//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://staa-dev-agency.neobytesolutions.com/login");
        //driver.manage().window().maximize();
        //Login
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!lugera!");
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();
        //Click on Vacancy
        driver.findElement(By.xpath("/html/body/nav/a[4]")).click();
        //Filter Vacancies

        driver.findElement(By.xpath("//*[@id=\"filter_country_chosen\"]")).click();
        driver.findElement(By.xpath("//li[contains(text(),'Slovakia')]")).click();
        driver.findElement(By.xpath("//li[contains(text(),'Andovce')]")).click();
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter_country")));
        //driver.findElement(By.xpath("//*[@id=\"filter_country_chosen\"]/a/span")).click();
        //org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("filter_country")));
        //dropdown.selectByValue("4");//*[@id="filter-results-form"]/div[2]/button

        driver.findElement(By.xpath("//*[@id=\"filter_keyword\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_keyword\"]")).sendKeys("developer");
        driver.findElement(By.xpath("//*[@id=\"filter-results-form\"]/div[1]/div[5]/div[2]/div")).click();
        //driver.findElement(By.xpath("//*[@id=\"filter-results-form\"]/div[1]/div[5]/div[2]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter-results-form\"]/div[1]/div[6]/div[5]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"filter-results-form\"]/div[1]/div[7]/div[3]/div")).click();
        //driver.findElement(By.xpath("//*[@id=\"_modal_save_filter_small\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter-results-form\"]/div[2]/button")).click();

    }
}
