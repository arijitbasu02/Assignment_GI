package com.gi.sel.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionKeywords {
    public  WebDriver driver;

    public ActionKeywords() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
   }

    public void navigate(String baseURL){

        driver.get(baseURL);
    }
    public void hoverLearnCCO(){
        Actions action = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/ul/li[3]/a"));
        action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/ul/li[3]/div/div/div[2]/ul/li[1]/a/div[2]/strong"))).click().build().perform();
    }
    public void searchBox(String text){
        driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[1]/div/form/input[1]")).sendKeys(text);
    }
    public void selectcategoryDropdown(){
        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[1]/div/form/span/span[1]/span"));
        dropdown.click();
        driver.findElement(By.xpath("/html/body/div[3]/div/span/span/ul/li[5]/span")).click();
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
    public int verifyLearnCCO() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int resourceCount=driver.findElements(By.xpath("//article[@class='post-preview']")).size();
        return resourceCount;

    }
    public boolean urlCheck(String sPartialText){
        String currentUrl=driver.getCurrentUrl();
        if (currentUrl.contains(sPartialText)){
            return true;
        }
        else {
            return false;
        }
    }
    public void clearDropdown(){
        driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[1]/div/form/a/i")).click();
    }
    public boolean resetDropdown(){
        String dropText=driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[1]/div/form/span/span[1]/span")).getText();
        String placeholder=driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[1]/div/form/input[1]")).getAttribute("placeholder");
        if (dropText.contentEquals("BROWSE CATEGORIES") && placeholder.contentEquals("Search...")){
            return true;
        }
        else{
            return false;

        }
    }
    public void hoverLearnResource(){
        Actions action = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/ul/li[3]/a"));
        action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/ul/li[3]/div/div/div[2]/ul/li[2]/a/div[2]/strong"))).click().build().perform();
    }
    public void typeDropDown(){
        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/div[1]/strong"));
        dropdown.click();
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/div[1]/div/ul/li[3]/label/span")).click();
        //driver.findElement(By.xpath("/html/body/div[1]/main/div[1]")).click();
    }
    public void processDropDown(){
        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/div[2]/strong"));
        dropdown.click();
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/div[2]/div/ul/li[5]/label/span")).click();
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();

    }
    public boolean verifyResourceResult() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int resourceCount=driver.findElements(By.xpath("//div[@class='resource-post resource-item']")).size();
        int bannerCount=driver.findElements(By.xpath("//div[@class='banner-post resource-item']")).size();
        if(resourceCount==3 && bannerCount==1){
            return true;
        }
        else{
            return false;
        }
    }

    public void close(){
        driver.close();
    }


}
