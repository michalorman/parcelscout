package pl.michalorman.parcelscout.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import pl.michalorman.parcelscout.model.Position;

/**
 * {@link pl.michalorman.parcelscout.service.PackagePositionResolver} that resolves package position using
 * XML response format.
 */
public class XmlSpuServicePackagePositionResolver implements PackagePositionResolver {

    public static final Logger logger = LoggerFactory.getLogger(XmlSpuServicePackagePositionResolver.class);

    private String serviceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Position resolvePackagePosition(Integer packageId) {
        logger.info("Requesting package position for packageId: '{}'", packageId);
        String result = restTemplate.getForObject(serviceUrl + "?packageId={packageId}", String.class, packageId);
        logger.info("Received from SPU service [{}]", result);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
