package computer;

import basetest.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class TestSuite extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //	1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        //	1.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']//a[text()=' Desktops ']"));
        //	1.3 Select Sort By position "Name: Z to A"
        //selectByvalueFromDropDown(By.id("products-orderby"),"6");
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 2);
        //selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");

        //	1.4 Verify the Product will arrange in Descending order.
        String expectedMessage = "Name: Z to A";
        //WebElement message = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        String actualMessage = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        Assert.assertEquals("Product will arrange in Descending order  Name: Z to A", expectedMessage, actualMessage);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //	2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        //	2.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='category-grid sub-category-grid']//a[text()=' Desktops ']"));
        //	2.3 Select Sort By position "Name: A to Z"
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 1);
        //	2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        //mouseHoverToElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
        //clickOnElement(By.xpath("//div[@class='item-box'][1]//button[@class='button-2 product-box-add-to-cart-button']"));
        mouseHoverAndClickToElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));

        //	2.5 Verify the Text "Build your own computer"
        String expectedMessage1 = "Build your own computer";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Text verify build your own computer", expectedMessage1, actualMessage1);

        //	2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByvalueFromDropDown(By.xpath("//select[@name='product_attribute_1']"),"1");

        //	2.7.Select "8GB [+$60.00]" using Select class.
        selectByvalueFromDropDown(By.xpath("//select[@name='product_attribute_2']"),"5");

        //	2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));

        //	2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));

        //A          2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        //	2.11 Verify the price "$1,475.00"
        String expectedMessage2 = "$1,475.00";
        String actualMessage2 = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        Assert.assertEquals("Text verify",expectedMessage2,actualMessage2);

        //	2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Text verify",expectedMessage3,actualMessage3);

        clickOnElement(By.xpath("//span[@class='close']"));

        //	2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //	2.15 Verify the message "Shopping cart"

        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text verify",expectedMessage4,actualMessage4);

        //	2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
            clearValue(By.xpath("//input[@class='qty-input']"));
            sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
            clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        //	2.17 Verify the Total"$2,950.00"
        String expectedMessage5 = "$2,950.00";
        String actualMessage5 = getTextFromElement(By.xpath("//tr[@class='order-total']//strong[text()='$2,950.00']"));
        Assert.assertEquals("Text verify",expectedMessage4,actualMessage4);

        //	2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //	2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //	2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMessage6 = "Welcome, Please Sign In!";
        String actualMessage6 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text verify",expectedMessage6,actualMessage6);

        //	2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //	2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"kavan");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"xyz@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"ABC");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"California");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"london");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"ha3 8ew");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"084743643");

        //	2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //	2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByvalueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"MasterCard");

        //2.28 Fill all the details
//        selectByIndexFromDropDown(By.xpath("//option[contains(text(),'Master card')]"),"1");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr Kavan Patel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5105105105105100");
        selectByvalueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"5");
        selectByvalueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2023");

        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"391");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedMessage7 = "Credit Card";
        String actualMessage7 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Text verify",expectedMessage7,actualMessage7);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedMessage8 = "Next Day Air";
        String actualMessage8 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("Text verify",expectedMessage8,actualMessage8);

        //	2.33 Verify Total is “$2,950.00”
        String expectedMessage9 = "$2,950.00";
        String actualMessage9 = getTextFromElement(By.xpath("//tr[@class='order-total']//strong[text()='$2,950.00']"));
        Assert.assertEquals("Text verify",expectedMessage9,actualMessage9);

        //	2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //	2.35 Verify the Text “Thank You”
        String expectedMessage10 = "Thank you";
        String actualMessage10 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text verify",expectedMessage10,actualMessage10);

        //	2.36 Verify the message “Your order has been successfully processed!”
        String expectedMessage11 = "Your order has been successfully processed!";
        String actualMessage11 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Text verify",expectedMessage11,actualMessage11);

        //	2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.37 Verify the text “Welcome to our store”
        String expectedMessage12 = "Welcome to our store";
        String actualMessage12 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Text verify",expectedMessage12,actualMessage12);


    }

    @After
    public void tearDown(){
        closeBrowser();
    }



}


