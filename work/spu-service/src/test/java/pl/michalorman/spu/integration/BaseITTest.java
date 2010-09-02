package pl.michalorman.spu.integration;

import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public abstract class BaseITTest {

    protected String executeGetByExtension(String extension, String packageId) throws HttpException, IOException {
        return execute(format("http://localhost:8080/spu-service/track.%s?packageId=%s", extension, packageId));
    }

    protected String executeGetByContentType(String contentType, String packageId) throws HttpException, IOException {
        return execute(format("http://localhost:8080/spu-service/track?packageId=%s", packageId), contentType);
    }

    protected String execute(String url) throws HttpException, IOException {
        return execute(url, null);
    }

    protected String execute(String url, String contentType) throws HttpException, IOException {
        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(url);
        if (contentType != null) {
            get.addRequestHeader("Content-Type", contentType);
        }
        client.executeMethod(get);
        return readResponse(get.getResponseBodyAsStream());
    }

    private String readResponse(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder builder = new StringBuilder();

        String line = null;

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        return builder.toString();
    }

}
