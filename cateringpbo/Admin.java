/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ACER
 */
public class Admin {
    private static int it=0;
    private int id;
    private String username,password;
    private boolean loginStatus=false;
    private Menu menu;
    
    public Admin(String username,String password){
    this.username=username;
    this.password=password;
    id=it;
    id++;
    }
    
    public void login(String username, String password){
        if(username==this.username && password==this.password)loginStatus=true;
    }
    
    public void logout(){loginStatus=false;}
    
    public void addMenu(LinkedList <Menu> menuList, String namaMenu, int hargaMenu){
    if(loginStatus==true){
    menu = new Menu(namaMenu,hargaMenu);
    menuList.add(menu);
    }
    }
    
    public void deleteMenu(LinkedList <Menu> menuList, int idMenu){
    if(loginStatus==true){
    menuList.subList(idMenu,idMenu+1).clear();
    }
    }
    
public void lihatMenu(LinkedList <Menu> menuList){
System.out.println("id nama harga");    
Iterator<Menu> itr = menuList.iterator();
while(itr.hasNext()){
    Menu x=itr.next();
System.out.println(x.getID()+" "+x.getNama()+" "+x.getHarga());
        }
System.out.println();
}
    
    public int getID(){return id;}

    
}
