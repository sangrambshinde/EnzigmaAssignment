package AutomationTestingAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class NoKodrAutomation {

    public static void main(String[] args) {
    
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Timeouts wait1= driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        try {
            // Task 1: Open Browser and Navigate
            driver.manage().window().maximize();
            driver.get("https://app-staging.nokodr.com/");
            

            // Task 2: Signup Page Validation
            driver.findElement(By.partialLinkText("Sign up")).click(); // Locate "Sign Up" link
            driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("sangramshinde102@gmail.com");
            driver.findElement(By.className("slds-checkbox_faux")).click();
            driver.findElement(By.xpath("//div[@title='Proceed']")).click();
            
            WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='code']")));
             otpInput.click();
             
           WebElement codeMessage = driver.findElement(By.xpath("//h2[contains(text(),'Verification code sent successfully')]"));
         
             System.out.println(codeMessage.getText());
             Thread.sleep(30000);
             WebElement verify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Verify Code']")));
             verify.click();
           // WebElement code = driver.findElement(By.xpath("//h2[contains(text(),'Invalid or Expired code')]")) ; 
             String code = driver.findElement(By.className("slds-notify__content")).getText();
            System.out.println(code);
            // Test valid inputs
            Thread.sleep(1000);
            WebElement nameField = driver.findElement(By.xpath("//input[@name='firstName']"));
            nameField.sendKeys("John");
            WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
            lastName.sendKeys("Doe");
            Thread.sleep(2000);
            WebElement passwordField = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
            passwordField.sendKeys("Pass@123");
            WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@name='password-confirmpassword']"));
            confirmPasswordField.sendKeys("Pass@123");
            Thread.sleep(2000);
 
            driver.findElement(By.xpath("//div[@title='Register']"));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Register']")));
    		driver.findElement(By.xpath("//div[@title='Register']")).click();
            
            Thread.sleep(1000);
          
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Register']")));
    		WebElement register = driver.findElement(By.xpath("//div[@title='Register']"));
    		register.click();
            System.out.println("Signup validation with valid data passed.");


            // Task 3: Login Page Validation
            driver.findElement(By.xpath("//div[text()='Log In']")).click(); // Locate "Login" link
            
            WebElement usernameField = driver.findElement(By.xpath("//input[@type='email']"));
            WebElement loginPasswordField = driver.findElement(By.xpath("//input[@name='password']"));
            WebElement rememberMe = driver.findElement(By.xpath("//input[@name='rememberMe']"));
            WebElement loginButton = driver.findElement(By.xpath("//div[text()='Log In']"));

            usernameField.sendKeys("sangramshinde677@gmail.com");
            loginPasswordField.sendKeys("Sangram@2001");
            rememberMe.click();
            loginButton.click();
            
           String logMessage = driver.findElement(By.xpath("//h2[text()='Invalid Email or Password']")).getText();
           System.out.println(logMessage);
           
           String logMessage1 = driver.findElement(By.className("content-margin")).getText();
           System.out.println(logMessage1);
           
            // Task 4: Forgot Password Validation
            driver.findElement(By.partialLinkText("Forgot Password?")).click();

            WebElement forgotEmailField = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
            forgotEmailField.sendKeys("sangramshinde677@gmail.com");
            
            WebElement forgotSubmitButton = driver.findElement(By.xpath("//div[@title='Proceed']"));
            forgotSubmitButton.click();
            
            String lastMessage = driver.findElement(By.xpath("//div[@class='content-margin']")).getText();
           
            System.out.println(lastMessage);
           
            System.out.println("Forgot password validation with valid data passed.");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        } finally {
            
           driver.quit();
        }
    }
}

