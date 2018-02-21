package ejercicio20;

/**
 *
 * @author Arturo
 */
public class Libro {
    private String nome, autor;
    private float precio;
    private int unidades;

    public Libro(){
    }

    public Libro(String nome, String autor, float precio, int unidades){
        this.nome=nome;
        this.autor=autor;
        this.precio=precio;
        this.unidades=unidades;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }

    public float getPrecio(){
        return precio;
    }

    public void setPrecio(float precio){
        this.precio=precio;
    }

    public int getUnidades(){
        return unidades;
    }

    public void setUnidades(int unidades){
        this.unidades=unidades;
    }
    
    @Override
    public String toString(){
        return("Titulo: "+nome+" Autor: "+autor+" Precio: "+precio+"€ Unidades: "+unidades);
    }
}
