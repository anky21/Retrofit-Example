package me.anky.retrofityoutube.service;

import java.util.List;

import me.anky.retrofityoutube.model.Student;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Anky An on 8/06/2017.
 * anky25@gmail.com
 */

public interface APIService {
    @GET("json_bangla")
    Call<List<Student>> getPeopleDetails();
}
