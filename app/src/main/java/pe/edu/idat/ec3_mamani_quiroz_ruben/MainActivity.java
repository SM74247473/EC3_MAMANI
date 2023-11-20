package pe.edu.idat.ec3_mamani_quiroz_ruben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        private EditText usuario, contrasena;
        private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            usuario = findViewById(R.id.usuario);
            contrasena = findViewById(R.id.contrasena);
            buttonLogin = findViewById(R.id.registrar);

            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (authenticateUser(usuario.getText().toString(), contrasena.getText().toString())) {
                        Intent intent = new Intent(MainActivity.this, registro.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "No esta registrado", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        private boolean authenticateUser(String username, String password) {

            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            String storedUsername = preferences.getString("Ruben", "Ruben");
            String storedPassword = preferences.getString("SYS123", "SYS123");

            return username.equals(storedUsername) && password.equals(storedPassword);
        }
    }



