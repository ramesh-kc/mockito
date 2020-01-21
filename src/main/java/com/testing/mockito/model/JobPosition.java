package com.testing.mockito.model;

public class JobPosition {
  private String title;

  public JobPosition() {}

  public JobPosition(String title) {
    super();
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
