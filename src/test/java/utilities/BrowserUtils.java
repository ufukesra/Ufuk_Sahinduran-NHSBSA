package utilities;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class BrowserUtils {


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void circumstance(WebElement elementQuestion, WebElement selectedOption, String question, String answer){

        Assert.assertEquals(elementQuestion.getText(),question);
        if (selectedOption.getText().toLowerCase().equals(answer.toLowerCase())){
            selectedOption.click();
        }else{
            System.out.println("Your answer doesn't exist!!");
        }
    }

}