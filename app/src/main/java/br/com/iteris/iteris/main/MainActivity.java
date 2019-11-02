package br.com.iteris.iteris.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.iteris.iteris.R;
import br.com.iteris.iteris.helper.TouchHelperMain;
import br.com.iteris.iteris.models.Filme;
import br.com.iteris.iteris.service.FilmeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    AdapterMain adapterMain;
    List<Filme> listaDeFilmes;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Sugestão de filme");

        listaDeFilmes = new ArrayList<>();
        rvMain = findViewById(R.id.rv_main);
        adapterMain = new AdapterMain(this, listaDeFilmes);

        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMain.setAdapter(adapterMain);

        ItemTouchHelper touchHelperMain = new ItemTouchHelper(new TouchHelperMain(this));
        touchHelperMain.attachToRecyclerView(rvMain);

        load();

    }

    public void load(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://iteris.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(FilmeService.class)
                .getFilmes()
                .enqueue(new Callback<List<Filme>>() {
                    @Override
                    public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                        listaDeFilmes.clear();
                        listaDeFilmes.add(response.body().get((int) Math.round(Math.random()*8)));
                        adapterMain.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Filme>> call, Throwable t) {}
                });



    }

}
