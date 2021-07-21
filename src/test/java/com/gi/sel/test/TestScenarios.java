package com.gi.sel.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

public class TestScenarios {
    String baseUrl="https://www.ganintegrity.com/";
    @Test
    public void Test1_VerifyLearnCCO(){
        ActionKeywords a=new ActionKeywords();
        boolean checkString=false;
        a.navigate(baseUrl);
        a.hoverLearnCCO();
        a.searchBox("UK Bribery Act Enforcement");
        a.selectcategoryDropdown();
        checkString=a.urlCheck("blog");
        int count=a.verifyLearnCCO();
        Assert.assertTrue(checkString, "Verifying the presence of string blog in the url");
        Assert.assertEquals(count, 6,"Verifying the number of result displayed after filtering");
        a.close();
    }
    @Test
    public void Test2_VerifyReset(){
        ActionKeywords a=new ActionKeywords();
        boolean checkReset=false;
        a.navigate(baseUrl);
        a.hoverLearnCCO();
        a.searchBox("UK Bribery Act Enforcement");
        a.selectcategoryDropdown();
        a.clearDropdown();
        checkReset=a.resetDropdown();
        Assert.assertTrue(checkReset, "Verifying that reset of dropdown fields resets the dropdown and searchbar");
        a.close();
    }
    @Test
    public void Test3_VerifyLearnResource() {
        ActionKeywords a=new ActionKeywords();
        boolean checkResource=false,checkUrl=false;
        a.navigate(baseUrl);
        a.hoverLearnResource();
        a.typeDropDown();
        a.processDropDown();
        checkResource=a.verifyResourceResult();
        checkUrl=a.urlCheck("resources");
        Assert.assertTrue(checkResource, "Verifying the number of results and banner present after filtering");
        Assert.assertTrue(checkUrl, "Verifying the presence of string resources in the url");
        a.close();
    }


}
