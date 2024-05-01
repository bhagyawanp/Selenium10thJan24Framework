package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPagecObjects;
import pageObjectModel.RegisterationPagecObjects;
import resources.baseClass;
import resources.commonMethods;
import resources.constant;

public class VeriyLoginTestCases extends baseClass {
//mahesh line 1
//mahesh line 2
	@Test
	public void verifyLoginithValidData() throws IOException, InterruptedException {

		RegisterationPagecObjects rpo = new RegisterationPagecObjects(driver);
		rpo.clickOnMyAccount().click();

		LoginPagecObjects lpo = new LoginPagecObjects(driver);

		lpo.clickOnLogin().click();

		lpo.enterEmail().sendKeys(email);
		commonMethods.handleWait(driver, 12,lpo.enterPassword());
		lpo.enterPassword().sendKeys(constant.password);
		lpo.clickOnSubmitButton().click();
		
		 commonMethods.handleAssertion(driver.findElement(By.xpath("//h2[text()='My Account']")).getText(), "My Account");
	}

	@Test
	public void verifyLoginithInValidData() throws IOException, InterruptedException {


		RegisterationPagecObjects rpo = new RegisterationPagecObjects(driver);
		rpo.clickOnMyAccount().click();

		LoginPagecObjects lpo = new LoginPagecObjects(driver);

		lpo.clickOnLogin().click();

		lpo.enterEmail().sendKeys(email);
		Thread.sleep(2000);
		lpo.enterPassword().sendKeys(constant.invalidPassword);
		lpo.clickOnSubmitButton().click();
	

		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		commonMethods.handleAssertion(actual, expected);

	}

}
