package pages;

import static org.junit.Assert.*;

import cucumber.api.java.hu.Ha;
import cucumber.api.java.it.E;
import cucumber.api.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.DayOfWeek;
import java.util.*;


public class Wales {

    WebDriver driver = Driver.get();

    public Wales(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[text()=\"I'm OK with analytics cookies\"]")
    public WebElement cookies;

    @FindBy(xpath = "//*[@class=\"heading-group\"]/h1")
    public WebElement pageTitleForCheck;

    @FindBy(id = "label-wales")
    public WebElement walesRadioBtn;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(id = "question-heading")
    public WebElement questionHeading;

    @FindBy(css = "[id='label-day']")
    public WebElement dayText;

    @FindBy(css = "[id='label-day']")
    public WebElement monthText;

    @FindBy(css = "[id='label-day']")
    public WebElement yearText;

    @FindBy(css = "[name='dateOfBirth.day']")
    public WebElement dayInput;

    @FindBy(css = "[name='dateOfBirth.month']")
    public WebElement monthInput;

    @FindBy(css = "[name='dateOfBirth.year']")
    public WebElement yearInput;

    @FindBy(css="[id='label-yes']")
    public WebElement yesButton;

    @FindBy(css="[id='label-no']")
    public WebElement noButton;

    @FindBy(xpath = "//*[@id=\"paidUniversalCredit_fieldset\"]/label[1]")
    public WebElement paidUniversalCrYes;

    @FindBy(xpath = "//*[@class=\"done-panel\"]/h1")
    public WebElement donePanel;

    @FindBy(xpath = "//*[@class=\"error-summary\"]/h2")
    public WebElement errorTextElement;

    @FindBy(xpath = "//*[@class=\"error-summary\"]/ul/li/a/span")
    public WebElement errorTypeElement;





    public void verifyLandingPageandClickStart(){
        String expectedText= "Check what help you could get to pay for NHS costs";
       assertEquals(expectedText,pageTitleForCheck.getText());
       nextButton.click();
    //BrowserUtils.waitFor(1);
    }

    public void selectWalesInCountries(String wales){
        cookies.click();
    //BrowserUtils.waitFor(1);
        assertEquals(wales,walesRadioBtn.getText());
        walesRadioBtn.click();
    //BrowserUtils.waitFor(1);
        nextButton.click();
    }

    public void inputDateOfBirth(Map<String, String> circumstances){

        List<String> keys= new ArrayList<>();
        List<String> values= new ArrayList<>();
        for (String key:circumstances.keySet()) {
            keys.add(key);
        }

        for (String value:circumstances.values()) {
            values.add(value);
        }


        //System.out.println("Date :"+values.get(values.size()-1));
        String[] date = values.get(0).split("/");
        String day=date[0];
        String month=date[1];
        String year = date[2];
       // System.out.println(day+"\n"+month+"\n"+year);


        //What is your birthday?
        dayInput.sendKeys(day);
        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
    //BrowserUtils.waitFor(1);
        nextButton.click();

        //Do you live with a partner?
        BrowserUtils.circumstance(questionHeading,yesButton,keys.get(1),values.get(1));
    //BrowserUtils.waitFor(1);
        nextButton.click();

        //Do you or your partner claim any benefits or tax credits?
        BrowserUtils.circumstance(questionHeading,yesButton,keys.get(2),values.get(2));
    //BrowserUtils.waitFor(1);
        nextButton.click();

        //Do you or your partner get paid Universal Credit?

        BrowserUtils.circumstance(questionHeading,paidUniversalCrYes,keys.get(3),values.get(3));
    //BrowserUtils.waitFor(1);
        nextButton.click();

        //Does your joint Universal Credit include a payment for a child or young person who lives with you,
        // or a disability or health condition that makes it hard to work?
        BrowserUtils.circumstance(questionHeading,yesButton,keys.get(4),values.get(4));
    //BrowserUtils.waitFor(1);
        nextButton.click();

        //Did you and your partner have a combined take-home pay of £935 or less in your last Universal Credit period?
        BrowserUtils.circumstance(questionHeading,yesButton,keys.get(5),values.get(5));
    //BrowserUtils.waitFor(1);
        nextButton.click();
    }


    public void verifyCheckCompletedAndPrintResult(){
        String expectedText= "Done";
        assertEquals(expectedText,donePanel.getText());

        WebElement reasonOfResultElement = driver.findElement(By.id("result-reason"));
        System.out.println(" Reason of result: "+reasonOfResultElement.getText().toUpperCase());

    }



    public void clickNextButtonwithoutSelectingCountry(){
        nextButton.click();
    }

    public void verifyErrorMessage(String errorText, String errorType){
        String expectedText= errorText;
        String actualText = errorTextElement.getText();
        assertEquals("Error Summary Message Assertion", expectedText,actualText);


        String expectedType= errorType;
        String actualType= errorTypeElement.getText();
        assertEquals("ErrorType Assertion ", expectedType,actualType);



    }

}

