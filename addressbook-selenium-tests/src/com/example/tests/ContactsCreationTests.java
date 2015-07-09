package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;


public class ContactsCreationTests extends TestBase {

  @Test(dataProvider ="randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContacnData contact ) throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	List<ContacnData> oldList1 = app.getContactHelper().getContacts();
	
	ContacnData contact1 = new ContacnData();
	contact1.fname = "Regina";
	contact1.lname = "gizatullina";
	contact1.address1 = "Address 1";
	contact1.hnumber = "123";
	contact1.mnumber = "321";
	contact1.wnumber = "456";
	contact1.mail1 = "email1@mail.ru";
	contact1.mail2 = "email2@mail.ru";
	contact1.year = "1990";
	contact1.address2 = "Address 2";
	contact1.phonenumber = "987654321";
	app.getContactHelper().fillContactForm(contact1);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
   
    List<ContacnData> newList = app.getContactHelper().getContacts();
    
    //  assertEquals(newList.size(), oldList.size()+1);
      oldList1.add(contact1);
      Collections.sort(oldList1);
      //Collections.sort(oldList1);
      assertEquals(newList, oldList1);
  }
  
	
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	app.getContactHelper().fillContactForm(new ContacnData("", "", "", "", "", "", "", "", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
  }
  


}