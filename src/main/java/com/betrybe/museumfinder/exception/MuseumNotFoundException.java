package com.betrybe.museumfinder.exception;

/**
 * Exceção lançada quando uma coordenada é considerada inválida.
 */

public class MuseumNotFoundException extends RuntimeException {
  private static final String errorMessage = "Museu não encontrado!";

  public MuseumNotFoundException() {
    super(errorMessage);
  }
}
