import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class SearchPCTest extends FunctionalTest{
    @Test
    public void search4PC(){
        driver.get("https://www.gittigidiyor.com/");
        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.clear();
        searchBox.sendKeys("Bilgisayar");

        WebElement searchSubmit = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
        searchSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        //wait.until(ExpectedConditions.elementToBeClickable(By.className("sc-1nx8ums-0 dyekHG")));

        WebElement randomItem = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li[1]/article/div[2]/a/div/div[2]/header/hgroup/h2"));
        wait.until(ExpectedConditions.elementToBeClickable(randomItem));
        randomItem.click();
        JOptionPane.showMessageDialog(null,randomItem.getText());



        //HomePage homePage = new HomePage(driver);
        //homePage.enterSearchText("bilgisayar");
        //assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",homePage.getTitle());
    }
}
