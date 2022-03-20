package com.example.demo.pages;

import com.example.demo.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SchedulesPage {

    private WebElement studentsButton = BrowserUtils.getDriver().findElement(By.xpath("//a[contains(@href,'stud.php')]"));

    public void goToStudentsPage() {
        BrowserUtils.executeScript("arguments[0].click();", studentsButton);
    }
}
