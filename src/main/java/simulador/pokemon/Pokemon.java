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

    public String getNombre() { //✅
        return nombre;
    }//cierra getNombre

    public double getSalud() { //✅
        return salud;
    }//cierra getSalud

    public double getPuntosDeAtaque() { //✅
        return puntosDeAtaque;
    }//cierra getPuntosDeAtaque

    public TipoPokemon getTipo() { //✅
        return tipo;
    }//cierra getTipo

    public Estado getEstado() { //✅
        return estado;
    }//cierra getEstado

    public void setNombre (String nombre){ //✅
        this.nombre = nombre;
    }//cierra setNombre

    public void setSalud (double salud){ //✅
        this.salud = salud;
    }//cierra setSalud

    public void setPuntosDeAtaque (double puntosDeAtaque){ //✅
        this.puntosDeAtaque = puntosDeAtaque;
    }//cierra setSalud



    // Métodos //

    //Complejidad temporal: O(1) Tiempo constante
    public double atacar(Pokemon oponente) { //✅
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo, oponente.getTipo());
        double daño = this.puntosDeAtaque * multiplicador;
        return daño;
    }//cierra atacar

    //Complejidad temporal: O(1) Tiempo constante
    public void recibirDaño(double daño) { //✅
        this.salud -= daño;
        if (this.salud <= 0) {
            this.salud = 0;
            this.estado = Estado.DEBILITADO;
            System.out.println(" \n \n \n \n "); //Espacio visual TODO: Revisar altura.
            System.out.println(" ⭐️ ⭐️ ⭐️ ¡ " + this.nombre + " ha sido debilitado ! 💤 ⭐️ ⭐️ ⭐️");
            System.out.println(" \n \n \n \n "); //Espacio visual TODO: Revisar altura.
        }//cierra if
    }//cierra recibirDaño

    //Complejidad temporal: O(1) Tiempo constante
    public void entrenar() {//✅

        this.puntosDeAtaque += 20;
        this.salud += 5;

    }//cierra entrenar

}//cierra class
