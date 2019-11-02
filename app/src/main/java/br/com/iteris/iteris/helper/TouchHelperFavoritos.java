package br.com.iteris.iteris.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import br.com.iteris.iteris.favoritos.ActivityFavoritos;
import br.com.iteris.iteris.favoritos.AdapterFavoritos;

public class TouchHelperFavoritos extends ItemTouchHelper.Callback {

    private ActivityFavoritos activityFavoritos;
    private AdapterFavoritos adapterFavoritos;

    public TouchHelperFavoritos(ActivityFavoritos activityFavoritos, AdapterFavoritos adapterFavoritos){
        this.adapterFavoritos = adapterFavoritos;
        this.activityFavoritos = activityFavoritos;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int marcacoesDeDeslize = ItemTouchHelper.LEFT;
        return makeMovementFlags(0, marcacoesDeDeslize);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int posicaoItem = viewHolder.getAdapterPosition();
        adapterFavoritos.remove(posicaoItem);
    }
}
