package homepage;

import basetest.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    public void selectMenu(String menu) {
        if (menu == "Computers") {
            clickOnElement(By.linkText("Computers"));
            String expectedText1 = "Computers";
            String actualText1 = getTextFromElement(By.xpath("//h1[text()='Computers']"));
            Assert.assertEquals("Text verify", expectedText1, actualText1);
            System.out.println(actualText1);
        } else if (menu == "Electronics") {
            clickOnElement(By.linkText("Electronics"));
            String expectedText2 = "Electronics";
            String actualText2 = getTextFromElement(By.xpath("//h1[text()='Electronics']"));
            Assert.assertEquals("Text verify", expectedText2, actualText2);
            System.out.println(actualText2);
        } else if (menu == "Apparel") {
            clickOnElement(By.linkText("Apparel"));
            String expectedText3 = "Apparel";
            String actualText3 = getTextFromElement(By.xpath("//h1[text()='Apparel']"));
            Assert.assertEquals("Text verify", expectedText3, actualText3);
            System.out.println(actualText3);
        } else if (menu == "Digital downloads") {
            clickOnElement(By.linkText("Digital downloads"));
            String expectedText4 = "Digital downloads";
            String actualText4 = getTextFromElement(By.xpath("//h1[text()='Digital downloads']"));
            Assert.assertEquals("Text verify", expectedText4, actualText4);
            System.out.println(actualText4);
        } else if (menu == "Books") {
            clickOnElement(By.linkText("Books"));
            String expectedText5 = "Books";
            String actualText5 = getTextFromElement(By.xpath("//h1[text()='Books']"));
            Assert.assertEquals("Text verify", expectedText5, actualText5);
            System.out.println(actualText5);
        } else if (menu == "Jewelry") {
            clickOnElement(By.linkText("Jewelry"));
            String expectedText6 = "Jewelry";
            String actualText6 = getTextFromElement(By.xpath("//h1[text()='Jewelry']"));
            Assert.assertEquals("Text verify", expectedText6, actualText6);
            System.out.println(actualText6);
        } else if (menu == "Gift Cards") {
            clickOnElement(By.linkText("Gift Cards"));
            String expectedText7 = "Gift Cards";
            String actualText7 = getTextFromElement(By.xpath("//h1[text()='Gift Cards']"));
            Assert.assertEquals("Text verify", expectedText7, actualText7);
            System.out.println(actualText7);
        }
    }

    @Test
    public void verifyPageNavigation() {
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']"));

        for (WebElement name : menuItems) {
            selectMenu("Computers");
            selectMenu("Electronics");
            selectMenu("Apparel");
            selectMenu("Digital downloads");
            selectMenu("Books");
            selectMenu("Jewelry");
            selectMenu("Gift Cards");
        }

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}