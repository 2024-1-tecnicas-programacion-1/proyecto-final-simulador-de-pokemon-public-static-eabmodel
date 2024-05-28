package simulador.pokemon;

import java.io.Serializable;

public abstract class Pokemon implements Serializable{
    protected String nombre;
    protected double salud;
    protected double puntosDeAtaque;
    protected TipoPokemon tipo;
    protected Estado estado;



    // Constructor //

    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = Estado.NORMAL;
    }//cierra constructor



    // Getters & Setters //

    public String getNombre() {
        return nombre;
    }//cierra getNombre

    public double getSalud() {
        return salud;
    }//cierra getSalud

    public double getPuntosDeAtaque() {
        return puntosDeAtaque;
    }//cierra getPuntosDeAtaque

    public TipoPokemon getTipo() {
        return tipo;
    }//cierra getTipo

    public Estado getEstado() {
        return estado;
    }//cierra getEstado



    // Métodos //

    public void atacar(Pokemon oponente) { //🅿️
        double saludOponente = oponente.getSalud();
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo, oponente.getTipo());
        double daño = saludOponente - (this.puntosDeAtaque * multiplicador);
        //oponente.setSalud(daño); //TODO: revisar esto.
    }//cierra atacar

    public void recibirDaño(double daño) { //🅿️
        this.salud -= daño;
        if (this.salud <= 0) {
            this.salud = 0;
            this.estado = Estado.DEBILITADO;
            System.out.println(this.nombre + " ha sido debilitado.");
        }//cierra if
    }//cierra recibirDaño

    public void entrenar() { //🅿️
        this.puntosDeAtaque += 10;
    }

    
}