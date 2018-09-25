package mst.mantis.AppManager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {
    private CloseableHttpClient httpclient;
    private ApplicationManager app;

    public HttpSession(ApplicationManager app) {
        this.app = app;
        httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public boolean login(String username, String password) throws IOException {
        HttpPost post_login = new HttpPost(app.getProperty("web.baseUrl") + "/login.php");
        List<NameValuePair> params_login = new ArrayList<>();
        params_login.add(new BasicNameValuePair("username", username));
//        params.add(new BasicNameValuePair("password", password));
//        params.add(new BasicNameValuePair("secure_session", "on"));
        params_login.add(new BasicNameValuePair("return", "index.php"));
        post_login.setEntity(new UrlEncodedFormEntity(params_login));
        CloseableHttpResponse response_login = httpclient.execute(post_login);

        HttpPost post_pass = new HttpPost(app.getProperty("web.baseUrl") + "/login.php");
        List<NameValuePair> params_pass = new ArrayList<>();
        params_pass.add(new BasicNameValuePair("username", username));
        params_pass.add(new BasicNameValuePair("password", password));
        params_pass.add(new BasicNameValuePair("return", "index.php"));
        post_pass.setEntity(new UrlEncodedFormEntity(params_pass));
        CloseableHttpResponse response_pass = httpclient.execute(post_pass);

        String body = getTextFrom(response_pass);
        System.out.println(post_pass);
//        System.out.println(body);
        return body.contains(String.format("<a href=\"/mantisbt-2.17.0/account_page.php\">%s</a>", username));
    }

    private String getTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    public Boolean isLoggedInAs(String username) throws IOException {
        HttpGet get = new HttpGet(app.getProperty("web.baseUrl") + "/index.php");
        CloseableHttpResponse response = httpclient.execute(get);
        String body = getTextFrom(response);
        return body.contains(String.format("<a href=\"/mantisbt-2.17.0/account_page.php\">%s</a>", username));
    }
}
