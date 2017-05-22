/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

/**
 *
 * @author ACER
 */
public class Menu {
    private static int it=0;
    private int hargaMenu,id;
    private String namaMenu;
    
    public Menu(String nama,int harga){
    namaMenu=nama;
    hargaMenu=harga;
    id=it;
    it++;
    }
    
    public void setNama(String nama){
    namaMenu=nama;
    }
    
    public void setHarga(int harga){
    hargaMenu=harga;
    }
    
    public String getNama(){
    return namaMenu;
    }
    
    public int getHarga(){
    return hargaMenu;
    }
    
    public int getID(){
    return id;
    }
    
}
