package com.carros.carrosmaterial;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Carros> carros = new ArrayList<>();

    public static void agregar(Carros p) {
        carros.add(p);
    }

    public static ArrayList<Carros> mostrar() {
        return carros;
    }
}