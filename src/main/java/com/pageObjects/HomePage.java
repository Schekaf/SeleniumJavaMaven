package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(name = "k")
    private WebElement searchBox;

    @FindBy(className = "qjixn8-0 sc-1bydi5r-0 gaMakD")
    private WebElement searchButton;

    public void enterSearchText(String searchText){
        this.searchBox.clear();
        this.searchBox.sendKeys(searchText);
    }

    public void submitSearch(){
        this.searchButton.click();
    }



}
