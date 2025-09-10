package com.agc.sel.baseutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class WebTableUtility {
public static List<Map<String, String>> readTableAsListOfMaps(WebDriver driver,By tableLocator){
    List<Map<String,String>> tableData = new ArrayList<>();
    WebWait wait = new WebWait(driver);

    // Wait until table is present & visible
    wait.presenceOfElement((By) tableLocator);
    WebElement tableElement = driver.findElement((By) tableLocator);
    wait.visibilityOf(tableElement);
    //Get headers
    List<WebElement> headerElements = tableElement.findElements(By.xpath(".//thead//th"));
    List<String> headers = new ArrayList<>();
    for(WebElement header : headerElements){
        headers.add(header.getText().trim());
    }
    //Get rows
    List<WebElement> rowElements = tableElement.findElements(By.xpath(".//tbody/tr"));
    for(WebElement row : rowElements){
        List<WebElement> cellElements = row.findElements(By.xpath(".//td"));
        Map<String,String> rowMap = new LinkedHashMap<>();
        for(int i =0;i<headers.size()&& i < cellElements.size();i++){
            rowMap.put(headers.get(i),cellElements.get(i).getText().trim());
        }
        tableData.add(rowMap);
    }
    return tableData;
  }

}
