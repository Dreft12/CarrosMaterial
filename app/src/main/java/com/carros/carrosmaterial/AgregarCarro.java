package com.carros.carrosmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarro extends AppCompatActivity {
    private EditText txtPlaca, txtPrecio;
    private Spinner cmbMarca, cmbColor;
    private ArrayList<Integer> fotos;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtPrecio = findViewById(R.id.txtPrecio);
        cmbMarca = findViewById(R.id.cmbMarca);
        cmbColor = findViewById(R.id.cmbColor);
        foto = findViewById(R.id.foto);
        fotos = new ArrayList<>();
        fotos.add(R.drawable.carro1);
        fotos.add(R.drawable.carro2);
        fotos.add(R.drawable.carro3);
        fotos.add(R.drawable.carro4);
    }

    public int fotoAleatoria(){
        int fotoSel;
        Random r = new Random();
        fotoSel = r.nextInt(this.fotos.size());
        return fotos.get(fotoSel);
    }

    public void guardar(View v){
        String pla;
        int foto, pre, mar, col;
        if(!txtPlaca.getText().toString().isEmpty()){
            if(!txtPrecio.getText().toString().isEmpty()){
                foto = this.fotoAleatoria();
                pla = txtPlaca.getText().toString();
                pre = Integer.parseInt(txtPrecio.getText().toString());
                mar = cmbMarca.getSelectedItemPosition();
                col = cmbColor.getSelectedItemPosition();
                if (pre > 0) {
                    if (!Metodos.validar(pla)) {
                        Carros c = new Carros(pla, mar, col, foto, pre);
                        c.guardar();
                        limpiar();
                        Snackbar.make(v, getResources().getString(R.string.guardado_exito), Snackbar.LENGTH_SHORT).show();
                    } else {
                        Snackbar.make(v, getResources().getString(R.string.errorPlaca), Snackbar.LENGTH_SHORT).show();
                    }
                }else{
                    txtPrecio.setError(getResources().getString(R.string.errorTextPrecioCero));
                }
            }else{
                txtPrecio.setError(getResources().getString(R.string.errorTextPrecio));
            }
        }else{
            txtPlaca.setError(getResources().getString(R.string.errorTextPlaca));
        }

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarro.this, Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        txtPlaca.setText("");
        txtPrecio.setText("");
        txtPlaca.setText("");
        txtPlaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void limpiar(View v){
        limpiar();
    }
}
