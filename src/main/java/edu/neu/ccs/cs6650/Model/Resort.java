package edu.neu.ccs.cs6650.Model;

public class Resort {
  private String name;
  private int id;

  public Resort(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
}
