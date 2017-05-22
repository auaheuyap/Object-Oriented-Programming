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
public class IdJumlahMenu {

private int idMenu,jumlahMenu;

public IdJumlahMenu(int idMenu,int jumlahMenu){
this.idMenu=idMenu;
this.jumlahMenu=jumlahMenu;
} 

public int getID(){
return idMenu;
}

public int getJumlah(){
return jumlahMenu;
}

}
