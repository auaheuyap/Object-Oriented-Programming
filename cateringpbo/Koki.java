/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

//import static cateringpbo.CateringPBO.globalPesananList;
import static cateringpbo.CateringPBO.menuList;

/**
 *
 * @author ACER
 */
public class Koki {
    
    private static int it=0;
    private int id;
    
    public Koki(){
    id=it;
    it++;
    }
    
    public void lihatPesanan(){
//    for (Pesanan x: globalPesananList)x.getMenuPesanan(menuList);
    }
    
    public void updateStatusPesanan(Customer customer,int id){
    customer.getPesanan(id).updateStatus();
    }
    
}
