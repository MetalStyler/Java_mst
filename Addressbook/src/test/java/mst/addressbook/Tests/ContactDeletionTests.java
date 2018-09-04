package mst.addressbook.Tests;

import mst.addressbook.Model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoContactPage();
        if (! app.isThereElements()) {
            app.getContactHelper().createContact(new ContactData(
                    "test_firstname_for_del",
                    "test_middlename_for_del",
                    "test_lastname_for_del",
                    "test_nickname_for_del",
                    "test_title_for_del",
                    "test_company_for_del",
                    "test_address_for_del",
                    "test_homephone_for_del",
                    "test_mobilephone_for_del",
                    "test_workphone_for_del",
                    "test_fax_for_del",
                    "test_for_del@email.com",
                    "test_for_del@email2.com",
                    "test_for_del@email3.com",
                    "test_homepage_for_del.ru",
                    "test_address2_for_del",
                    "test_homephone2_for_del",
                    "test_notes_for_del "));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.confirmAlert();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }
}