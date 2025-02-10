package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupHandler {
    private static WebDriver driver;

    public PopupHandler(WebDriver driver) {
        this.driver = driver;
    }

    // Pop-up var mı kontrol et
    public static boolean isPopupPresent() {
        try {
            WebElement popup = driver.findElement(By.cssSelector("div[role='dialog']")); // Pop-up'ı belirten CSS seçici
            return popup.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Pop-up bulunamadı
        }
    }

    // Pop-up'ı kapat
    public static void closePopup() {
        if (isPopupPresent()) {
            WebElement closeButton = driver.findElement(By.cssSelector("button[aria-label='Kapat']")); // Kapatma butonu
            closeButton.click();
            System.out.println("Pop-up kapatıldı.");
        }
    }
}
