package id.ac.umn.grivia_36794_uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Objects;

public class LibraryActivity extends AppCompatActivity {

    static LinkedList<SumberAudioSaya> listAudioSaya;
    RecyclerView recyclerView;

    private ClickListener listener;

    String nama;
    static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent loginActivity = getIntent();
        nama = loginActivity.getStringExtra("Username");
        if(nama != null) {
            username = nama;
            Objects.requireNonNull(getSupportActionBar()).setTitle(username);
            Toast.makeText(getApplicationContext(), "Selamat datang, " + nama, Toast.LENGTH_SHORT).show();
        } else {
            Objects.requireNonNull(getSupportActionBar()).setTitle(username);
        }

        recyclerView = findViewById(R.id.recyclerView);

        listener = new ClickListener() {
            @Override
            public void hapusAudio(int posisi) {
                listAudioSaya.remove(posisi);
                recyclerView.getAdapter().notifyItemRemoved(posisi);
            }
        };

        seedData(); //generate data
        recyclerView.setAdapter(new AdapterLibrary(this, listAudioSaya, listener));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeMenu:
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
                return true;
            case R.id.profileMenu:
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                startActivity(profileIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    void seedData() {
        listAudioSaya = new LinkedList<>();
        listAudioSaya.add(new SumberAudioSaya("Audio 1", "Audio Ke-1", "do_low"));
        listAudioSaya.add(new SumberAudioSaya("Audio 2", "Audio Ke-2", "re"));
        listAudioSaya.add(new SumberAudioSaya("Audio 3", "Audio Ke-3", "mi"));
        listAudioSaya.add(new SumberAudioSaya("Audio 4", "Audio Ke-4", "fa"));
        listAudioSaya.add(new SumberAudioSaya("Audio 5", "Audio Ke-5", "sol"));
        listAudioSaya.add(new SumberAudioSaya("Audio 6", "Audio Ke-6", "la"));
        listAudioSaya.add(new SumberAudioSaya("Audio 7", "Audio Ke-7", "sampel"));
    }

}