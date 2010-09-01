package pl.michalorman.spu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michalorman.spu.api.TrackResponse;
import pl.michalorman.spu.dao.PackageDao;
import pl.michalorman.spu.model.Package;

@Service
public class PackageTrackService {

    @Autowired
    private PackageDao packageDao;

    public TrackResponse getTrackInfo(Integer packageId) {
        Package parcel = packageDao.findById(packageId);
        return TrackResponse.successResponse(parcel);
    }

}
