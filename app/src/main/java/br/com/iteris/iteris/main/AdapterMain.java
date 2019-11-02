package br.com.iteris.iteris.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.iteris.iteris.R;
import br.com.iteris.iteris.models.Filme;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.MainHolder> {

    Context context;
    LayoutInflater inflater;
    List<Filme> listaDeFilmes;


    public AdapterMain(Context context, List<Filme> listaDeFilmes){
        this.listaDeFilmes = listaDeFilmes;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.adapter_main, viewGroup, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder mainHolder, int i) {

        Glide.with(context)
                .load(this.listaDeFilmes.get(i).getImage())
                .into(mainHolder.img);

        mainHolder.nome.setText(this.listaDeFilmes.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return this.listaDeFilmes.size();
    }

    public static class MainHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nome;

        public MainHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_main);
            nome = itemView.findViewById(R.id.nome_main);

        }
    }
}
