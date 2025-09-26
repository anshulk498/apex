package devadmin;

import org.testng.annotations.Test;

import generic_utility_test.BaseClass;
import pom.CommonLocator;
import pom.TYK;



public class CreateTYK extends BaseClass {

	
	
	@Test
	public void createTYK() throws Throwable {
		
		CommonLocator cm=new CommonLocator(driver);
		cm.getClickTyk();
		TYK tyk=new TYK(driver);
		tyk.clickOnAddTest(driver);
		tyk.createTyk_ByAudio_Spantanous(driver, "English", "Spontaneous", "this is english", "1", "20","1","None","None", "4", "1", "1", "1");
		
	}
}
