package pl.michalorman.parcelscout.integration.spu.service;

import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import pl.michalorman.parcelscout.core.api.ResultSet;
import pl.michalorman.parcelscout.core.service.PackagePositionResolver;
import pl.michalorman.parcelscout.integration.spu.model.Response;

/**
 * {@link pl.michalorman.parcelscout.core.service.PackagePositionResolver} that resolves package position using
 * XML response format.
 */
public class XmlSpuServicePackagePositionResolver implements PackagePositionResolver {

    public static final Logger logger = LoggerFactory.getLogger(XmlSpuServicePackagePositionResolver.class);

    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResultSet resolvePackagePosition(Integer packageId) {
        logger.info("Requesting package position for packageId: '{}'", packageId);
        String result = restTemplate.getForObject(serviceUrl + "?packageId={packageId}", String.class, packageId);
        logger.info("Received from SPU service [{}]", result);

        XStream xstream = new XStream();
        xstream.processAnnotations(Response.class);
        Response response = (Response) xstream.fromXML(result);

        if (!response.isSuccessful()) {
            logger.warn("Failed to resolve position for packageId='{}'", packageId);
            return ResultSet.createFailureResultSet();
        }

        logger.debug("Parsed response: status={}, packageId={}, latitude={}, longitude={}",
                new Object[] { response.getStatus(), response.getPackageId(), response.getPackageLatitude(), response.getPackageLongitude() });

        return ResultSet.createSuccessfulResultSet(response.getPackageId(), response.getPackageLatitude(), response.getPackageLongitude());
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
