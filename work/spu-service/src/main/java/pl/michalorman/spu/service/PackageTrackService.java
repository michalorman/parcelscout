package pl.michalorman.spu.service;

import org.springframework.stereotype.Service;

import pl.michalorman.spu.model.Package;
import pl.michalorman.spu.model.Position;
import pl.michalorman.spu.model.TrackResponse;

@Service
public class PackageTrackService {

	public TrackResponse getTrackInfo(Integer parcelId) {
		Position position = new Position();
		position.setLatitude(53.43);
		position.setLongitude(14.529);

		Package parcel = new Package();
		parcel.setId(1);
		parcel.setPosition(position);

		TrackResponse response = new TrackResponse();
		response.setPackage(parcel);

		return response;
	}

}
