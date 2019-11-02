package br.com.iteris.iteris.favoritos;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import br.com.iteris.iteris.R;
import br.com.iteris.iteris.helper.TouchHelperFavoritos;
import br.com.iteris.iteris.listener.ElementClickListener;
import br.com.iteris.iteris.main.AdapterMain;
import br.com.iteris.iteris.selecionado.Selecionado;

public class ActivityFavoritos extends AppCompatActivity {

    RecyclerView rvFavoritos;
    AdapterFavoritos adapterFavoritos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setTitle("Favoritos");

        rvFavoritos = findViewById(R.id.rv_favoritos);
        adapterFavoritos = new AdapterFavoritos(this);

        rvFavoritos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvFavoritos.setAdapter(adapterFavoritos);

        ItemTouchHelper touchHelperMain = new ItemTouchHelper(new TouchHelperFavoritos(this, adapterFavoritos));
        touchHelperMain.attachToRecyclerView(rvFavoritos);

        adapterFavoritos.setElementClickListener(new ElementClickListener() {
            @Override
            public void onClickElement() {
                startActivity(new Intent(ActivityFavoritos.this, Selecionado.class));
            }
        });

        adapterFavoritos.notifyDataSetChanged();

    }
}
