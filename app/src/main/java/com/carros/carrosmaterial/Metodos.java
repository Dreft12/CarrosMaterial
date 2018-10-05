package com.carros.carrosmaterial;

import java.util.ArrayList;

public class Metodos {
    private static ArrayList<Carros> carros = Datos.mostrar();

    public static boolean validar(String placa){
        boolean bool = false;
        for (int i = 0; i < carros.size(); i++){
            if (carros.get(i).getPlaca().equalsIgnoreCase(placa)){
                bool = true;
            }
        }
        return bool;
    }
}
