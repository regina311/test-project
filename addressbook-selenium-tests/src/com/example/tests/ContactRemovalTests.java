package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	 
	public void deleteSomeContact() {
		 app.getNavigationHelper().openMaimPage();
		//save old state
		List<ContacnData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() -1);
		
	   
		app.getContactHelper().deleteContact(index);
	    app.getContactHelper().returnContactPage();
	  //save new state
	  		List<ContacnData> newList = app.getContactHelper().getContacts();
	  	    //compare states
	  	    
	  	    oldList.remove(index);
	  	    Collections.sort(oldList);
	  	    Collections.sort(newList);
	  	    assertEquals(newList, oldList);
}
}
