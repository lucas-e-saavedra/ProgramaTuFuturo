package com.tutacode.infonube.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Lucas.Saavedra on 6/5/2017.
 */

public interface APIArticulos {

    @GET("/macros/s/AKfycbxb53scZkag8_Brvq0ZMaYDdA3Fn9gly_-vrhvI4eW46-9Y5O-9/exec?spreadsheetID=17aURH2JZ87dG3gEkhAzxj-gRvD-2V6RBoSfV3Ovq11o")
    Call<RespuestaConsultaDeArticulos> consultarListaDeArticulos();
}
