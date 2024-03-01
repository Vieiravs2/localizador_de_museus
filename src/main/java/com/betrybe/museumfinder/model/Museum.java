package com.betrybe.museumfinder.model;

/**
 * Representa uma entidade de Museu.
 */
public class Museum {
  private Long id;
  private String name;
  private String description;
  private String address;
  private String collectionType;
  private String subject;
  private String url;
  private Coordinate coordinate;
  private Long legacyId;

  /**
   * Getters.
   */
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getAddress() {
    return address;
  }

  public String getCollectionType() {
    return collectionType;
  }

  public String getSubject() {
    return subject;
  }

  public String getUrl() {
    return url;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public Long getLegacyId() {
    return legacyId;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Setters.
   */

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }


  public void setLegacyId(Long legacyId) {
    this.legacyId = legacyId;
  }
}
