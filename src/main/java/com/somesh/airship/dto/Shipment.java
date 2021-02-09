package com.somesh.airship.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.somesh.airship.utils.CourierCode;
import com.somesh.airship.utils.EnumAnnotation;

/**
 * @author ksomalin
 * 
 */
public class Shipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(min = 12, max = 50)
	private String tracking_number;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String origin_country_iso3;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String destination_country_iso3;

	@NotNull
	@EnumAnnotation(enumClass = CourierCode.class, ignoreCase = true)
	private String slug;

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public String getOrigin_country_iso3() {
		return origin_country_iso3;
	}

	public void setOrigin_country_iso3(String origin_country_iso3) {
		this.origin_country_iso3 = origin_country_iso3;
	}

	public String getDestination_country_iso3() {
		return destination_country_iso3;
	}

	public void setDestination_country_iso3(String destination_country_iso3) {
		this.destination_country_iso3 = destination_country_iso3;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Shipment() {
		super();
	}

	public Shipment(@NotNull String tracking_number, @NotNull String origin_country_iso3,
			@NotNull String destination_country_iso3, @NotNull String slug) {
		super();
		this.tracking_number = tracking_number;
		this.origin_country_iso3 = origin_country_iso3;
		this.destination_country_iso3 = destination_country_iso3;
		this.slug = slug;
	}

	@Override
	public String toString() {
		return "{tracking_number=" + tracking_number + ", origin_country_iso3=" + origin_country_iso3
				+ ", destination_country_iso3=" + destination_country_iso3 + ", slug=" + slug + "}";
	}

}
