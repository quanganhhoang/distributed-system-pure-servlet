package edu.neu.ccs.cs6650.model;

import java.util.List;

public class ResortsList {
  private List<Resort> resorts;

  public ResortsList(List<Resort> resorts) {
    this.resorts = resorts;
  }

  public List<Resort> getResorts() {
    return resorts;
  }
}
