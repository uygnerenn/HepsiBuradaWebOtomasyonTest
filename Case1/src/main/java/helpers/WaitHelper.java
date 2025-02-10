package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

public class WaitHelper {
    private WebDriver driver;
    private static final WebDriverWait wait = DriverFactory.getWait();

    // Constructor
    public WaitHelper(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Belirtilen öğeyi görünür olana kadar bekler.
     */
    public static WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static String waitForElementToBeVisibleText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    /**
     * Belirtilen öğeyi tıklanabilir olana kadar bekler.
     */
    public static WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * Belirtilen öğeyi tıklanabilir olana kadar bekler.
     */
    public static  WebElement waitForClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    /**
     * Belirtilen öğenin DOM'da mevcut olmasını bekler.
     */
    public static WebElement waitForElementToBePresent(WebElement element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    /**
     * Sayfanın tamamen yüklenmesini bekler.
     */
    public static void waitForPageToLoad() {
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Belirtilen öğenin metninin değişmesini bekler.
     */
    public static boolean waitForTextToBePresentInElement(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Belirtilen öğenin görünmez olmasını bekler.
     */
    public static boolean waitForElementToBeInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void closePopupIfExists(By popupLocator, By closeButtonLocator) {
        try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
            WebElement closeButton = popup.findElement(closeButtonLocator);
            closeButton.click();
            System.out.println("Pop-up başarıyla kapatıldı.");
        } catch (Exception e) {
            System.out.println("Pop-up bulunamadı veya zaten kapalı.");
        }
    }
    public static void  visibilityOfElementLocated(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public static void  visibilityOfElementLocatedtext(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

    }



}
