package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MagicHealthLocators;

public class MagicHealthMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public MagicHealthMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjusted timeout to a reasonable duration
    }

    public void validateTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Validation Passed: " + actualTitle);
        } else {
            System.out.println("Title Validation Failed. Expected: " + expectedTitle + ", Found: " + actualTitle);
        }
    }

    public void verifyHomeBtnClickable() {
        try {
            WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(new MagicHealthLocators().HomeTabBtn));
            homeBtn.click();
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl.equals("https://magichealth.io/") 
                ? "Home button is clickable and redirects correctly." 
                : "Home button click failed or incorrect redirection.");
        } catch (Exception e) {
            System.out.println("Error while verifying Home button: " + e.getMessage());
        }
    }
    
    public void verifyandclickExploreSolutionBtn() {
        try 
        {
            WebElement exploreSolutionBtn = wait.until(ExpectedConditions.elementToBeClickable(new MagicHealthLocators().ExploreSolutionBtn));
            exploreSolutionBtn.click();
            System.out.println("Successfully clicked on 'EXPLORE SOLUTIONS' button and navigated to the Products page.");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while clicking on 'EXPLORE SOLUTIONS' button: " + e.getMessage());
        }
    }
    
    public void verifyandclickRequestDemoBtn() {
        try 
        {
            WebElement requestDemoArrow = wait.until(ExpectedConditions.elementToBeClickable(new MagicHealthLocators().RquestDemoArrow));
            requestDemoArrow.click();
            System.out.println("Successfully clicked on 'Request Demo' button and navigated to the Contact us form.");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while clicking on 'Request Demo' arrow: " + e.getMessage());
        }
    }
    
    public void verifyContactUsForm() {
        try {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(new MagicHealthLocators().ContactUsForm)).isDisplayed()) {
                System.out.println("Contact Us form is visible.");
            }
        } catch (Exception e) {
            System.out.println("Contact Us form is not visible: " + e.getMessage());
        }
    }
    
    public void enterText(By locator, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        } catch (Exception e) {
            System.err.println("Error entering text: " + e.getMessage());
            Assert.fail("Failed to enter text: " + e.getMessage());
        }
    }
    
    public void ClickAndEnterName(String name) {
        driver.findElement(MagicHealthLocators.EnterName).click();
        driver.findElement(MagicHealthLocators.EnterName).sendKeys(name);
    }

    public void ClickAndEnterEmail(String email) {
        driver.findElement(MagicHealthLocators.EnterEmail).click();
        driver.findElement(MagicHealthLocators.EnterEmail).sendKeys(email);
    }

    public void ClickAndEnterCompanyName(String companyName) {
        driver.findElement(MagicHealthLocators.EnterCompanyName).click();
        driver.findElement(MagicHealthLocators.EnterCompanyName).sendKeys(companyName);
    }

    public void ClickAndEnterPhoneNum(String phoneNum) {
        driver.findElement(MagicHealthLocators.EnterPhone).click();
        driver.findElement(MagicHealthLocators.EnterPhone).sendKeys(phoneNum);
    }

    public void ClickSendButton() {
        driver.findElement(MagicHealthLocators.SendButton).click();
    }
    
    public void VerifyStatusMessage() {
        try {
            String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MagicHealthLocators.StatusMessage)).getText();
            Assert.assertEquals(actualMessage, "Your message has been submitted. Thank you!", "Status message verification failed.");
            System.out.println("Status message verified: " + actualMessage);
        } catch (Exception e) {
            System.err.println("Error verifying status message: " + e.getMessage());
            Assert.fail("Status message verification failed: " + e.getMessage()); // Fail the test
        }
    }
    
    public void verifyandclickExploreOurSolutionBtn() {
        try {
            By exploreSolutionLocator = new MagicHealthLocators().ExploreOurSolutionBtn;
            if (driver.findElements(exploreSolutionLocator).size() == 0) {
                Assert.fail("Explore Our Solution button NOT FOUND in the DOM!");
                return;
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
            Thread.sleep(500);
            WebElement exploreSolutionBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(exploreSolutionLocator));
            exploreSolutionBtn = wait.until(ExpectedConditions.elementToBeClickable(exploreSolutionLocator));
            if (!exploreSolutionBtn.isDisplayed() || !exploreSolutionBtn.isEnabled()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exploreSolutionBtn);
                Thread.sleep(500); // Wait for the element to become visible
            }
            exploreSolutionBtn.click();
            System.out.println("Clicked 'EXPLORE OUR SOLUTION'");

        } catch (NoSuchElementException nsee) {
            System.err.println("NoSuchElementException: Element not found: " + nsee.getMessage());
            Assert.fail("Element not found: " + nsee.getMessage());
        } catch (InterruptedException ie) {
            System.err.println("Interrupted: " + ie.getMessage());
            Thread.currentThread().interrupt();
            Assert.fail("Interrupted: " + ie.getMessage());
        } catch (Exception e) {
            System.err.println("Error clicking 'EXPLORE OUR SOLUTION': " + e.getMessage());
            Assert.fail("Click failed: " + e.getMessage());
        }
    }
    
    public void verifyProductsBtnClickable() {
        try {
            WebElement ProductBtn = wait.until(ExpectedConditions.elementToBeClickable(new MagicHealthLocators().ProductsTabBtn));
            ProductBtn.click();
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl.equals("https://magichealth.io/products/") 
                ? "Products button is clickable and redirects correctly." 
                : "Products button click failed or incorrect redirection.");
        } catch (Exception e) {
            System.out.println("Error while verifying Home button: " + e.getMessage());
        }
    }

    public void verifyandclickRequestADemoBtn() {
        try 
        {
            WebElement requestDemoBtn = wait.until(ExpectedConditions.elementToBeClickable(new MagicHealthLocators().RequestADemoBtn));
            requestDemoBtn.click();
            System.out.println("Successfully clicked on 'Request Demo' button and navigated to the Contact us form.");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while clicking on 'Request Demo' button: " + e.getMessage());
        }
    }
    
    
}
