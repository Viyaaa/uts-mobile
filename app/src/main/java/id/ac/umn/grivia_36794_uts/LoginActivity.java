package id.ac.umn.grivia_36794_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout username;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        submitBtn = findViewById(R.id.submitBtn);
        username = findViewById(R.id.usernameLogin);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = username.getEditText().getText().toString();

                if(nama.isEmpty()) {
                    //Log.d("Empty", "Tidak ada isinya");
                    username.setError("Nama silahkan diisi");
                    Toast.makeText(v.getContext(), "Harap diisi", Toast.LENGTH_LONG).show();
                } else {
                    //Kirim data nama ke LibraryActivity
                    Intent libraryIntent = new Intent(LoginActivity.this, LibraryActivity.class);
                    libraryIntent.putExtra("Username", nama);
                    startActivity(libraryIntent);
                }
            }
        });
    }
}