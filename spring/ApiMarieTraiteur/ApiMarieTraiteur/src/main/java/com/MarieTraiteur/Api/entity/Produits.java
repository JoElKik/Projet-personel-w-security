package com.MarieTraiteur.Api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="PRODUITS")
public class Produits {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column (unique = true)
  private String title;

  private String description;

  private String imageurl;

  private String type;

  public Produits() {
  }

  public Produits(int id, String title, String description, String imageurl, String type) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imageurl = imageurl;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageurl() {
    return imageurl;
  }

  public void setImageurl(String imageurl) {
    this.imageurl = imageurl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
