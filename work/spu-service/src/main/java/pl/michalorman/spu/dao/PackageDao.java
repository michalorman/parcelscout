package pl.michalorman.spu.dao;

import pl.michalorman.spu.model.Package;

public interface PackageDao {

    public Package findById(Integer packageId);

}
