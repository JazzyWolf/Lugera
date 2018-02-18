import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;

public class CheckWebpageElements {

    ExtentReports extent;
    ExtentTest test;
    public WebDriver driver;


    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "F:\\Work\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://staa-dev-agency.neobytesolutions.com/login");
    }

    @BeforeTest
    public void startReport(){
        extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/MyOwnReport1.html", true);
        extent.addSystemInfo("Host Name", "Neobyte")
                .addSystemInfo("Environment", "Automation")
                .addSystemInfo("User Name", "JazzyWolf");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

    }

    @BeforeMethod(alwaysRun = true)
    public void login() {

        test=extent.startTest("Logging in...");

        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("!lugera!");
        driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"_submit\"]")).click();

        List<WebElement> mainDashboard = driver.findElements(By.xpath("//*[@id=\"mainDashboard\"]/div[1]"));
        if (!mainDashboard.isEmpty()){

            test.log(LogStatus.PASS, "Log in is successful!");
        } else {

            test.log(LogStatus.FAIL, "Unable to log in...");
        }



    }

    @Test(priority = 4)
    public void checkElements() throws InterruptedException  {
        test=extent.startTest("Starting check if elements on page are displayed");

        ///////Check Dashboard page//////

        try {
            System.out.println("Checking whether Dashboard is working...");
            test.log(LogStatus.PASS, "Checking if Dashboard is working");

            if (driver.findElement(By.id("toggleStatistics")).isDisplayed()) {
                System.out.println("Dashboard is working!");
            } else {
                System.out.println("Dashboard is broken...");
                test.log(LogStatus.FAIL, "Dashboard is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Dashboard is not loading, moving on.");
            System.out.println("Dashboard not working, moving on");
        }

        //////Check Vacancies page/////

        try {
            driver.findElement(By.xpath("/html/body/nav/a[2]")).click();
            test.log(LogStatus.PASS, "Checking if Vacancies is working");

            System.out.println("Verifying Vacancies page...");

            if (driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Vacancies page has loaded successfully!");
            } else {
                System.out.println("Vacancies page is not loading...");
                test.log(LogStatus.FAIL, "Vacancies is not loading, abort.");
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL , "Vacancies is not loading, moving on.");
            System.out.println("Vacancies not working, moving on");
        }



        ///////Check Candidates///////

        try {
            driver.findElement(By.xpath("/html/body/nav/a[3]")).click();
            test.log(LogStatus.PASS, "Checking if Candidates is working");

            System.out.println("Checking if Candidates page is working...");
            //*Thread.sleep(3000);*//*
            if (driver.findElement(By.xpath("/html/body/div[1]/div/div[2]")).isDisplayed()) {
                System.out.println("Candidates page is working!");
            } else {
                System.out.println("Candidates page is not loading...");
                test.log(LogStatus.FAIL, "Candidates is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Candidates is not loading, moving on.");
            System.out.println("Candidates not working, moving on");
        }



        ////////Check Documents page////////

        try {
            driver.findElement(By.xpath("/html/body/nav/a[4]")).click();
            test.log(LogStatus.PASS, "Checking if Documents is working");

            System.out.println("Checking if Document page is working...");
            if (driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div")).isDisplayed()) {
                System.out.println("Documents page has loaded successfully!");
            } else {
                System.out.println("Documents page is not loading...");
                test.log(LogStatus.FAIL, "Documents is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Documents is not loading, moving on.");
            System.out.println("Documents not working, moving on");
        }



        ////////Check Statistics page////////

        try {

            driver.findElement(By.xpath("/html/body/nav/a[5]")).click();

            System.out.println("Checking if Statistics page is working...");
            test.log(LogStatus.PASS, "Checking if Statistics is working");

            if (driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div")).isDisplayed()) {
                System.out.println("Statistics page has loaded successfully!");
            } else {
                System.out.println("Statistics page is not loading...");
                test.log(LogStatus.FAIL, "Statistics is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Statistics is not loading, moving on.");
            System.out.println("Statistics not working, moving on");
        }



        ////////Check Users Page///////

        try {

            driver.findElement(By.xpath("/html/body/nav/a[6]")).click();
            test.log(LogStatus.PASS, "Checking if Users is working");

            System.out.println("Checking if Users page is working...");
            if (driver.findElement(By.xpath("//*[@id=\"user_listing_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Users page has loaded successfully!");
            } else {
                System.out.println("Users page is not loading...");
                test.log(LogStatus.FAIL, "Users is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Users is not loading, moving on.");
            System.out.println("Users not working, moving on");
        }



        //////Check Filters Page//////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();

            test.log(LogStatus.PASS, "Checking if Filters is working");

            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[1]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[1]")).click();

            System.out.println("Checking if Filters page is working...");
            if (driver.findElement(By.xpath("//*[@id=\"filter_tabs\"]/div[2]")).isDisplayed()) {
                System.out.println("Filters page has loaded successfully!");
            } else {
                System.out.println("Filters page is not loading...");
                test.log(LogStatus.FAIL, "Filters is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Filters is not loading, moving on.");
            System.out.println("Filters not working, moving on");
        }


        /////Check Tickets page//////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Tickets is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[2]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[2]")).click();

            System.out.println("Checking if Tickets page is working...");
            if (driver.findElement(By.xpath("//*[@id=\"ticketDataTable_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Tickets page has loaded successfully!");
            } else {
                System.out.println("Tickets page is not loading...");
                test.log(LogStatus.FAIL, "Tickets is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Tickets is not loading, moving on.");
            System.out.println("Tickets not working, moving on");
        }


        /////Check Contacts page//////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Contacts is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[3]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[3]")).click();

            System.out.println("Checking if Contacts page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"contactDataTable_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Contacts page has loaded successfully!");
            } else {
                System.out.println("Contacts page is not loading...");
                test.log(LogStatus.FAIL, "Contacts is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Contacts is not loading, moving on.");
            System.out.println("Contacts not working, moving on");
        }



        /////Check Countries page/////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Countries is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[4]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[4]")).click();

            System.out.println("Checking if Countries page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"country_listing_table_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Countries page has loaded successfully!");
            } else {
                System.out.println("Countries page is not loading...");
                test.log(LogStatus.FAIL, "Countries is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Countries is not loading, moving on.");
            System.out.println("Countries not working, moving on");
        }


        //////Check Widgets page//////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Widgets is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[5]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[5]")).click();

            System.out.println("Checking if Widgets page is loading...");
            if (driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div")).isDisplayed()) {
                System.out.println("Widgets page has loaded successfully!");
            } else {
                System.out.println("Widgets page is not loading...");
                test.log(LogStatus.FAIL, "Widgets is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Widgets is not loading, moving on.");
            System.out.println("Widgets not working, moving on");
        }


        /////Check Experiences page////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Experiences is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[6]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[6]")).click();

            Thread.sleep(6000);

            System.out.println("Checking if Experiences page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"experienceDataTable_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Experiences page has loaded successfully!");
            } else {
                System.out.println("Experiences page is not loading...");
                test.log(LogStatus.FAIL, "Experiences is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Experiences is not loading, moving on.");
            System.out.println("Experiences not working, moving on");
        }

        /////Check User Feedback page////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if User Feedback is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[7]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[7]")).click();

            System.out.println("Checking if User Feedback page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"userFeedback_listing_table_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("User Feedback page has loaded successfully!");
            } else {
                System.out.println("User Feedback page is not loading...");
                test.log(LogStatus.FAIL, "User Feedback is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "User feedback is not loading, moving on.");
            System.out.println("User feedback not working, moving on");
        }


        ////Check Options page/////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Options is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[8]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[8]")).click();

            System.out.println("Checking if Options page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"option_listing_table_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Options page has loaded successfully!");
            } else {
                System.out.println("Options page is not loading...");
                test.log(LogStatus.FAIL, "Options is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Options is not loading, moving on.");
            System.out.println("Options not working, moving on");
        }

        ////////Check Matching configuration page/////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Matching config is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[9]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[9]")).click();

            System.out.println("Checking if Matching configuration page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"matching_configuration_listing_table_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Matching configuration page has loaded successfully!");
            } else {
                System.out.println("Matching configuration page is not loading...");
                test.log(LogStatus.FAIL, "Matching configuration is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Matching configuration is not loading, moving on.");
            System.out.println("Matching configuration not working, moving on");
        }

        ///////Check Notification sentences page/////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Notification sentences is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[10]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[10]")).click();

            System.out.println("Checking if Notification sentences page is loading...");
            if (driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_wrapper\"]/div/div[2]/div")).isDisplayed()) {
                System.out.println("Notification sentences page has loaded successfully!");
            } else {
                System.out.println("Notification sentences page is not working...");
                test.log(LogStatus.FAIL, "Notifications sentences is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Notification sentences is not loading, moving on.");
            System.out.println("Notification sentences not working, moving on");
        }

        ////////Check Notification distribution page//////

        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Notification distribution is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[11]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[11]")).click();

            System.out.println("Checking if Notification distribution page is loading..,");
            if (driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div")).isDisplayed()) {
                System.out.println("Notification distribution page has loaded successfully!");
            } else {
                System.out.println("Notification distribution page is not working...");
                test.log(LogStatus.FAIL, "Notification distribution is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Notification distribution is not loading, moving on.");
            System.out.println("Notification distribution not working, moving on");
        }

        ////////Check Settings page///////
        try {
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
            test.log(LogStatus.PASS, "Checking if Settings is working");
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[12]")));
            driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[12]")).click();

            System.out.println("Checking if Settings page is loading...");
            if (driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).isDisplayed()) {
                System.out.println("Settings page has loaded successfully!");
            } else {
                System.out.println("Settings page is not loading...");
                test.log(LogStatus.FAIL, "Settings is not loading, abort.");
            }
        } catch (Exception e){
            test.log(LogStatus.FAIL , "Settings is not loading, moving on.");
            System.out.println("Settings not working, moving on");
        }


    }



    @AfterClass
    public void endreport() {

        extent.flush();
        driver.quit();
    }


    @AfterMethod
    public void logout(){
        test.log(LogStatus.PASS, "Logging out...");
        System.out.println("Logging out");
        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[14]")));
        driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/div[1]/div/a[14]")).click();
    }

    public void getResult(ITestResult result) {
        if(result.getStatus()== ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());

        }
        extent.endTest(test);

    }

}
