package com.hastanerandevu.exceptions;

/**
 * Created by ouzun on 4/25/2017.
 */
public class NoUserException extends Exception {
  public NoUserException(){}

  public NoUserException(String message){
    super(message);
  }
}
