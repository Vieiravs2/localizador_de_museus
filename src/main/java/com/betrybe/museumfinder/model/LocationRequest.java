package com.betrybe.museumfinder.model;

import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;

/**
 * Util LocationRequest.
 */

public class LocationRequest {

  @NotNull
  private Double lat;

  @NotNull
  private Double lng;

  @NotNull
  private Double maxDistKm;

  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLng() {
    return lng;
  }

  public void setLng(Double lng) {
    this.lng = lng;
  }

  public Double getMaxDistKm() {
    return maxDistKm;
  }

  public void setMaxDistKm(Double maxDistKm) {
    this.maxDistKm = maxDistKm;
  }
}

