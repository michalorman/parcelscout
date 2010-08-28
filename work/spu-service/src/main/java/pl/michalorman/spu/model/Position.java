package pl.michalorman.spu.model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Position {

	@XStreamAsAttribute
	private Double latitude;

	@XStreamAsAttribute
	private Double longitude;

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLongitude() {
		return longitude;
	}

}
