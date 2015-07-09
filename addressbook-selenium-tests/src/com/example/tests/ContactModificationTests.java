package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	 @Test(dataProvider ="randomValidContactGenerator")
	  public void modifySomeContact(ContacnData contact) {
		
		
				app.getNavigationHelper().openMaimPage();
				
				
				//save old state
			    List<ContacnData> oldList = app.getContactHelper().getContacts();
			    
			    Random rnd = new Random();
			    int index = rnd.nextInt(oldList.size() -1);
	//	app.getNavigationHelper().openMaimPage();
		app.getContactHelper().initContactModification(1);
		//ContacnData contact = new ContacnData();
		//contact.fname = "new name";
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnContactPage();
	  
	  //save new state
	  		List<ContacnData> newList = app.getContactHelper().getContacts();
	  	    
	  	    //compare states	    
	  	    oldList.remove(index);
	  	    oldList.add(contact);
	  	    Collections.sort(oldList);	   
	  	    assertEquals(oldList, newList);
	  	}
	 }


