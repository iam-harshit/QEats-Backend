
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @JsonIgnoreProperties(ignoreUnknown = true)
// @AllArgsConstructor
// @Data
// @NoArgsConstructor
// @Document
@JsonIgnoreProperties({"id"})
public class Restaurant {

    // @JsonIgnore
    // private String id;
    // private String restaurantId;
    // private String name;
    // private String city;
    // private String imageUrl;
    // private Double latitude;
    // private Double longitude;
    // private String opensAt;
    // private String closesAt;
    // private List<String> attributes;
    private String id;
    @NotNull private String restaurantId;
    @NotNull private String name;
    @NotNull private String city;
    @NotNull private String imageUrl;
    @NotNull private Double latitude;
    @NotNull private Double longitude;
    @NotNull private String opensAt;
    @NotNull private String closesAt;
    @NotNull private List<String> attributes;


    public String getId() {
        return id;
      }
    
      public void setId(String id) {
        this.id = id;
      }
    

    public String getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getOpensAt() {
        return opensAt;
    }
    public void setOpensAt(String opensAt) {
        this.opensAt = opensAt;
    }
    public String getClosesAt() {
        return closesAt;
    }
    public void setClosesAt(String closesAt) {
        this.closesAt = closesAt;
    }
    public List<String> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    } 

}

