package pl.michalorman.spu.service;

import static java.lang.String.format;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michalorman.spu.api.TrackResponse;
import pl.michalorman.spu.dao.PackageDao;
import pl.michalorman.spu.model.Package;

@Service
public class PackageTrackService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private PackageDao packageDao;

    public TrackResponse getTrackInfo(Integer packageId) {
        Package parcel = packageDao.findById(packageId);
        if (parcel != null) {
            return TrackResponse.successResponse(parcel);
        }
        logger.warn(format("Requested package with id=%d not found", packageId));
        return TrackResponse.failureResponse();
    }

}
