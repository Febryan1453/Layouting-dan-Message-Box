package com.febryan.layoutandmassage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.febryan.layoutandmassage.databinding.MessageBoxBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private MessageBoxBinding binding;

//    private Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MessageBoxBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        btnToast = findViewById(R.id.btn_toast);
//        btnToast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        binding.btnToast.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Ini adalah Toast", Toast.LENGTH_SHORT).show();
        });

        binding.btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Judul Alert");
            alert.setIcon(R.drawable.input);
            alert.setMessage("Pesan alert");

            alert.setPositiveButton("Ya",(dialog, which) -> {
                Toast.makeText(MainActivity.this, "Positive Button", Toast.LENGTH_SHORT).show();
            });

            alert.setNegativeButton("Tidak",(dialog, which) -> {
                Toast.makeText(MainActivity.this, "Negative Button", Toast.LENGTH_SHORT).show();
            });

            alert.setNeutralButton("Batal",(dialog, which) -> {
                Toast.makeText(MainActivity.this, "Neutral Button", Toast.LENGTH_SHORT).show();
            });
            alert.show();
        });

        binding.btnSnackbar.setOnClickListener(v -> {
            Snackbar mySnacbar = Snackbar.make(findViewById(R.id.layout_massage_box), "Ini Snacbar", Snackbar.LENGTH_LONG);
            mySnacbar.setAction("oke", v1 -> {
                Toast.makeText(MainActivity.this, "Ok Snacbar", Toast.LENGTH_SHORT).show();
            });
            mySnacbar.show();
        });

    }
}