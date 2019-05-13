package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.controller.HomeController;

public class AppTest 
    
{
	@Test
    public void testApp()
    {
        HomeController homeController=new HomeController();
        String result=homeController.getHomeController();
        assertEquals(result,"Home Controller for Ship wreck application");
    }
}
