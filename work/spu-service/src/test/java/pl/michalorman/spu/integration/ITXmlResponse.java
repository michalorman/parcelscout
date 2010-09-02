package pl.michalorman.spu.integration;

import static java.lang.String.format;
import static junit.framework.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

public class ITXmlResponse {

    /*
     * Given HTTP GET request for *.xml should return successful response in XML format.
     */
    @Test
    public void shouldReturnXmlResponseForXmlExtension() throws HttpException, IOException {
        assertEquals(
                "<response status=\"101\"><package id=\"1\"><position latitude=\"53.43\" longitude=\"14.529\"/></package></response>",
                executeGetByExtension("xml", "1"));
        assertEquals(
                "<response status=\"101\"><package id=\"2\"><position latitude=\"50.47\" longitude=\"16.15\"/></package></response>",
                executeGetByExtension("xml", "2"));
        assertEquals(
                "<response status=\"101\"><package id=\"3\"><position latitude=\"50.53\" longitude=\"20.39\"/></package></response>",
                executeGetByExtension("xml", "3"));
        assertEquals(
                "<response status=\"101\"><package id=\"4\"><position latitude=\"52.13\" longitude=\"20.57\"/></package></response>",
                executeGetByExtension("xml", "4"));
        assertEquals(
                "<response status=\"101\"><package id=\"5\"><position latitude=\"49.57\" longitude=\"18.43\"/></package></response>",
                executeGetByExtension("xml", "5"));
    }

    /*
     * Give HTTP GET request for *.xml with not existing package identifier should return XML failure response.
     */
    @Test
    public void shouldReturnUnsuccessfulResponseForXmlExtensionAndNotExistinPackage() throws HttpException, IOException {
        assertEquals("<response status=\"201\"/>", executeGetByExtension("xml", "6"));
    }

    /*
     * Given HTTP GET request with application/xml Content-Type should return successful response in XML format.
     */
    @Test
    public void shouldReturnXmlResponseForXmlContentType() throws HttpException, IOException {
        assertEquals(
                "<response status=\"101\"><package id=\"1\"><position latitude=\"53.43\" longitude=\"14.529\"/></package></response>",
                executeGetByContentType("application/xml", "1"));
        assertEquals(
                "<response status=\"101\"><package id=\"2\"><position latitude=\"50.47\" longitude=\"16.15\"/></package></response>",
                executeGetByContentType("application/xml", "2"));
        assertEquals(
                "<response status=\"101\"><package id=\"3\"><position latitude=\"50.53\" longitude=\"20.39\"/></package></response>",
                executeGetByContentType("application/xml", "3"));
        assertEquals(
                "<response status=\"101\"><package id=\"4\"><position latitude=\"52.13\" longitude=\"20.57\"/></package></response>",
                executeGetByContentType("application/xml", "4"));
        assertEquals(
                "<response status=\"101\"><package id=\"5\"><position latitude=\"49.57\" longitude=\"18.43\"/></package></response>",
                executeGetByContentType("application/xml", "5"));
    }

    /*
     * Give HTTP GET request for *.xml with not existing package identifier should return XML failure response.
     */
    @Test
    public void shouldReturnUnsuccessfulResponseForXmlContentTypeAndNotExistinPackage() throws HttpException,
            IOException {
        assertEquals("<response status=\"201\"/>", executeGetByExtension("xml", "6"));
    }

    private String executeGetByExtension(String extension, String packageId) throws HttpException, IOException {
        return execute(format("http://localhost:8080/spu-service/track.%s?packageId=%s", extension, packageId));
    }

    private String executeGetByContentType(String contentType, String packageId) throws HttpException, IOException {
        return execute(format("http://localhost:8080/spu-service/track?packageId=%s", packageId), contentType);
    }

    private String execute(String url) throws HttpException, IOException {
        return execute(url, null);
    }

    private String execute(String url, String contentType) throws HttpException, IOException {
        HttpClient client = new HttpClient();
        GetMethod get = new GetMethod(url);
        if (contentType != null) {
            get.addRequestHeader("Content-Type", contentType);
        }
        client.executeMethod(get);
        return get.getResponseBodyAsString();
    }

}
