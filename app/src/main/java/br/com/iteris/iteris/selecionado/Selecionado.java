package br.com.iteris.iteris.selecionado;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.iteris.iteris.R;
import br.com.iteris.iteris.dao.FilmesDao;
import br.com.iteris.iteris.models.Filme;

public class Selecionado extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionado);

        setTitle(FilmesDao.filmeSelecionado.getName());

        load();
    }

    void load(){

        ImageView img;
        TextView nome;
        TextView overView;
        TextView ano;
        TextView diretor;
        TextView escritor;

        img = findViewById(R.id.img_selecionado);
        nome = findViewById(R.id.nome_selecionado);
        overView = findViewById(R.id.overView_selecionado);
        ano = findViewById(R.id.year_selecionado);
        diretor = findViewById(R.id.diretor_selecionado);
        escritor = findViewById(R.id.writer_selecionado);


        Glide.with(this)
                .load(FilmesDao.filmeSelecionado.getImage())
                .into(img);

        nome.setText(FilmesDao.filmeSelecionado.getName());
        overView.setText(FilmesDao.filmeSelecionado.getOverview());
        ano.setText(FilmesDao.filmeSelecionado.getYear());
        diretor.setText(FilmesDao.filmeSelecionado.getDirector());
        escritor.setText(FilmesDao.filmeSelecionado.getWriter());

    }

}
