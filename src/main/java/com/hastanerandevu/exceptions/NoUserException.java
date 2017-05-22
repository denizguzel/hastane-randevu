package com.hastanerandevu.exceptions;

public class NoUserException extends Exception {
  public NoUserException() {
  }

  public NoUserException(String message) {
    super(message);
  }
}
