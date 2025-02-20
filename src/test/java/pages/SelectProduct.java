package pages;

import helpers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SelectProduct extends util.BasePage {

    private static double maxPrice = 0;


    private By CookieAccept = By.id("onetrust-accept-btn-handler");
    private By HBCheck = By.cssSelector("a[title='Hepsiburada'] > svg");
    private By elektronikMenu = By.cssSelector(".sf-MenuItems-MXhuaBP08HFYcFicDzFl > li:nth-of-type(1)");
    private By bilgisayarTabletMenu = By.cssSelector(".sf-ChildMenuItems-abUrqczV5vi1U34iDqBv .sf-ChildMenuItems-a4G0z3YJJWkQs7qKKuuj > li:nth-of-type(1) > [href='https\\:\\/\\/www\\.hepsiburada\\.com\\/bilgisayarlar-c-2147483646']:nth-of-type(1)");
    private By tabletCategory = By.cssSelector("div:nth-of-type(7) > .tree-qo9yPGSjIUwR7y9m_p3t > .tree-lvRXjYHH2ZyRHMa1KkYB");
    private By tabletClick = By.xpath("//*[@id=\"AllCategories.Child.CategoryId\"]/div/div/div/div/div/div/div/div[7]/div/div[1]/a");
    private By tableCategoryCheck = By.cssSelector("li:nth-of-type(3) > .IFt9fjR3dfhAnos3ylNg > .JGSF21F9Hi81lNaldVqp");
    private By filterApple = By.cssSelector("a[href*='apple-tablet-xc-3008012']\n");
    private By appleCheckBox = By.xpath("//*[@id=\"markalar\"]/div/div/div/div[2]/div/div[3]/div/div[2]/label");
    private By screenSizeFilter  = By.cssSelector("div[class*='heroContent'] a > span\n");
    private By allPrice = By.xpath("//li[contains(@class, 'productListContent')]//div[@data-test-id='price-current-price']");
    private By addCartBttn = By.cssSelector("[data-test-id='add-to-cart'] [kind]");
    private By goToCartBttn = By.xpath("//button[contains(text(), 'Sepete git')]\n");
    private By addCartInfoTag = By.cssSelector(".checkoutui-ProductOnBasketHeader-qaN6_kkxHFFLe_VPb4yd");
    private By cartPageCheck = By.cssSelector("h1");
    private By productPrice = By.cssSelector(".product_price_uXU6Q");
    private By cartPrice = By.xpath("//div[contains(@class, 'basket_container')]//span[contains(text(),'TL')]");
    private By test =By.xpath("./ancestor::li[contains(@class, 'productListContent')]//a");


    public SelectProduct(WebDriver driver) {
        super(driver);
    }


    public void LogoCheck (){

        AssertHelper.assertElementIsDisplayed(HBCheck);
        ButtonHelper.clickButton( CookieAccept);
        BrowserHelper.refreshPage();
        jsHelper.autoDismissPopups();

    }
    public void GoToTabletMenu(){
        jsHelper.autoDismissPopups();
        ActionsHelper.hoverOverElement(elektronikMenu);
        ButtonHelper.clickButton(bilgisayarTabletMenu);
        jsHelper.waitForPageLoad();
        try {
            jsHelper.clickElementWhenVisible(tabletClick);
        } catch (Exception e) {
            jsHelper.clickElementWhenVisible(tabletClick);
        }


    }

    public void chooseFilter() {

        jsHelper.waitForPageLoad();
        jsHelper.scrollToElement(filterApple);
        ActionsHelper.moveToElementAndClick(filterApple);
        ActionsHelper.moveToElementAndClick(screenSizeFilter);


    }

    public void highgestPrice( ){
        List<WebElement> priceElements = driver.findElements(allPrice);


        WebElement maxPriceElement = null;


        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replaceAll("[^0-9]", ""); // Sadece rakamları al
            if (!priceText.isEmpty()) {
                double price = Double.parseDouble(priceText);
                System.out.println("Fiyat: " + price + " TL");

                if (price > maxPrice) {
                    maxPrice = price;
                    maxPriceElement = priceElement;
                }
            }
        }

        System.out.println("--------------------------------");
        System.out.println(" En yüksek fiyat: " + maxPrice + " TL");

        if (maxPriceElement != null) {
            WebElement productElement = maxPriceElement.findElement(test);

            jsHelper.scrollToElement2(productElement);
            try {
                WaitHelper.waitForClick2(productElement);
                System.out.println("En pahalı ürüne başarıyla tıklandı.");
            } catch (Exception e) {
                System.out.println("Normal click başarısız, JavaScript click deneniyor...");
                jsHelper.clickElement2(productElement);
                System.out.println("JavaScript click ile en pahalı ürüne tıklandı.");
            }

        } else {
            System.out.println("Fiyat bilgisi bulunamadı.");
        }
    }

       public void AddCart (){
           Set<String> windowHandles = driver.getWindowHandles();
           List<String> windowList = new ArrayList<>(windowHandles);
           driver.switchTo().window(windowList.get(windowList.size() - 1));
           jsHelper.waitForPageLoad();
           ActionsHelper.moveToElementAndClick(addCartBttn);




       }

       public void goToCart(){
           wait.until(ExpectedConditions.visibilityOfElementLocated(addCartInfoTag));
           WaitHelper.visibilityOfElementLocated(addCartInfoTag);
           jsHelper.clickElementWhenVisible(goToCartBttn);
           jsHelper.waitForPageLoad();

           //Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed(), "❌ Sepet sayfasında değil!");
           AssertHelper.assertElementIsDisplayed(cartPageCheck);


       }

       public void priceCheck(){
           String cartPriceText = driver.findElement(productPrice).getText().replaceAll("[^0-9]", ""); // Sadece rakamları al
           double cartPrice = Double.parseDouble(cartPriceText);

           if (maxPrice == cartPrice) {
               System.out.println(" Ürünün fiyatı doğrulandı, fiyatlar eşleşiyor!");
           } else {
               System.out.println(" Hata: Ürün fiyatları eşleşmiyor! Ana sayfa fiyatı: " + maxPrice + " TL, Sepet fiyatı: " + cartPrice + " TL");
           }



       }


  }




