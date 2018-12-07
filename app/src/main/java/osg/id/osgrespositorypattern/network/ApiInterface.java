package osg.id.osgrespositorypattern.network;


import java.util.List;

import osg.id.osgrespositorypattern.model.Users;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/users")
    Call<List<Users>> getListUsers();

    @GET("/post/{id}")
    Call<Users> getDetailUsers(@Path("id") int id);
}



