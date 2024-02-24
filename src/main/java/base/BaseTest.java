package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    ExtentReports reports;
    ExtentSparkReporter sparkReporter;
    ExtentTest logger;

    @BeforeTest
    public void beforeTest(){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/reports");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        reports.setSystemInfo("HostName", "RHEL8");
        reports.setSystemInfo("Username", "root");
        sparkReporter.config().setDocumentTitle("Report");
        sparkReporter.config().setReportName("Test Script Result");
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browserName, Method methodName){
        logger = reports.createTest(methodName.getName());
        setUpBrowser(browserName);
        driver.get(Constants.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case Failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case Passed", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest(){
        reports.flush();
    }

    public void setUpBrowser(String browserName){
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
    }
}
