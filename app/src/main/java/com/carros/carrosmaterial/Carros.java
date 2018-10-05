package com.carros.carrosmaterial;

public class Carros {
    private String placa;
    private int marca;
    private int color;
    private int foto;
    private int precio;

    public Carros(String placa, int marca, int color, int foto, int precio) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.foto = foto;
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void guardar(){
        Datos.agregar(this);
    }
}
