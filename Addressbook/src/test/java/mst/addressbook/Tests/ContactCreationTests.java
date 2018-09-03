package mst.addressbook.Tests;

import mst.addressbook.Model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactPage();
//        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoContactCreationPage();
        app.getNavigationHelper().skipContactAddressForm();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_middlename", "test_lastname",
                "test_nickname", "test_title", "test_company", "test_address", "test_homephone", "test_mobilephone",
                "test_workphone", "test_fax", "test_email", "test_email2", "test_email3", "test_homepage",
                "test_address2", "test_homephone2", "test_notes"));
        app.getContactHelper().submitContactCreation();
//        int after = app.getContactHelper().getContactCount();
//        Assert.assertEquals(after, before + 1);

    }

}
