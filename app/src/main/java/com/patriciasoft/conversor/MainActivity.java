package com.patriciasoft.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.patriciasoft.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getResultadoM().observe(this, new Observer<Double>() {

            @Override
            public void onChanged(Double resultado) {
                binding.etImporteR.setText(String.format("%.2f", resultado));
            }
        });

        binding.btConvertir.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                vm.calcular(binding.etImporteD.getText().toString(),
                            binding.etImporteE.getText().toString(),
                            binding.rbDolares.isChecked(),
                            binding.rbEuros.isChecked());
            }


        });

        binding.rdGroup.setOnCheckedChangeListener((grupo, i) -> {

            boolean euros = binding.rbEuros.isChecked();
                            binding.etImporteE.setFocusable(euros);
                            binding.etImporteE.setFocusableInTouchMode(euros);
                            binding.etImporteE.setClickable(euros);
                            binding.etImporteE.setLongClickable(euros);
                            binding.etImporteE.setText("");
                            binding.etImporteR.setText("");

            boolean dolares = binding.rbDolares.isChecked();
                              binding.etImporteD.setFocusable(dolares);
                              binding.etImporteD.setFocusableInTouchMode(dolares);
                              binding.etImporteD.setClickable(dolares);
                              binding.etImporteD.setLongClickable(dolares);
                              binding.etImporteD.setText("");
                              binding.etImporteR.setText("");
                }
        );
    }
}
