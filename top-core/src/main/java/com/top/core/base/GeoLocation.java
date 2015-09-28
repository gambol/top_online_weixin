package com.top.core.base;

/**
 * Immutable geolocation coordinates
 *
 * @author Sebastian MA
 */
public class GeoLocation {

	double latitude;

	double longitude;

	public GeoLocation(double latitude, double longitude) {

		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLongitude() {

		return longitude;
	}

	public double getLatitude() {

		return latitude;
	}

}
