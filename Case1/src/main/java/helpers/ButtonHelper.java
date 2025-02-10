package helpers;

import org.openqa.selenium.*;

public class ButtonHelper {
    private static WebDriver driver;

    // Constructor
    public ButtonHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Belirtilen butona tıklar.
     */
    public static void clickButton(WebElement button) {
        button.click();
    }

    /**
     * Belirtilen butonun etkin (enabled) olup olmadığını kontrol eder.
     */
    public static boolean isButtonEnabled(WebElement button) {
        return button.isEnabled();
    }

    /**
     * Belirtilen butonun görünür olup olmadığını kontrol eder.
     */
    public static boolean isButtonDisplayed(WebElement button) {
        return button.isDisplayed();
    }

    /**
     * Belirtilen butona JavaScript kullanarak tıklama yapar.
     */
    public static void clickButtonUsingJS(WebElement button) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);
    }

    /**
     * Belirtilen butonun metnini döndürür.
     */
    public static String getButtonText(WebElement button) {
        return button.getText();
    }

    public static void safeClick(By locator) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Element kayboldu, tekrar aranıyor... " + (i + 1));
            }
        }
        throw new RuntimeException("Element bulunamadı: " + locator);
    }
}
