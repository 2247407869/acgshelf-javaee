package com.lls.springboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Anime {
  @Id
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
  private long collection;
//  @OneToMany(mappedBy="anime",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//  private Set<AnimeUser> animeUsers = new HashSet<AnimeUser>();

}
