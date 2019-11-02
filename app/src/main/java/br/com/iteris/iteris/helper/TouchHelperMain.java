package br.com.iteris.iteris.helper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import br.com.iteris.iteris.main.MainActivity;

public class TouchHelperMain extends ItemTouchHelper.Callback {

    private MainActivity mainActivity;

    public TouchHelperMain(MainActivity mainActivity){
        this.mainActivity = mainActivity;
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
        Toast.makeText(mainActivity, "DISPENSADO", Toast.LENGTH_SHORT).show();
        mainActivity.load();
    }
}
