package com.patriciasoft.conversor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Double> resultadoM;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public void calcular (String importeD, String importeE, boolean dolares, boolean euros) {
        double cantidadD;
        double cantidadE;
        double resultado = 0.0;
        if(importeD.isEmpty() || importeD.equals(".")) {
            cantidadD = 0;
        }else{
            cantidadD= Double.parseDouble(importeD);
        }

        if(importeE.isEmpty() || importeE.equals(".")) {
            cantidadE = 0;
        }else{
            cantidadE= Double.parseDouble(importeE);
        }


        if (dolares) {
            // Realizar conversión de Dólares a Euros
            resultado = cantidadD * 0.85;

        } else if (euros) {
            // Realizar conversión de Euros a Dólares
            resultado = cantidadE / 2.85;
        }
        resultadoM.setValue(resultado);
    }
    public LiveData<Double> getResultadoM(){
        if(resultadoM==null){
            resultadoM = new MutableLiveData<Double>();
        }
        return resultadoM;
    }
}
