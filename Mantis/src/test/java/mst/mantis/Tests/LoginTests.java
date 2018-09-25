package mst.mantis.Tests;

import mst.mantis.AppManager.HttpSession;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("test", "test"));
        assertTrue(session.isLoggedInAs("test"));
    }
}
