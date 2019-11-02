package br.com.iteris.iteris.favoritos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.com.iteris.iteris.R;
import br.com.iteris.iteris.dao.FilmesDao;
import br.com.iteris.iteris.listener.ElementClickListener;

public class AdapterFavoritos extends RecyclerView.Adapter<AdapterFavoritos.FavoritosHolder> {

    Context context;
    LayoutInflater inflater;
    ElementClickListener elementClickListener;


    public AdapterFavoritos(Context context){
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setElementClickListener(ElementClickListener elementClickListener) {
        this.elementClickListener = elementClickListener;
    }

    @NonNull
    @Override
    public AdapterFavoritos.FavoritosHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.adapter_favoritos, viewGroup, false);
        return new FavoritosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavoritos.FavoritosHolder favoritosHolder, final int i) {

        Glide.with(context)
                .load(FilmesDao.filmesDAO.get(i).getImage())
                .into(favoritosHolder.img);

        favoritosHolder.nome.setText(FilmesDao.filmesDAO.get(i).getName());

        favoritosHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilmesDao.filmeSelecionado = FilmesDao.filmesDAO.get(i);
                elementClickListener.onClickElement();
            }
        });

    }

    @Override
    public int getItemCount() {
        return FilmesDao.filmesDAO.size();
    }

    public void remove(int posicaoItem) {
        FilmesDao.filmesDAO.remove(posicaoItem);
        notifyDataSetChanged();
    }

    public static class FavoritosHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nome;
        View card;
        TextView age;

        public FavoritosHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_favoritos);
            age = itemView.findViewById(R.id.tvAge);
            nome = itemView.findViewById(R.id.nome_favoritos);
            card = itemView.findViewById(R.id.card_favoritos);

        }
    }
}
