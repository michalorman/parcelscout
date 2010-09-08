package pl.michalorman.parcelscout.service;

import pl.michalorman.parcelscout.model.Position;

public interface PackagePositionResolver {

    public Position resolvePackagePosition(Integer packageId);

}
