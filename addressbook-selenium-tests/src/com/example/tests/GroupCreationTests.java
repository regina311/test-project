package com.example.tests;


import java.util.Collections;

import java.util.List;


import static org.testng.Assert.assertEquals;
//import org.testng.asserts.*;


import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	

		
	
  @Test(dataProvider ="randomValidGroupgenerator")
  public void testGroupCreationValidData(GroupData group) throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getNavigationHelper().gotoGroupsPage();
  
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	
	app.getGroupHelper().initGroupCreation();
	
	
    GroupData group1 = new GroupData();
    group1.name = "sdf";
    group1.header = "header1 1";
    group1.footer = "footer 1";
	app.getGroupHelper().fillGroupForm(group1);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
  //  assertEquals(newList.size(), oldList.size()+1);
    oldList.add(group1);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getNavigationHelper().gotoGroupsPage();
	List<GroupData> oldList = app.getGroupHelper().getGroups();
	GroupData group = new GroupData();
	group.name = "";
	group.header = "";
	group.footer = "";
   
	app.getGroupHelper().initGroupCreation(); 
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //  assertEquals(newList.size(), oldList.size()+1);
      oldList.add(group);
      Collections.sort(oldList);
      assertEquals(newList, oldList);
  }


}
