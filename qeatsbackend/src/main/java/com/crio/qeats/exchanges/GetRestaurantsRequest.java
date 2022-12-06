/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
@Getter
@Setter
@NoArgsConstructor 
public class GetRestaurantsRequest {

    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;
    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitude;

   private String searchFor = "";
    

    public GetRestaurantsRequest(Double latitude, Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSearchFor() {
        return searchFor;
    }
    public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
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
}



