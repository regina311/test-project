package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContacnData;
import com.example.tests.GroupData;


public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoContactsPage() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContacnData contact) {
		type(By.name("firstname"), contact.fname);
		type(By.name("lastname"), contact.lname);
		type(By.name("address"), contact.address1);
		type(By.name("home"), contact.hnumber);
		type(By.name("mobile"), contact.mnumber);
		type(By.name("work"), contact.wnumber);
		type(By.name("email"), contact.mail1);
		type(By.name("email2"), contact.mail2);
		type(By.name("byear"), contact.year);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phonenumber);
	    
	}

	public void returnContactPage() {
		click(By.linkText("home page"));
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("(//input[@name='update'])[2]"));
		
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])["+ index +"]"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
	}
	

	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		
	}

	public List<ContacnData> getContacts() {
	
		List<ContacnData> contacts = new ArrayList<ContacnData>();  
		 		List<WebElement> contactRows = driver.findElements(By.xpath("//tr[@name='entry']"));  
				for (WebElement contactRow : contactRows) {  
					ContacnData contact = new ContacnData();  
		 				contact.fname = contactRow.findElement(By.xpath("./td[3]")).getText();  
		 				contact.lname = contactRow.findElement(By.xpath("./td[2]")).getText();  
		 				contact.mail1 = contactRow.findElement(By.xpath("./td[4]")).getText();  
		 				contact.hnumber = contactRow.findElement(By.xpath("./td[5]")).getText();  
		 				contacts.add(contact);  
		 			}  
		 			return contacts;  
		 }  

	
}
