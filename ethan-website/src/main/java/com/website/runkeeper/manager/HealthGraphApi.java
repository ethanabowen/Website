//package com.website.runkeeper.manager;
//
//import com.thoughtworks.healthgraphexplorer.service.model.User;
//import com.thoughtworks.healthgraphexplorer.service.model.WeightSet;
//import com.thoughtworks.healthgraphexplorer.service.model.WeightSetFeed;
//
//import retrofit2.Response;
//import retrofit2.http.Body;
//import retrofit2.http.DELETE;
//import retrofit2.http.GET;
//import retrofit2.http.Headers;
//import retrofit2.http.POST;
//import retrofit2.http.Path;
//
//import static com.thoughtworks.healthgraphexplorer.service.HealthGraphService.HealthGraphDynamicPath;
//
//public interface HealthGraphApi {
//    String ACCEPT = "Accept: ";
//    String CONTENT_TYPE = "Content-Type: ";
//
//    @GET("/user")
//    @Headers(ACCEPT + "application/vnd.com.runkeeper.User+json")
//    User getUser();
//
//    @GET("/weight")
//    @HealthGraphDynamicPath
//    @Headers(ACCEPT + "application/vnd.com.runkeeper.WeightSetFeed+json")
//    WeightSetFeed getWeightSetFeed();
//
//    @POST("/weight")
//    @HealthGraphDynamicPath
//    @Headers(CONTENT_TYPE + "application/vnd.com.runkeeper.NewWeightSet+json")
//    Response postWeightSet(@Body WeightSet weightSet);
//
//    @DELETE("/weight/{id}")
//    @HealthGraphDynamicPath
//    Response deleteWeightSet(@Path("id") String id);
//}


//application/vnd.com.runkeeper.FitnessActivity+json
/*Sample Request
GET /user HTTP/1.1
Host: api.runkeeper.com
Authorization: Bearer xxxxxxxxxxxxxxxx
Accept: application/vnd.com.runkeeper.User+json*/
