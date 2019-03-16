package com.haidoan.automation.utils;

import org.testng.Assert;

public class AssertionManager
{
    public static void verifyNumberEqual(int expected, int actual)
    {
            Assert.assertEquals(expected, actual);
    }

    public static void verifyTrue(boolean statement)
    {
        Assert.assertTrue(statement);
    }
}
