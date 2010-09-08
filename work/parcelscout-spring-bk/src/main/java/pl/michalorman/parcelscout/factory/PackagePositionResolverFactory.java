package pl.michalorman.parcelscout.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.michalorman.parcelscout.service.PackagePositionResolver;

import java.util.Map;

public class PackagePositionResolverFactory {
    private static final Logger logger = LoggerFactory.getLogger(PackagePositionResolverFactory.class);

    private Map<String, PackagePositionResolver> resolvers;

    public PackagePositionResolver createPackagePositionResolver(String carrierId) {
        if (!resolvers.containsKey(carrierId)) {
            logger.warn("Unable to find resolver for carrierId: '{}'", carrierId);
            return null; // TODO: throw exception?
        }
        PackagePositionResolver resolver = resolvers.get(carrierId);
        logger.debug("Resolved PackagePositionResolver: {}", resolver.getClass());
        return resolver;
    }

    public void setResolvers(Map<String, PackagePositionResolver> resolvers) {
        this.resolvers = resolvers;
    }
}
