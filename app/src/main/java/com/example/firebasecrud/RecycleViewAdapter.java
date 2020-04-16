package com.example.firebasecrud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<data_mahasiswa> listMahasiswa;
    private Context context;


    public RecyclerViewAdapter(ArrayList<data_mahasiswa> listMahasiswa, Context context) {
        this.listMahasiswa = listMahasiswa;
        this.context = context;
    }


    class ViewHolder extends RecycleView.ViewHolder{

        private TextView NIM, Nama, Jurusan;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);

            NIM = itemView.findViewById(R.id.nim);
            Nama = itemView.findViewById(R.id.nama);
            Jurusan = itemView.findViewById(R.id.jurusan);
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final String NIM = listMahasiswa.get(position).getNim();
        final String Nama = listMahasiswa.get(position).getNama();
        final String Jurusan = listMahasiswa.get(position).getJurusan();


        holder.NIM.setText("NIM: "+NIM);
        holder.Nama.setText("Nama: "+Nama);
        holder.Jurusan.setText("Jurusan: "+Jurusan);

        holder.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        return listMahasiswa.size();
    }

}
}
