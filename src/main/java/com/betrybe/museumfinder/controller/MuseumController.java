package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MuseumController.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.service = museumService;
  }

  /**
   * Get CLosest Museum.
   */

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(
      @RequestParam(name = "lat") double lat,
      @RequestParam(name = "lng") double lng,
      @RequestParam(name = "max_dist_km") double distance
  ) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum getMuseum = this.service.getClosestMuseum(coordinate, distance);
    MuseumDto convertedMuseum = ModelDtoConverter.modelToDto(getMuseum);
    return ResponseEntity.status(HttpStatus.OK).body(convertedMuseum);
  }


  /**
   * Get Museum.
   */
  @GetMapping("/{id}")
  public ResponseEntity<MuseumDto> getMuseum(@PathVariable Long id) {
    Museum getMuseum = this.service.getMuseum(id);
    MuseumDto convertedMuseum = ModelDtoConverter.modelToDto(getMuseum);
    return ResponseEntity.status(HttpStatus.OK).body(convertedMuseum);
  }

  /**
   * Create Museum.
   */
  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@Valid @RequestBody MuseumCreationDto museum) {
    Museum museumDto = ModelDtoConverter.dtoToModel(museum);
    Museum createdMuseum = this.service.createMuseum(museumDto);
    MuseumDto convertedMuseum = ModelDtoConverter.modelToDto(createdMuseum);
    return ResponseEntity.status(HttpStatus.CREATED).body(convertedMuseum);
  }

}