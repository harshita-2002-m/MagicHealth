package utils;
import org.openqa.selenium.By;
public class MagicHealthLocators {
	
	public By HomeTabBtn = By.xpath("//body/header[2]//nav[@role='navigation']/ul[@id='menu-magic-health']//a[@href='https://magichealth.io/']");
	
	public By ExploreSolutionBtn = By.linkText("EXPLORE SOLUTIONS");
	
	public By RquestDemoArrow = By.linkText("REQUEST DEMO");
	
	public By ContactUsForm = By.cssSelector("[data-id='27fcd48'] .elementor-element-populated, [data-id='11e1d72'] .elementor-element-populated");
	
	public static By EnterName = By.xpath("/html//input[@id='field_xipbjr3']");
	
	public static By EnterCompanyName = By.xpath("/html//form[@id='form_contact3']//div[@class='frm_fields_container']/div[2]/input[@name='item_meta[49]']");
	
	public static By EnterEmail = By.xpath("/html//form[@id='form_contact3']//div[@class='frm_fields_container']/div[3]/input[@name='item_meta[10]']");
	
	public static By EnterPhone = By.xpath("/html//input[@id='field_cqpguu3']");
	
	public static By SendButton = By.xpath("/html//form[@id='form_contact3']//div[@class='frm_fields_container']/div[5]//input[@value='Send']");
	
	public static By StatusMessage = By.xpath("//div[@id='frm_form_3_container']//p[.='Your message has been submitted. Thank you!']");
	
	public By ExploreOurSolutionBtn = By.xpath("/html//div[@role='document']//section[@class='content-editor']/div[@class='elementor elementor-482']/section[2]/div/div/div/section[1]/div/div[1]/div/div[2]//a[@href='/products']");
	
	public By ProductsTabBtn = By.xpath("//body/header[2]//nav[@role='navigation']/ul[@id='menu-magic-health']//a[@href='https://magichealth.io/products/']");
	
	public By RequestADemoBtn = By.xpath("/html//div[@role='document']//section[@class='content-editor']/div[@class='elementor elementor-543']/section[1]/div[2]/div/div/div[4]//a[@href='#form']");
	
	
	
}
