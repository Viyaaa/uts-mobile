package id.ac.umn.grivia_36794_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("My Profile"); //set title di bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //biar ada tombol kembali
    }
}