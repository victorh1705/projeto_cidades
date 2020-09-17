package com.example.rest_api.model;

public class Cidade {
  private String nome;

  private String pais;

  private String latitude;

  private String longitude;

  public Cidade(String nome, String pais, String latitude, String longitude){
    this.nome = nome;
    this.pais = pais;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getNome() {
    return nome;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}