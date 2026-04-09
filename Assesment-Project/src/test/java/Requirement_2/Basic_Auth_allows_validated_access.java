package Requirement_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Basic_Auth_allows_validated_access {


    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.xpath("//li//a[text()= 'Basic Auth']")).click();
        String user = "admin";
        String pass = "admin";
        String url = "the-internet.herokuapp.com/basic_auth";

        driver.get("https://" + user + ":" + pass + "@" + url);
        Thread.sleep(4000);

        List<WebElement> elements = driver.findElements(By.xpath("//div//div//p[contains(text(), " +
                "'Congratulations')]"));

        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            System.out.println("PASSED : The user successfully logged in.");
        } else {
            System.out.println("FAILED : The user not able to logged in");
        }
        driver.quit();
    }

}



