package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Museum.
 */

@Service
public class MuseumService implements MuseumServiceInterface {
  private MuseumFakeDatabase fakeDatabase;
  String unimplementedMethodMessage = "Método getClosestMuseum ainda não implementado";

  @Autowired
  public MuseumService(MuseumFakeDatabase database) {
    this.fakeDatabase = database;
  }

  @Override
  public Museum createMuseum(Museum museum) {

    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException();
    }

    return fakeDatabase.saveMuseum(museum);
  }

  @Override
  public Museum getMuseum(Long id) {
    Optional<Museum> museum = fakeDatabase.getMuseum(id);

    if (museum.isEmpty()) {
      throw new MuseumNotFoundException();
    } else {
      return museum.get();
    }
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }

    Optional<Museum> closestMuseum = fakeDatabase.getClosestMuseum(coordinate, maxDistance);
    if (closestMuseum.isEmpty()) {
      throw new MuseumNotFoundException();
    }

    return closestMuseum.get();
  }
}
