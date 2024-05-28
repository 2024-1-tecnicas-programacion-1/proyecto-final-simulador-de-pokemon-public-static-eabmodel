package simulador.pokemon;

public abstract class Pokemon {
    protected String nombre;
    protected double salud;
    protected double puntosDeAtaque;
    protected TipoPokemon tipo;
    protected String estado;

    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = "Normal";
    }

    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.tipo, oponente.tipo);
        int daño = (int)(this.puntosDeAtaque * multiplicador);
        oponente.recibirDaño(daño);
        System.out.println(this.nombre + " ataca a " + oponente.nombre + " y causa " + daño + " puntos de daño.");
    }

    public void recibirDaño(int daño) {
        this.salud -= daño;
        if (this.salud <= 0) {
            this.salud = 0;
            this.estado = "Debilitado";
            System.out.println(this.nombre + " ha sido debilitado.");
        }
    }

    public void entrenar() {
        this.puntosDeAtaque += 10;
        System.out.println(this.nombre + " ha sido entrenado. Puntos de ataque aumentados a " + this.puntosDeAtaque);
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }
}