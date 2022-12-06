/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.controller;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.services.RestaurantService;
import com.crio.qeats.utils.GeoLocation;
import java.time.LocalTime;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Slf4j
@RestController
@RequestMapping(RestaurantController.RESTAURANT_API_ENDPOINT)
public class RestaurantController {

  public static final String RESTAURANT_API_ENDPOINT = "/qeats/v1";
  public static final String RESTAURANTS_API = "/restaurants";
  public static final String MENU_API = "/menu";
  public static final String CART_API = "/cart";
  public static final String CART_ITEM_API = "/cart/item";
  public static final String CART_CLEAR_API = "/cart/clear";
  public static final String POST_ORDER_API = "/order";
  public static final String GET_ORDERS_API = "/orders";

  @Autowired
  private RestaurantService restaurantService;



  @GetMapping(RESTAURANTS_API)
  public ResponseEntity<GetRestaurantsResponse> getRestaurants(@Valid GetRestaurantsRequest getRestaurantsRequest) {


    GetRestaurantsResponse getRestaurantsResponse;
    String searchFor = getRestaurantsRequest.getSearchFor();
        
            boolean isSearch = searchFor != null && !searchFor.isEmpty();
            if (isSearch) {
         getRestaurantsResponse = restaurantService
             .findRestaurantsBySearchQuery(getRestaurantsRequest, LocalTime.now());
       } else { 
         //CHECKSTYLE:OFF
         getRestaurantsResponse = restaurantService
             .findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());      
         //CHECKSTYLE:ON
       
       }
      
             if (getRestaurantsResponse != null && !getRestaurantsResponse.getRestaurants().isEmpty()) {
              getRestaurantsResponse.getRestaurants().forEach(restaurant -> {
                restaurant.setName(restaurant.getName().replace("é", "?"));
               });
       }
      
        
          return ResponseEntity.ok().body(getRestaurantsResponse);
        
        }


    // log.info("getRestaurants called with {}", getRestaurantsRequest);
    // GetRestaurantsResponse getRestaurantsResponse;

    // GeoLocation geoloc=new GeoLocation(getRestaurantsRequest.getLatitude(), getRestaurantsRequest.getLongitude());

    // if(getRestaurantsRequest.getLongitude()==null||getRestaurantsRequest.getLatitude()==null||!geoloc.isValidGeoLocation()){

    //   return ResponseEntity.badRequest().body(null);

    // }
    
    // //CHECKSTYLE:OFF
    // getRestaurantsResponse = restaurantService
    // .findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());

    // if(getRestaurantsResponse!=null && !getRestaurantsResponse.getRestaurants().isEmpty()){
    //   List<Restaurant> restResponse=getRestaurantsResponse.getRestaurants();
    //   for(Restaurant restIter: restResponse){
    //     restIter.setName(restIter.getName().replace("é", "/"));
    //   }
    //   getRestaurantsResponse.setRestaurants(restResponse);
    // }

    // // log.info("getRestaurants returned {}", getRestaurantsResponse);
    // System.out.println("Restaurants called with:::::::......."+getRestaurantsResponse);


    // return ResponseEntity.ok().body(getRestaurantsResponse);
  }

