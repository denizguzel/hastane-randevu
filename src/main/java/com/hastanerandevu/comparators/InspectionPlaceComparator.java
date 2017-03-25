package com.hastanerandevu.comparators;

import com.hastanerandevu.model.InspectionPlaceModel;

import java.util.Comparator;

/**
 * Created by Okan on 25.3.2017.
 */
public class InspectionPlaceComparator implements Comparator<InspectionPlaceModel> {
  public int compare(InspectionPlaceModel o1, InspectionPlaceModel o2) {
    return o1.getPlaceName().compareTo(o2.getPlaceName());
  }
}
