package mst.addressbook.Tests;

import mst.addressbook.Model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoContactCreationPage();
        app.getNavigationHelper().skipQuickAddForm();
        app.getContactHelper().fillContactForm(new ContactData(
                "test_firstname",
                "test_middlename",
                "test_lastname",
                "test_nickname",
                "test_title",
                "test_company",
                "test_address",
                "test_homephone",
                "test_mobilephone",
                "test_workphone",
                "test_fax",
                "test@email.com",
                "test@email2.com",
                "test@email3.com",
                "test_homepage.ru",
                "test_address2",
                "test_homephone2",
                "test_notes"));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
