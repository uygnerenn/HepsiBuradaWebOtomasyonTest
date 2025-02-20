package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonHelper {
    private WebDriver driver;

    // Constructor
    public RadioButtonHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Belirtilen radyo butonunu seçer.
     */
    public void selectRadioButton(By locator) {
        WebElement radioButton = driver.findElement(locator);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    /**
     * Belirtilen radyo butonunu JavaScript kullanarak seçer.
     */
    public void selectRadioButtonUsingJS(By locator) {
        WebElement radioButton = driver.findElement(locator);
        if (!radioButton.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
        }
    }

    /**
     * Belirtilen radyo butonunun seçili olup olmadığını kontrol eder.
     */
    public boolean isRadioButtonSelected(By locator) {
        WebElement radioButton = driver.findElement(locator);
        return radioButton.isSelected();
    }

    /**
     * Belirtilen grup içindeki radyo butonlarından birini değerine göre seçer.
     */
    public void selectRadioButtonByValue(By groupLocator, String value) {
        List<WebElement> radioButtons = driver.findElements(groupLocator);
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals(value)) {
                if (!radioButton.isSelected()) {
                    radioButton.click();
                }
                break;
            }
        }
    }

    /**
     * Belirtilen grup içindeki seçili radyo butonunun değerini döndürür.
     */
    public String getSelectedRadioButtonValue(By groupLocator) {
        List<WebElement> radioButtons = driver.findElements(groupLocator);
        for (WebElement radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                return radioButton.getAttribute("value");
            }
        }
        return null;
    }
}
