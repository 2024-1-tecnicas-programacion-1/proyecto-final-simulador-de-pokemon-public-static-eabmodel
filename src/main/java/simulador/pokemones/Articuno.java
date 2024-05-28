package simulador.pokemones;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;

public class Articuno extends Pokemon{

    public Articuno(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo) {
        super(nombre, salud, puntosDeAtaque, tipo);
    }//cierra contructor

    public void atacar(Pokemon oponente){ //🅿️
        double saludOponente = oponente.getSalud();
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo, oponente.getTipo());
        double daño = this.puntosDeAtaque * multiplicador;
    }//cierra atacar

    public void recibirDaño(double daño){ //🅿️
        double salud = this.salud - daño;
    }//cierra recibirDaño

    public void entrenar(){ //🅿️
        entrenar();
    }//cierra recibirDaño

}//cierra class