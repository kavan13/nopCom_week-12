package utility;

import basetest.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    // this method will click on element
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }

    // this method get textfrom element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // this method send text
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }

    public void selectByvalueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);

    }

    public void selectByIndexFromDropDown(By by, int value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(value);
    }


    public WebElement mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(by);
        actions.moveToElement(target).perform();
        return target;
    }
    public WebElement mouseHoverAndClickToElement(By by){
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(by);
        actions.moveToElement(target).click().perform();
        return target;
    }

    public void clearValue(By by){
        driver.findElement(by).clear();
    }


    public void selectByRightClik(By by,String text) {
        Actions action = new Actions(driver);
        WebElement button = driver.findElement(by);
        action.contextClick().build().perform();
    }
    public void selectAcceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void selectDismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void selectGetTextFromAlert(){
        Alert alert = driver.switchTo().alert();
        alert.getText();
    }

    public String getUrl(){
        String actualUrl = driver.getCurrentUrl();
        return actualUrl;
    }
}