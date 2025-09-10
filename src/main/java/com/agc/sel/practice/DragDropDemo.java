package com.agc.sel.practice;

import com.agc.sel.baseutilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseClass {
    @Test(groups = {"NoLogin"})
    public static void drgandDrop() throws Exception{
        driver.get("file:///C:/Users/ParashuramRY/Downloads/selenium_drag_drop_practice_page.html");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("card-1"));
        WebElement target1 = driver.findElement(By.id("zone-A"));
        actions.dragAndDrop(source, target1).perform();
        Thread.sleep(2000);
        WebElement source1 = driver.findElement(By.id("card-2"));
        WebElement target2 = driver.findElement(By.id("zone-B"));

        actions.clickAndHold(source1)
                .moveToElement(target2)
                .release()
                .build()
                .perform();
        driver.switchTo().frame("demo-frame");

// Drag inside iframe
        WebElement box = driver.findElement(By.id("drag-me"));
        WebElement target = driver.findElement(By.id("target"));

        new Actions(driver).dragAndDrop(box, target).perform();

// Switch back to main page
        driver.switchTo().defaultContent();
    }
}
