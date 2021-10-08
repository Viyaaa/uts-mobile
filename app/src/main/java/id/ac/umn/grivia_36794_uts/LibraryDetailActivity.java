package id.ac.umn.grivia_36794_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class LibraryDetailActivity extends AppCompatActivity {

    public TextView judul, keterangan;
    SumberAudioSaya dataAudio;
    public Button btnSFX;

    MediaPlayer player;
    int audioURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //biar ada tombol kembali

        judul = findViewById(R.id.detail_judul);
        keterangan = findViewById(R.id.detail_keterangan);
        btnSFX = findViewById(R.id.btn_detail_play_sfx);

        dataAudio = getIntent().getParcelableExtra("data audio");

        getSupportActionBar().setTitle(dataAudio.getJudulAudio());
        judul.setText(dataAudio.getJudulAudio());
        keterangan.setText(dataAudio.getKeteranganAudio());

        //harus pakai integer karena passing data untuk createnya pakai integer.
        //ke stuck disini aja lama banget huhuhu :'(
        audioURI = getResources().getIdentifier(dataAudio.getAudioURI(), "raw", getPackageName());
        player = MediaPlayer.create(LibraryDetailActivity.this, audioURI);

        btnSFX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player.isPlaying()) {
            player.release();
            player = null;
        }
    }
}