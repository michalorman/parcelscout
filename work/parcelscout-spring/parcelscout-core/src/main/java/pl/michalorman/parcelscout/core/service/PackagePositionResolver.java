package pl.michalorman.parcelscout.core.service;

import pl.michalorman.parcelscout.core.api.ResultSet;

public interface PackagePositionResolver {

    public ResultSet resolvePackagePosition(Integer packageId);

}
