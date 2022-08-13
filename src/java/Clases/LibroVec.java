/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Suzzanne Acevedo
 */
public class LibroVec {
    
    Libro[] tabLibro;
    int ind;
    
    public LibroVec(){
        this.tabLibro=new Libro[50];
        this.ind=0;    
    }
    
    public void saveLi (Libro libro){
        this.tabLibro[this.ind]=libro;
        this.ind=this.ind+1;
    
    }
    
    public Libro[] gimmeLi(){
        return this.tabLibro;
    
    }
    
    
}
