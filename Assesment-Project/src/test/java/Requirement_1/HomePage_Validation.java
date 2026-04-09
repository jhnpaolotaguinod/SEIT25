package Requirement_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;

public class HomePage_Validation {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");
        List<String> valuesToCheck = Arrays.asList("A/B Testing", "Add/Remove Elements", "Basic Auth",
                "Broken Images", "Challenging DOM", "Context Menu", "Digest Authentication",
                "Disappearing Elements", "Drag and Drop", "Dropdown", "Dynamic Content",
                "Dynamic Controls", "Dynamic Loading", "Entry Ad", "Exit Intent", "File Download",
                "File Upload", "Floating Menu", "Forgot Password", "Form Authentication",
                "Geolocation", "Horizontal Slider", "Infinite Scroll", "Inputs",
                "JavaScript Alerts", "JavaScript onload event error", "Key Presses",
                "Large & Deep DOM", "Multiple Windows", "Nested Frames", "Notification Messages",
                "Redirect Link", "Secure File Download", "Shadow DOM", "Shifting Content",
                "Slow Resources", "Sortable Data Tables", "Status Codes", "Typos", "WYSIWYG Editor");

        System.out.println("Home Page List Validation - Scenario 1");


        for (String value : valuesToCheck) {

            List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + value + "')]"));

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                System.out.println("PASSED : The value " + value + " displayed on the page.");
            } else {
                System.out.println("FAILED : The value " + value + "  not displayed on the page");
            }
        }

        driver.quit();

    }

        }

