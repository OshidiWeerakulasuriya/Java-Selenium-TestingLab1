package SeleniumTestRTU2024.SeleniumTests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LunchBrowserAndQuitTest {
//  create  reference variable for chromedriver
    ChromeDriver driver;

//  instantiate logger
    private static Logger LOGGER = LoggerFactory.getLogger(LunchBrowserAndQuitTest.class);
    @BeforeEach
    public void setup() {
//	Path to the chromedriver local version ssz
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oshid\\Documents\\RTU\\S2\\Testing and software quality\\Practical task\\1st lab\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//	Maximize the browser using maximize() method
        driver.manage().window().maximize();

    }

    @Test
    public void lunchBrowserTest() {
        driver.get("https://magento.softwaretestingboard.com/");
        LOGGER.info("lunchBrowserTest:launch browser check success");
    }

    @Test
    public void customerRegistration() throws InterruptedException {
        LOGGER.info("customerRegistration:starting test case");
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        WebElement createAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
        createAcc.click();
        Thread.sleep(3000);

        WebElement fName = driver.findElement(By.id("firstname"));
        WebElement lName = driver.findElement(By.id("lastname"));
        WebElement eMail = driver.findElement(By.id("email_address"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement cPwd = driver.findElement(By.id("password-confirmation"));

        String fname = "oshidi3";
        String lname = "weer3";
        String email = "oshiweer3@gmail.com";
        fName.sendKeys(fname);
        lName.sendKeys(lname);
        eMail.sendKeys(email);
        pwd.sendKeys("/Latvia12345");
        cPwd.sendKeys("/Latvia12345");

        Thread.sleep(3000);
        WebElement subBtn = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
        Thread.sleep(2000);
        subBtn.click();
        Thread.sleep(2000);

        // Validate fields
        validateField("firstname-error", "Please enter first name!");
        validateField("lastname-error", "Please enter last name!");
        validateField("email_address-error", "Please enter email address!");
        validateField("password-error", "Please enter password!");
        validateField("password-confirmation-error", "Please enter password confirmation!");

        Thread.sleep(5000);

        List<WebElement> regErrorElems = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
        if (!regErrorElems.isEmpty()) {
            LOGGER.info("Customer email already exists!");
            driver.quit();
            return;
        }

        WebElement actualUserEmailElem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p"));
        String actualUserName = actualUserEmailElem.getText();
        Assert.assertEquals(fname + " " + lname + "\n" + email, actualUserName);
        LOGGER.info("customerRegistration: test case passed: actual username: {} expected username: {}", actualUserName, fname + " " + lname);

        driver.quit();
    }

    private void validateField(String fieldId, String errorMessage) {
        List<WebElement> errorElems = driver.findElements(By.id(fieldId));
        if (!errorElems.isEmpty()) {
            System.out.println(errorMessage);
        }
    }

    @Test
    public void customerLogin() throws InterruptedException {
        LOGGER.info("customerLogin:starting test case");
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        WebElement logAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        logAcc.click();
        Thread.sleep(3000);

        WebElement loginemail = driver.findElement(By.id("email"));
        WebElement loginpwd = driver.findElement(By.id("pass"));

        String email = "oshidiweerakulasuriya@gmail.com";
        String password = "Qa123tesing";
        loginemail.sendKeys(email);
        loginpwd.sendKeys(password);

        WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        logBtn.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
        WebElement actualUserEmailElem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p"));
        String actualUserName = actualUserEmailElem.getText();
        String[] parts = actualUserName.split("\n");
        Assert.assertEquals(email,parts[1]);
        LOGGER.info("customerLogin:starting test case success: actual email: {} expected email: {}",email,parts[1]);
        driver.quit();
    }

    @Test
    public void addToCartMinPrice() throws InterruptedException {
        LOGGER.info("addToCartMinPrice:starting test case");
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        WebElement logAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        logAcc.click();
        Thread.sleep(3000);

        WebElement loginemail = driver.findElement(By.id("email"));
        WebElement loginpwd = driver.findElement(By.id("pass"));

        loginemail.sendKeys("oshidiweerakulasuriya@gmail.com");
        loginpwd.sendKeys("Qa123tesing");

        WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        logBtn.click();
        Thread.sleep(3000);

        WebElement whatsNew = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
        whatsNew.click();
        Thread.sleep(3000);

        WebElement hoodies = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a"));
        hoodies.click();
        Thread.sleep(3000);

        WebElement price = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[11]/div[1]"));
        price.click();
        Thread.sleep(1000);

        WebElement low = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[11]/div[2]/ol/li[1]"));
        low.click();
        Thread.sleep(3000);

        WebElement fLow = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li"));
        fLow.click();
        Thread.sleep(4000);

        WebElement sizefLow = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
        sizefLow.click();
        Thread.sleep(4000);

        WebElement colorfLow = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-53\"]"));
        colorfLow.click();
        Thread.sleep(4000);

        WebElement quantityfLow = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
        quantityfLow.clear();
        quantityfLow.sendKeys("1");
        Thread.sleep(2000);

        WebElement addfLow = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        addfLow.click();
        Thread.sleep(4000);
        LOGGER.info("addToCartMinPrice:test case success");
        driver.quit();
    }

    @Test
    public void addToCartMaxPrice() throws InterruptedException {
        LOGGER.info("addToCartMaxPrice:starting test case");
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        WebElement logAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        logAcc.click();
        Thread.sleep(3000);

        WebElement loginemail = driver.findElement(By.id("email"));
        WebElement loginpwd = driver.findElement(By.id("pass"));

        loginemail.sendKeys("oshidiweerakulasuriya@gmail.com");
        loginpwd.sendKeys("Qa123tesing");

        WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        logBtn.click();
        Thread.sleep(3000);

        WebElement whatsNew = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
        whatsNew.click();
        Thread.sleep(3000);

        WebElement hoodies = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a"));
        hoodies.click();
        Thread.sleep(3000);

        WebElement price = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[11]/div[1]"));
        price.click();
        Thread.sleep(1000);

        WebElement max = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[11]/div[2]/ol/li[4]/a"));
        max.click();
        Thread.sleep(3000);

        WebElement fLow = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li"));
        fLow.click();
        Thread.sleep(4000);

        WebElement sizefLow = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
        sizefLow.click();
        Thread.sleep(4000);

        WebElement colorfLow = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-53\"]"));
        colorfLow.click();
        Thread.sleep(4000);

        WebElement quantityfLow = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
        quantityfLow.clear();
        quantityfLow.sendKeys("1");
        Thread.sleep(2000);

        WebElement addfLow = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        addfLow.click();
        Thread.sleep(4000);
        LOGGER.info("addToCartMaxPrice:test case pass");
        driver.quit();
    }

    @Test
    public void addCartBySearchString() throws InterruptedException {
        LOGGER.info("addCartBySearchString:starting test case");
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        WebElement logAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        logAcc.click();
        Thread.sleep(3000);

        WebElement loginemail = driver.findElement(By.id("email"));
        WebElement loginpwd = driver.findElement(By.id("pass"));

        loginemail.sendKeys("oshidiweerakulasuriya@gmail.com");
        loginpwd.sendKeys("Qa123tesing");

        WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        logBtn.click();
        Thread.sleep(3000);


        WebElement search_element = driver.findElement(By.xpath("//*[@id=\"search\"]"));
        search_element.sendKeys("ariel");
        search_element.sendKeys(Keys.ENTER);

        WebElement click_element = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li/div"));
        click_element.click();

        WebElement sizefLow = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
        sizefLow.click();
        Thread.sleep(4000);

        WebElement colorfLow = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-53\"]"));
        colorfLow.click();
        Thread.sleep(4000);

        WebElement quantityfLow = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
        quantityfLow.sendKeys("1");
        Thread.sleep(2000);

        WebElement addfLow = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        addfLow.click();
        Thread.sleep(4000);
        LOGGER.info("addCartBySearchString:test case passed");
        driver.quit();
    }

    @Test
    public void AddToCartFourthTask() throws InterruptedException {
        LOGGER.info("AddToCartFourthTask:starting test case");
        int quantity = 10;

        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        WebElement logAcc = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        logAcc.click();
        Thread.sleep(3000);

        WebElement loginemail = driver.findElement(By.id("email"));
        WebElement loginpwd = driver.findElement(By.id("pass"));

        loginemail.sendKeys("oshidiweerakulasuriya@gmail.com");
        loginpwd.sendKeys("Qa123tesing");

        WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        logBtn.click();
        Thread.sleep(3000);

        WebElement whatsNew = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
        whatsNew.click();
        Thread.sleep(3000);

        WebElement hoodies = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a"));
        hoodies.click();
        Thread.sleep(3000);

        WebElement fLow = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div"));
        fLow.click();
        Thread.sleep(4000);

        WebElement sizefLow = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-166\"]"));
        sizefLow.click();
        Thread.sleep(4000);

        WebElement colorfLow = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]"));
        colorfLow.click();
        Thread.sleep(4000);

        WebElement quantityfLow = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
        quantityfLow.clear();
        quantityfLow.sendKeys(String.valueOf(quantity));
        Thread.sleep(2000);

        //before adding to cart quantiy
        int cart_quantity_before_add = 0;
        try {
            // Locate the span element containing the cart count
            WebElement cartCountElement = driver.findElement(By.xpath("//span[@class='counter-number']"));
            // Get the text content of the element, which represents the cart count
            String cartCountText = cartCountElement.getText();

            if (cartCountText != "") {
                cart_quantity_before_add = Integer.parseInt(cartCountText);
            } else {
                System.out.println("Cart count element not found. Setting cart count to 0.");
            }
            // Convert the text content to an integer

        } catch (NoSuchElementException e) {
            // If the element is not found, set cart count to 0
            System.out.println("Cart count element not found. Setting cart count to 0.");
        }

//        get price from the item card
        double item_price = 0.00;
        WebElement priceElement = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[3]/div[1]/span/span/span[2]/span"));
        String item_price_text = priceElement.getText();
        String value = item_price_text.replace("$", "");
        item_price = Double.parseDouble(value);


        WebElement click_cart_element = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
        click_cart_element.click();
        Thread.sleep(2000);
        double before_whole_price = 0.00;
        try {
            // Locate the span element containing the cart count
            WebElement before_whole_element = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[2]/div/span/span"));
            // Get the text content of the element, which represents the cart count
            String cartCountText = before_whole_element.getText();


            if (cartCountText != "") {
                cartCountText = cartCountText.replace(",", "");
                before_whole_price = Double.parseDouble(cartCountText.replace("$", ""));
            } else {
                System.out.println("element not found. Setting cart whole price count to 0.");
            }
            // Convert the text content to an integer

        } catch (NoSuchElementException e) {
            // If the element is not found, set cart count to 0
            System.out.println("element not found. Setting cart whole price count to 0.");
        }


        WebElement productTitleElement = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[1]/h1/span"));
        String productTitle = productTitleElement.getText();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"btn-minicart-close\"]")).click();
//        Add items to the cart
        WebElement addfLow = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        addfLow.click();
        Thread.sleep(4000);

        System.out.println("fist level");


        //before adding to cart quantiy
        int cart_quantity_after_add = 0;
        try {
            // Locate the span element containing the cart count
            WebElement cartCountElement = driver.findElement(By.xpath("//span[@class='counter-number']"));

            // Get the text content of the element, which represents the cart count
            String cartCountText = cartCountElement.getText();

            if (cartCountText != "") {
                // Convert the text content to an integer
                cart_quantity_after_add = Integer.parseInt(cartCountText);
            } else {
                System.out.println("Cart count element not found. Setting cart count to 0.");
            }
        } catch (NoSuchElementException e) {
            // If the element is not found, set cart count to 0
            System.out.println("Cart count element not found. Setting cart count to 0.");
        }
//        Step 3: Validate that the item count in the cart has increased

        LOGGER.info("AddToCartFourthTask: Step 3: Validate that the item count in the cart has increased ");
        Assert.assertEquals("Validate that the item count in the cart has increased", cart_quantity_before_add + quantity, cart_quantity_after_add);

        Thread.sleep(2000);

        /*Step 4: Validate that the total price is the same as the sum of the prices of the items added
         Get the price of the item added*/
        click_cart_element.click();
        double whole_price = 0.00;
        WebElement wholePriceElement = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[2]/div/span/span"));

        String wholePriceText = wholePriceElement.getText();
        wholePriceText = wholePriceText.replace(",", "");
        whole_price = Double.parseDouble(wholePriceText.replace("$", ""));

        LOGGER.info("AddToCartFourthTask: 4: Validate that the total price is the same as the sum of the prices of the items added ");
        Assert.assertEquals("Validate that the total price is the same as the sum of the prices of the items added", quantity * item_price, whole_price - before_whole_price, 0.01);


        // Step 5: Validate that the product titles match the titles of the items added
        WebElement cartProductTitleElement = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/div/strong/a"));
        String cartProductTitle = cartProductTitleElement.getText();

        LOGGER.info("AddToCartFourthTask: 5: Validate that the product titles match the titles of the items added ");
        Assert.assertEquals("Validate that the product titles match the titles of the items added", productTitle, cartProductTitle);
        // Close the browser
        driver.quit();

    }

    @AfterEach
    public void clean() {
//		driver.quit();
    }
}