package simulador.pokemon;

public abstract class Pokemon {
    private String nombre;
    private double salud;
    private double puntosDeAtaque;
    private String tipo;
    private String estado;

    public Pokemon (String nombre, double salud, double puntosDeAtaque, String tipo, String estado){
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }//cierra constructor

    public String getNombre(){
        return this.nombre;
    }//cierra getNombre

    public void setNombre(String nombre){
        this.nombre = nombre;
    }//cierra setNombre

    public double getSalud(){
        return this.salud;
    }//cierra getSalud

    public void setSalud(double salud){
        this.salud = salud;
    }//cierra setSalud

    public double getPuntosDeAtaque(){
        return this.puntosDeAtaque;
    }//cierra getPuntosDeAtaque

    public void setPuntosDeAtaque(double puntosDeAtaque){
        this.puntosDeAtaque = puntosDeAtaque;
    }//cierra setPuntosDeAtaque

    public String getTipo(){
        return this.tipo;
    }//cierra getTipo

    public void setTipo(String tipo){
        this.tipo = tipo;
    }//cierra setTipo

    public String getEstado(){
        return this.estado;
    }//cierra getEstado

    public void setEstado(String estado){
        this.estado = estado;
    }//cierra setEstado

    public void atacar(Pokemon oponente) { 
     int danio = (int)(this.puntosDeAtaque * TipoPokemon.obtenerMultiplicador(this.tipo, oponente.tipo));
     oponente.recibirDaño(danio);
    }  
    public abstract int recibirDaño();
     this.salud -= danio;
    //Revisar tipo de dato //"int daño" //Esperar indicacion del profe

    public void entrenar() {
        this.puntosDeAtaque += 5;
        this.salud += 10;
    }
    //Revisar tipo de dato //"daño" //Esperar indicacion del profe

}//cierra class