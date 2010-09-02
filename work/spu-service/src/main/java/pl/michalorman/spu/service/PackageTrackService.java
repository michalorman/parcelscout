package pl.michalorman.spu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michalorman.spu.api.TrackResponse;
import pl.michalorman.spu.dao.PackageDao;
import pl.michalorman.spu.model.Package;

@Service
public class PackageTrackService {

    private Logger logger = LoggerFactory.getLogger(PackageTrackService.class);

    @Autowired
    private PackageDao packageDao;

    public TrackResponse getTrackInfo(Integer packageId) {
        Package parcel = packageDao.findById(packageId);
        if (parcel != null) {
            return TrackResponse.successResponse(parcel);
        }
        logger.warn("Requested package with id={} not found", packageId);
        return TrackResponse.failureResponse();
    }

}
