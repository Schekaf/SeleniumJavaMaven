import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class SearchPCTest extends FunctionalTest{
    @Test
    public void search4PC(){
        driver.get("https://www.gittigidiyor.com/");
        //HomePage homePage = new HomePage(driver);
        WebElement choociee = driver.findElements(By.linkText("Kapat")).get(0);
        choociee.click();
        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.clear();
        searchBox.sendKeys("Bilgisayar");

        WebElement searchSubmit = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
        searchSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver,20);


        WebElement navsecondPage = driver.findElements(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a")).get(0);
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath("/html/body/div[4]")).get(0)));
        navsecondPage.click();
        //driver.get(navsecondPage.getAttribute("href"));

        WebElement product = driver.findElements(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li[1]/article/div[2]/a")).get(0);
        product.click();
        //driver.get(product.getAttribute("href"));

        WebElement productPrice = driver.findElements(By.id("sp-price-lowPrice")).get(0);

        File priceFile = createFile("priceFile.txt");
        writeFile(priceFile,productPrice.getText());

        WebElement addToChart = driver.findElements(By.id("add-to-basket")).get(0);
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(addToChart)).click();



    }
}
