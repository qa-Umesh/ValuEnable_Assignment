package com.valuenable.test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.valuenable.constants.PartnerType;

public class ContactUsTest extends BaseTest {

	@Test
	public void ContactFormPositiveTest() {

		assertEquals(
				
				homePage.clickOnGetInToch()
				.enterFirstName("umesh")
				.enterLastName("Kute")
				.enterEmail("umeshkute453@gmail.com")
				.selectPartnerType(PartnerType.Lender)
				.selectSolution("Managed Services")
				.sendMessage("This is only for Assignment purpose")
				.clickOnTalkToOurTeamButton()
				.getConfirmationMessage(),
				
				"Thank you! Your submission has been received!");
	}
	
	@Test
	public void ContactFormNagativeTest() {

	    assertEquals(

	            homePage.clickOnGetInToch()
	            .enterFirstName("umesh")
	            .enterLastName("Kute")
	            .enterEmail("invalidemail@@")
	            .selectSolution("Managed Services")
	            .sendMessage("Negative test validation")
	            .clickOnTalkToOurTeamButton()
	            .getEmailValidationMessage(),

	            "A part following '@' should not contain the symbol '@'."

	    );
	}

}
