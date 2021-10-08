package id.ac.umn.grivia_36794_uts;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class AdapterLibrary extends RecyclerView.Adapter<AdapterLibrary.ItemLibraryViewHolder> {
    private final Context context;
    private final LinkedList<SumberAudioSaya> mListAudioSaya;
    private ClickListener listener;

    public AdapterLibrary(Context context, LinkedList<SumberAudioSaya> listAudioSaya, ClickListener listener) {
        this.context = context;
        this.mListAudioSaya = listAudioSaya;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterLibrary.ItemLibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.audio_saya, parent, false);
        return new ItemLibraryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLibrary.ItemLibraryViewHolder holder, int position) {
        holder.judul.setText(mListAudioSaya.get(position).getJudulAudio());
        holder.keterangan.setText(mListAudioSaya.get(position).getKeteranganAudio());
        holder.hapus.setOnClickListener(v -> listener.hapusAudio(position));
    }

    @Override
    public int getItemCount() {
        return mListAudioSaya.size();
    }

    public class ItemLibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView judul, keterangan;
        private ImageView hapus;

        public ItemLibraryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.judul = itemView.findViewById(R.id.item_judul);
            this.keterangan = itemView.findViewById(R.id.item_keterangan);
            this.hapus = itemView.findViewById(R.id.item_hapus);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            hapus.setOnClickListener(a -> {
//                listener.hapusAudio(getAdapterPosition());
//            });
            Intent keDetailAudio = new Intent(context.getApplicationContext(), LibraryDetailActivity.class);
            keDetailAudio.putExtra("data audio", mListAudioSaya.get(getAdapterPosition()));
            context.startActivity(keDetailAudio);
        }
    }
}
