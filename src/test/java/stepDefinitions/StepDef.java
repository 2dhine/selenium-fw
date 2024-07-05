package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class    StepDef {
    public WebDriver driver;
    @Given("Open Web Page")
    public void openWebpage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver();
        //driver = new ChromeDriver(options);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println(driver.getTitle());
    }

    @When("Logged in with username (.+) and password (.+)$")
    public void loggedInWithUsernameNameAndPasswordPassword(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("message is displayed")
    public void messageIsDisplayed() {
        driver.findElement(By.id("submit")).click();
        driver.close();
    }
    @Then("^\"([^\"]*)\" message is displayed$")
    public void message_displayed_confirmationPage(String string)
    {

        driver.findElement(By.id("submit")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = driver.findElement(By.id("error")).getText();
        String text1 = driver.findElement(By.xpath("//div[@id='error']")).getText();
        System.out.print(text);
        System.out.print(text1);
        System.out.print(string);
        Assert.assertEquals(text, string);
        //Assert.assertTrue(text.equalsIgnoreCase(string));
        driver.close();
    }
}
