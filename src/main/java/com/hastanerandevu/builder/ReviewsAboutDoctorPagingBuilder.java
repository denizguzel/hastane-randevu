package com.hastanerandevu.builder;

/**
 * Created by ouzun on 5/10/2017.
 */
public class ReviewsAboutDoctorPagingBuilder {
  public static int numberOfPagingForReviews(int reviewsSize) {
    if(reviewsSize % 10 == 0) {
      return reviewsSize / 10;
    } else {
      return (reviewsSize / 10) + 1;
    }
  }
}
