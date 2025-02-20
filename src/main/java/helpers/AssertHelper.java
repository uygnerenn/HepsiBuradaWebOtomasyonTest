package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static helpers.ActionsHelper.driver;

public class AssertHelper {

    public AssertHelper(WebDriver driver) {

    }

    /**
     * İki string değerinin eşit olup olmadığını kontrol eder.
     */
    public static void assertTextEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected, "HATA: Beklenen ve gerçek değer eşleşmiyor!");
    }

    /**
     * İki string değerinin eşit olmadığını kontrol eder.
     */
    public static void assertTextNotEquals(String actual, String expected) {
        Assert.assertNotEquals(actual, expected, "HATA: Beklenen ve gerçek değer aynı olmamalı!");
    }

    /**
     * WebElement'in görülebilir olduğunu doğrular.
     */
    public static void assertElementIsDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "HATA: Öğe görüntülenemiyor!");
    }

    /**
     * WebElement'in görünmez olduğunu doğrular.
     */
    public static void assertElementIsNotDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isDisplayed(), "HATA: Öğe görünür olmamalı!");
    }

    /**
     * WebElement'in etkin (enabled) olup olmadığını doğrular.
     */
    public static void assertElementIsEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isEnabled(), "HATA: Öğe etkin değil!");
    }

    /**
     * WebElement'in devre dışı (disabled) olduğunu doğrular.
     */
    public static void assertElementIsDisabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isEnabled(), "HATA: Öğe etkin olmamalı!");
    }

    /**
     * WebElement'in seçili (selected) olup olmadığını doğrular.
     */
    public static void assertElementIsSelected(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isSelected(), "HATA: Öğe seçili değil!");
    }

    /**
     * WebElement'in seçili olmadığını doğrular.
     */
    public static void assertElementIsNotSelected(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isSelected(), "HATA: Öğe seçili olmamalı!");
    }

    /**
     * Belirtilen metnin bir WebElement içinde bulunup bulunmadığını doğrular.
     */
    public static void assertTextContains(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.getText().contains(expectedText),
                "HATA: Öğede beklenen metin bulunamadı! Beklenen: " + expectedText);
    }

    /**
     * Boolean değerin doğru olduğunu doğrular.
     */
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Boolean değerin yanlış olduğunu doğrular.
     */
    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
}
