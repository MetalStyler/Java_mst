package mst.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test_groupname", "test_groupheader", "test_groupfooter"));
        submitGroupGreation();
        returnToGroupPage();
    }

}
