package edu.neu.ccs.cs6650.Model;

import java.util.List;

public class SeasonsList {
  private List<String> seasons;

  public SeasonsList(List<String> seasons) {
    this.seasons = seasons;
  }

  public List<String> getSeasons() {
    return seasons;
  }
}
