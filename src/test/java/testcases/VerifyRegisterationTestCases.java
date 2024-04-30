package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.RegisterationPagecObjects;
import resources.baseClass;
import resources.commonMethods;
import resources.constant;

public class VerifyRegisterationTestCases extends baseClass {

	@Test
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {

		RegisterationPagecObjects rpo = new RegisterationPagecObjects(driver);

		rpo.clickOnMyAccount().click();
		rpo.clickOnMyRegister().click();
		rpo.enterFirstName().sendKeys(constant.firstname);
		rpo.enterlastName().sendKeys(constant.lastname);
		rpo.enteremailid().sendKeys(email);
		commonMethods.handleWait(driver, 10, rpo.entertelephoneno());
		rpo.entertelephoneno().sendKeys(constant.phone);
		rpo.enterPassword().sendKeys(constant.password);
		rpo.enterconfirmpassword().sendKeys(constant.confirmpassword);
		rpo.clickoncheckbox().click();
		rpo.clickoncontinue().click();

		commonMethods.handleAssertion(rpo.actualText().getText(), constant.expectedRegisteration);

	}

	@Test
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {

	

		RegisterationPagecObjects rpo = new RegisterationPagecObjects(driver);

		rpo.clickOnMyAccount().click();
		rpo.clickOnMyRegister().click();
		rpo.clickoncontinue().click();
		

		String fnActual = driver
				.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
		String fnExpected = "First Name must be between 1 and 32 characters!";

		String lnActual = driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']"))
				.getText();
		String lnExpected = "Last Name must be between 1 and 32 characters!";

		commonMethods.handleAssertion(fnActual, fnExpected );
		commonMethods.handleAssertion(lnActual, lnExpected );
	

	}

}
