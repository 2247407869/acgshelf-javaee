package com.lls.springboot.model;

import lombok.Data;

@Data
public class AnimePo {

  private long id;
  private String url;
  private String name;
  private String nameCn;
  private String summary;
  private long epsCount;
  private String airDate;
  private long airWeekday;
  private double ratingScore;
  private long rank;
  private String imagesLarge;
  private String imagesCommon;
  private String imagesMedium;
  private String imagesSmall;
  private String imagesGrid;
  private long collectionCollect;
  private long userId;
  private long collection;

}
