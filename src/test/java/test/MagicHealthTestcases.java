package test;
import helper.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MagicHealthMethods;
import utils.MagicHealthLocators;

public class MagicHealthTestcases extends BaseTest {

    private MagicHealthMethods methods;
    private static final String EXPECTED_TITLE_HOME = "Magic Health – Magic Health";
    private static final String EXPECTED_TITLE_PRODUCT = "Products – Magic Health";
    
    @BeforeMethod
    public void setUp() {
        methods = new MagicHealthMethods(driver);
    }

    @Test(priority = 1)
    public void TC_001_Verifying_Click_on_Home_Button_on_Landing_Page_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyHomeBtnClickable();
    }
    
    @Test(priority = 2)
    public void TC_002_Verifying_Click_on_Explore_Solutions_Button_on_Home_Page_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyandclickExploreSolutionBtn();
        methods.validateTitle(EXPECTED_TITLE_PRODUCT);
    }
    
    @Test(priority=3)
    public void TC_003_Verifying_Navigation_to_the_Request_Demo_In_HomePage_USER() {
    	methods.validateTitle(EXPECTED_TITLE_HOME);
    	methods.verifyandclickRequestDemoBtn();
    	methods.verifyContactUsForm();
    }
    
    @Test(priority = 4)
    public void TC_004_Verifying_Navigation_to_the_Request_Demo_at_ContactUs_Form_In_HomePage_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyandclickRequestDemoBtn();
        methods.verifyContactUsForm();
        methods.enterText(MagicHealthLocators.EnterName, "Harshita");
        methods.enterText(MagicHealthLocators.EnterEmail, "xyz@gmail.com");
        methods.enterText(MagicHealthLocators.EnterCompanyName, "Pursuit");
        methods.enterText(MagicHealthLocators.EnterPhone, "1234567891");
        methods.ClickSendButton();
        methods.VerifyStatusMessage();
    }
    
    @Test(priority = 5)
    public void TC_005_Verifying_Explore_Our_Solutions_Button_Functionality_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyandclickExploreOurSolutionBtn();
        methods.validateTitle(EXPECTED_TITLE_PRODUCT);
    }
    
    @Test(priority = 6)
    public void TC_006_Verifying_Click_on_Product_Button_on_Landing_Page_Functionality_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyProductsBtnClickable();
        methods.validateTitle(EXPECTED_TITLE_PRODUCT);
    }
    
    @Test(priority = 7)
    public void TC_007_Verifying_Navigation_to_the_Request_Demo_In_Products_Page_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyProductsBtnClickable();
        methods.validateTitle(EXPECTED_TITLE_PRODUCT);
        methods.verifyandclickRequestADemoBtn();
    	methods.verifyContactUsForm();
        
    }
    
    @Test(priority = 8)
    public void TC_008_Verifying_Navigation_to_the_Request_Demo_at_ContactUs_Form_In_Products_Page_USER() {
        methods.validateTitle(EXPECTED_TITLE_HOME);
        methods.verifyProductsBtnClickable();
        methods.validateTitle(EXPECTED_TITLE_PRODUCT);
        methods.verifyandclickRequestADemoBtn();
    	methods.verifyContactUsForm();
    	methods.enterText(MagicHealthLocators.EnterName, "Harshita");
        methods.enterText(MagicHealthLocators.EnterEmail, "xyz@gmail.com");
        methods.enterText(MagicHealthLocators.EnterCompanyName, "Pursuit");
        methods.enterText(MagicHealthLocators.EnterPhone, "1234567891");
        methods.ClickSendButton();
        methods.VerifyStatusMessage();
        
    }

}
