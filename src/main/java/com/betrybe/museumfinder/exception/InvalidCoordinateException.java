package com.betrybe.museumfinder.exception;

/**
 * Exceção lançada quando uma coordenada é considerada inválida.
 */

public class InvalidCoordinateException extends RuntimeException {
  private static final String errorMessage = "Coordenada inválida!";

  public InvalidCoordinateException() {
    super(errorMessage);
  }
}
