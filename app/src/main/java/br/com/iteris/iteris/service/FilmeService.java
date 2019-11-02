package br.com.iteris.iteris.service;

import java.util.List;

import br.com.iteris.iteris.models.Filme;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmeService {

    @GET("movies.json")
    Call<List<Filme>> getFilmes();

}
