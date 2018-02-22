package ejercicio20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class Libreria{

    private Libro libro;
    private File fichLib;
    private Scanner sc;
    private PrintWriter escribir;
    ArrayList<Libro> listaLibros=new ArrayList();


    public void crearLibreria(){
        fichLib=new File("libreria.txt");
        if(fichLib.exists()){
            String linea;
            String[] lista=new String[4];
            Libro lib;
            try{
                sc=new Scanner(new File("libreria.txt"));
                while(sc.hasNextLine()){
                    linea=sc.nextLine();
                    lista=linea.split(",");
                    lib=new Libro(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                    listaLibros.add(lib);
                }
            }catch(FileNotFoundException ex){
                System.out.println("Erro 1 "+ex.getMessage());
            }catch(NullPointerException ex){
                System.out.println("Erro 2 "+ex.getMessage()+"\nNo se puede leer de un fichero vacio");
            }
            sc.close();
        }else{
        listaLibros.add(new Libro("Aliens", "Fernando", 12.5f, 50));
        listaLibros.add(new Libro("Fisica Nuclear", "Javier", 40f, 20));
        listaLibros.add(new Libro("Subnautica", "Miguel", 12.5f, 50));
        listaLibros.add(new Libro("El arte de la guerra", "Sun-Tzu", 12.5f, 50));
        this.guardarLibros();
        }
    }

    public void añadirLibro(){
        String t=JOptionPane.showInputDialog("Titulo del libro");
        String a=JOptionPane.showInputDialog("Autor del libro");
        float p=Float.parseFloat(JOptionPane.showInputDialog("Precio del libro"));
        int n=Integer.parseInt(JOptionPane.showInputDialog("Unidades del libro"));
        libro=(new Libro(t, a, p, n));
        listaLibros.add(libro);
    }

    public void guardarLibros(){
        fichLib=new File("libreria.txt");
        try{
            escribir=new PrintWriter(fichLib);
            for(int i=0; i<listaLibros.size(); i++){
                libro=listaLibros.get(i);
                escribir.println(libro.getNome()+","+libro.getAutor()+","+libro.getPrecio()+","+libro.getUnidades());
            }
        }catch(FileNotFoundException ex){
            System.out.println("Erro 1 "+ex.getMessage());
        }catch(NullPointerException ex){
            System.out.println("Erro 2 "+ex.getMessage()+"\nNo se puede leer de un fichero vacio");
        }finally{
            escribir.close();
        }
    }

    public void visualizarLibros(){
        String linea;
        String[] lista=new String[4];
        Libro lib;
        try{
            sc=new Scanner(new File("libreria.txt"));
            while(sc.hasNextLine()){
                linea=sc.nextLine();
                lista=linea.split(",");
                lib=new Libro(lista[0], lista[1], Float.parseFloat(lista[2]), Integer.parseInt(lista[3]));
                System.out.println(lib.toString());
            }
            System.out.println("\n");
        }catch(FileNotFoundException ex){
            System.out.println("Erro 1 "+ex.getMessage());
        }catch(NullPointerException ex){
            System.out.println("Erro 2 "+ex.getMessage()+"\nNo se puede leer de un fichero vacio");
        }
        sc.close();
    }

    public void buscarLibro(){
        String tit=null;
        boolean marc=false;
        String nombre=JOptionPane.showInputDialog("Intoduce el titulo a buscar");
        for(int i=0; i<listaLibros.size(); i++){
            tit=listaLibros.get(i).getNome();
            if(tit.equalsIgnoreCase(nombre)){
                marc=true;
                JOptionPane.showMessageDialog(null, listaLibros.get(i).toString());
            }
        }
        if(marc==false){
            JOptionPane.showMessageDialog(null, "No se dispone de ese Libro");
        }
    }

    public void borrarLibros(){
        for(int i=0; i<listaLibros.size(); i++){
            if(listaLibros.get(i).getUnidades()==0){
                listaLibros.remove(i);
            }
        }
        this.guardarLibros();
    }

    public void cambiarPrecio(){
        String tit=null;
        boolean marc=false;
        String nombre=JOptionPane.showInputDialog("Intoduce el titulo a buscar");
        float pre=Float.parseFloat(JOptionPane.showInputDialog("Nuevo Precio"));
        for(int i=0; i<listaLibros.size(); i++){
            tit=listaLibros.get(i).getNome();
            if(tit.equalsIgnoreCase(nombre)){
                marc=true;
                listaLibros.get(i).setPrecio(pre);
            }
        }
        if(marc==false){
            JOptionPane.showMessageDialog(null, "No se dispone de ese Libro");
        }
    }

}
