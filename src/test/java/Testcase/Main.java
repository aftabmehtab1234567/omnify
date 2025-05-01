package Testcase;

import Pageobject.*;
public class Main extends Base {
    public static void main(String args[]) throws Exception {
    	setup();
        LoginPage login = new LoginPage(driver);
        login.setUserName("Admin");
        login.setPassword("admin123");
        login.clickLogin();
        Thread.sleep(5000);
        //hover and click PIM link
        DashboardPage db = new DashboardPage(driver);
        db.hoverAndClickPIMLink();
        PIMPage pmp = new PIMPage(driver);
        for(int i =1;i<=3;i++)
        {
        pmp.clickaddempolyee();
        pmp.setfirstname("test_fname"+i);
        pmp.setlastname("test_lname"+i);
        pmp.clicksave();
        Thread.sleep(7000);
        }
        //verification
        for(int i =1;i<=3;i++)
        {
        pmp.clicklistempolyee();
        pmp.setnameList("test_fname"+i+" "+"test_lname"+i);
        pmp.clicksearchList();
        Thread.sleep(2000);
        pmp.verifynameList("test_fname"+i);
        }
        db.logout();
        driver.quit();
        ScreenRecorderUtil.stopRecord();
    }
}