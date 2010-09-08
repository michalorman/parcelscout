package pl.michalorman.parcelscout.core.service;

import pl.michalorman.parcelscout.core.model.Position;

public interface PackagePositionResolver {

    public Position resolvePackagePosition(Integer packageId);

}
