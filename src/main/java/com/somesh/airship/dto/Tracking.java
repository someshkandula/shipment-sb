package com.somesh.airship.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author ksomalin
 *
 */
public class Tracking implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String created_at;
	private String updated_at;
	private String last_updated_at;
	private String tracking_number;
	private String slug;
	private boolean active;
	ArrayList<Object> android = new ArrayList<Object>();
	private String custom_fields = null;
	private String customer_name = null;
	private float delivery_time;
	private String destination_country_iso3 = null;
	private String courier_destination_country_iso3 = null;
	ArrayList<Object> emails = new ArrayList<Object>();
	private String expected_delivery = null;
	ArrayList<Object> ios = new ArrayList<Object>();
	private String note = null;
	private String order_id = null;
	private String order_id_path = null;
	private String order_date = null;
	private String origin_country_iso3 = null;
	private String shipment_package_count = null;
	private String shipment_pickup_date = null;
	private String shipment_delivery_date = null;
	private String shipment_type = null;
	private String shipment_weight = null;
	private String shipment_weight_unit = null;
	private String signed_by = null;
	ArrayList<Object> smses = new ArrayList<Object>();
	private String source;
	private String tag;
	private String subtag;
	private String subtag_message;
	private String title;
	private float tracked_count;
	private String last_mile_tracking_supported = null;
	private String language = null;
	private String unique_token;
	ArrayList<Object> checkpoints = new ArrayList<Object>();
	ArrayList<Object> subscribed_smses = new ArrayList<Object>();
	ArrayList<Object> subscribed_emails = new ArrayList<Object>();
	private boolean return_to_sender;
	private String order_promised_delivery_date = null;
	private String delivery_type = null;
	private String pickup_location = null;
	private String pickup_note = null;
	private String courier_tracking_link;
	private String first_attempted_at = null;
	private String courier_redirect_link;
	private String tracking_account_number = null;
	private String tracking_origin_country = null;
	private String tracking_destination_country = null;
	private String tracking_key = null;
	private String tracking_postal_code = null;
	private String tracking_ship_date = null;
	private String tracking_state = null;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public String getLast_updated_at() {
		return last_updated_at;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public String getSlug() {
		return slug;
	}

	public boolean getActive() {
		return active;
	}

	public String getCustom_fields() {
		return custom_fields;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public float getDelivery_time() {
		return delivery_time;
	}

	public String getDestination_country_iso3() {
		return destination_country_iso3;
	}

	public String getCourier_destination_country_iso3() {
		return courier_destination_country_iso3;
	}

	public String getExpected_delivery() {
		return expected_delivery;
	}

	public String getNote() {
		return note;
	}

	public String getOrder_id() {
		return order_id;
	}

	public String getOrder_id_path() {
		return order_id_path;
	}

	public String getOrder_date() {
		return order_date;
	}

	public String getOrigin_country_iso3() {
		return origin_country_iso3;
	}

	public String getShipment_package_count() {
		return shipment_package_count;
	}

	public String getShipment_pickup_date() {
		return shipment_pickup_date;
	}

	public String getShipment_delivery_date() {
		return shipment_delivery_date;
	}

	public String getShipment_type() {
		return shipment_type;
	}

	public String getShipment_weight() {
		return shipment_weight;
	}

	public String getShipment_weight_unit() {
		return shipment_weight_unit;
	}

	public String getSigned_by() {
		return signed_by;
	}

	public String getSource() {
		return source;
	}

	public String getTag() {
		return tag;
	}

	public String getSubtag() {
		return subtag;
	}

	public String getSubtag_message() {
		return subtag_message;
	}

	public String getTitle() {
		return title;
	}

	public float getTracked_count() {
		return tracked_count;
	}

	public String getLast_mile_tracking_supported() {
		return last_mile_tracking_supported;
	}

	public String getLanguage() {
		return language;
	}

	public String getUnique_token() {
		return unique_token;
	}

	public boolean getReturn_to_sender() {
		return return_to_sender;
	}

	public String getOrder_promised_delivery_date() {
		return order_promised_delivery_date;
	}

	public String getDelivery_type() {
		return delivery_type;
	}

	public String getPickup_location() {
		return pickup_location;
	}

	public String getPickup_note() {
		return pickup_note;
	}

	public String getCourier_tracking_link() {
		return courier_tracking_link;
	}

	public String getFirst_attempted_at() {
		return first_attempted_at;
	}

	public String getCourier_redirect_link() {
		return courier_redirect_link;
	}

	public String getTracking_account_number() {
		return tracking_account_number;
	}

	public String getTracking_origin_country() {
		return tracking_origin_country;
	}

	public String getTracking_destination_country() {
		return tracking_destination_country;
	}

	public String getTracking_key() {
		return tracking_key;
	}

	public String getTracking_postal_code() {
		return tracking_postal_code;
	}

	public String getTracking_ship_date() {
		return tracking_ship_date;
	}

	public String getTracking_state() {
		return tracking_state;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public void setLast_updated_at(String last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCustom_fields(String custom_fields) {
		this.custom_fields = custom_fields;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public void setDelivery_time(float delivery_time) {
		this.delivery_time = delivery_time;
	}

	public void setDestination_country_iso3(String destination_country_iso3) {
		this.destination_country_iso3 = destination_country_iso3;
	}

	public void setCourier_destination_country_iso3(String courier_destination_country_iso3) {
		this.courier_destination_country_iso3 = courier_destination_country_iso3;
	}

	public void setExpected_delivery(String expected_delivery) {
		this.expected_delivery = expected_delivery;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setOrder_id_path(String order_id_path) {
		this.order_id_path = order_id_path;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public void setOrigin_country_iso3(String origin_country_iso3) {
		this.origin_country_iso3 = origin_country_iso3;
	}

	public void setShipment_package_count(String shipment_package_count) {
		this.shipment_package_count = shipment_package_count;
	}

	public void setShipment_pickup_date(String shipment_pickup_date) {
		this.shipment_pickup_date = shipment_pickup_date;
	}

	public void setShipment_delivery_date(String shipment_delivery_date) {
		this.shipment_delivery_date = shipment_delivery_date;
	}

	public void setShipment_type(String shipment_type) {
		this.shipment_type = shipment_type;
	}

	public void setShipment_weight(String shipment_weight) {
		this.shipment_weight = shipment_weight;
	}

	public void setShipment_weight_unit(String shipment_weight_unit) {
		this.shipment_weight_unit = shipment_weight_unit;
	}

	public void setSigned_by(String signed_by) {
		this.signed_by = signed_by;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setSubtag(String subtag) {
		this.subtag = subtag;
	}

	public void setSubtag_message(String subtag_message) {
		this.subtag_message = subtag_message;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTracked_count(float tracked_count) {
		this.tracked_count = tracked_count;
	}

	public void setLast_mile_tracking_supported(String last_mile_tracking_supported) {
		this.last_mile_tracking_supported = last_mile_tracking_supported;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setUnique_token(String unique_token) {
		this.unique_token = unique_token;
	}

	public void setReturn_to_sender(boolean return_to_sender) {
		this.return_to_sender = return_to_sender;
	}

	public void setOrder_promised_delivery_date(String order_promised_delivery_date) {
		this.order_promised_delivery_date = order_promised_delivery_date;
	}

	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}

	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}

	public void setPickup_note(String pickup_note) {
		this.pickup_note = pickup_note;
	}

	public void setCourier_tracking_link(String courier_tracking_link) {
		this.courier_tracking_link = courier_tracking_link;
	}

	public void setFirst_attempted_at(String first_attempted_at) {
		this.first_attempted_at = first_attempted_at;
	}

	public void setCourier_redirect_link(String courier_redirect_link) {
		this.courier_redirect_link = courier_redirect_link;
	}

	public void setTracking_account_number(String tracking_account_number) {
		this.tracking_account_number = tracking_account_number;
	}

	public void setTracking_origin_country(String tracking_origin_country) {
		this.tracking_origin_country = tracking_origin_country;
	}

	public void setTracking_destination_country(String tracking_destination_country) {
		this.tracking_destination_country = tracking_destination_country;
	}

	public void setTracking_key(String tracking_key) {
		this.tracking_key = tracking_key;
	}

	public void setTracking_postal_code(String tracking_postal_code) {
		this.tracking_postal_code = tracking_postal_code;
	}

	public void setTracking_ship_date(String tracking_ship_date) {
		this.tracking_ship_date = tracking_ship_date;
	}

	public void setTracking_state(String tracking_state) {
		this.tracking_state = tracking_state;
	}
}
