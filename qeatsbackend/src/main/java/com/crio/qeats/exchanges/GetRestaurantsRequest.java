/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GetRestaurantsRequest {

    @NotNull
    @Max(90)
    @Min(-90)
    private Double latitude;
    @NotNull
    @Max(180)
    @Min(-180)
    private Double longitude;

    public GetRestaurantsRequest(){

    }

    public GetRestaurantsRequest(Double latitude, Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
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



