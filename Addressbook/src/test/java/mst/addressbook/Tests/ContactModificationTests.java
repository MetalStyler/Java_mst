package mst.addressbook.Tests;

import mst.addressbook.Model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (! app.isThereElements()) {
            app.getContactHelper().createContact(new ContactData(
                    "test_firstname_for_mod",
                    "test_middlename_for_mod",
                    "test_lastname_for_mod",
                    "test_nickname_for_mod",
                    "test_title_for_mod",
                    "test_company_for_mod",
                    "test_address_for_mod",
                    "test_homephone_for_mod",
                    "test_mobilephone_for_mod",
                    "test_workphone_for_mod",
                    "test_fax_for_mod",
                    "test_for_mod@email.com",
                    "test_for_mod@email2.com",
                    "test_for_mod@email3.com",
                    "test_homepage_for_mod.ru",
                    "test_address2_for_mod",
                    "test_homephone2_for_mod",
                    "test_notes_for_mod"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "test_firstname_modified",
                "test_middlename_modified",
                "test_lastname_modified",
                "test_nickname_modified",
                "test_title_modified",
                "test_company_modified",
                "test_address_modified",
                "test_homephone_modified",
                "test_mobilephone_modified",
                "test_workphone_modified",
                "test_fax_modified",
                "test_modified@email.com",
                "test_modified@email2.com",
                "test_modified@email3.com",
                "test_homepage_modified.ru",
                "test_address2_modified",
                "test_homephone2_modified",
                "test_notes_modified"));
        app.getContactHelper().submitContactModification();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
