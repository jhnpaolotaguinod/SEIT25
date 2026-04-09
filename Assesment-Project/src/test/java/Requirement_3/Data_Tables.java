package Requirement_3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_Tables {
    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // driver.get("https://the-internet.herokuapp.com");

        try {
            driver.get("https://the-internet.herokuapp.com/");
            driver.findElement(By.xpath("//li//a[text()= 'Sortable Data Tables']")).click();


            List<String[]> expectedUsers = new ArrayList<>();
            expectedUsers.add(new String[]{"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com"});
            expectedUsers.add(new String[]{"Bach", "Frank", "fbach@yahoo.com", "$51.00", "http://www.frank.com"});
            expectedUsers.add(new String[]{"Doe", "Jason", "jdoe@hotmail.com", "$100.00", "http://www.jdoe.com"});
            expectedUsers.add(new String[]{"Conway", "Tim", "tconway@earthlink.net", "$50.00", "http://www.timconway.com"});

            System.out.println("Validating Example 1 Table displays the 4 results");

            for (String[] user : expectedUsers) {
                String lName = user[0];
                String fName = user[1];
                String email = user[2];
                String Due = user[3];
                String WebSite = user[4];


                String rowXPath = "//table//tr[" +
                        "td[contains(text(), '" + lName + "')] and " +
                        "td[contains(text(), '" + fName + "')] and " +
                        "td[contains(text(), '" + email + "')] and " +
                        "td[contains(text(), '" + Due + "')] and " +
                        "td[contains(text(), '" + WebSite + "')] ]";

                List<WebElement> foundRows = driver.findElements(By.xpath(rowXPath));

                if (!foundRows.isEmpty() && foundRows.get(0).isDisplayed()) {
                    System.out.println("[PASS] Found: " + lName + " " + fName + " " + email + " " + Due + " (" + WebSite + ")");

                } else {
                    System.out.println("[FAIL] Missing: " + lName + " " + fName + " " + email + " " + Due + " (" + WebSite + ")");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
}
