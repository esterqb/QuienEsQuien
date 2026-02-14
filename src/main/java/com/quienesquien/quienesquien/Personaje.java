package com.quienesquien.quienesquien;

public class Personaje {
    private String nombre;
    private String colorPelo;
    private String colorOjos;
    private boolean tieneGafas;
    private boolean esHombre;
    private boolean tieneBarba;
    private boolean tienePelo;
    private boolean tieneGorro;
    private boolean estaSerio;
    private boolean tieneBarbilla;

    public Personaje(String nombre, String colorPelo, String colorOjos,boolean tieneGafas, boolean esHombre, boolean tieneBarba, boolean tienePelo, boolean tieneGorro, boolean estaSerio, boolean tieneBarbilla) {
        this.nombre = nombre;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.tieneGafas = tieneGafas;
        this.esHombre = esHombre;
        this.tieneBarba = tieneBarba;
        this.tienePelo = tienePelo;
        this.tieneGorro = tieneGorro;
        this.estaSerio = estaSerio;
        this.tieneBarbilla = tieneBarbilla;
    }

    public String getNombre() { return nombre; }
    public String getColorPelo() { return colorPelo; }
    public String getColorOjos() { return colorOjos; }
    public boolean isTieneGafas() { return tieneGafas; }
    public boolean isEsHombre() { return esHombre; }
    public boolean isTieneBarba() { return tieneBarba; }
    public boolean isTienePelo() { return tienePelo; }
    public boolean isTieneGorro() { return tieneGorro; }
    public boolean isEstaSerio() { return estaSerio; }
    public boolean isTieneBarbilla() { return tieneBarbilla; }
}