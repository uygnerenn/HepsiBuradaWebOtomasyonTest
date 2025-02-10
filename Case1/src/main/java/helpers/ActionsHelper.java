package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelper {


    static Actions action;
    static WebDriver driver;


    public ActionsHelper(WebDriver driver) {

        this.action = new Actions(driver);
        this.driver = driver;
    }

    public static void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }

    public static void clickElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }



    public static void hoverOverElement(WebElement element) {
        action.moveToElement(element).build().perform();
    }



    public static void doubleClickElement(WebElement element) {
        action.doubleClick(element).perform();
    }


    public static void rightClickElement(WebElement element) {
        action.contextClick(element).perform();
    }


    public static void dragAndDrop(WebElement source, WebElement target) {
        action.dragAndDrop(source, target).perform();
    }

    // Mouse hareketi ile bir elementin üzerine git
    public static void moveToElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    // Mouse hareketi ile bir noktaya git ve tıkla
    public static void moveToElementAndClick(WebElement element) {
        action.moveToElement(element).click().perform();
    }

    // Mouse'u belirli bir koordinata hareket ettirme
    public static void moveByOffset(int x, int y) {
        action.moveByOffset(x, y).perform();
    }




}
