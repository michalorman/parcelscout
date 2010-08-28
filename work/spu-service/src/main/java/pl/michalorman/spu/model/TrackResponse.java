package pl.michalorman.spu.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("response")
public class TrackResponse {

	@XStreamAsAttribute
	private Integer status = 101;

	@XStreamAlias("package")
	private Package parcel;

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setPackage(Package parcel) {
		this.parcel = parcel;
	}

	public Package getPackage() {
		return parcel;
	}

}
