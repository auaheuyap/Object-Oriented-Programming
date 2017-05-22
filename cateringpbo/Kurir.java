/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

import java.time.LocalDateTime;

/**
 *
 * @author ACER
 */
public class Kurir {
    private static int it=0;
    private int id;
    LocalDateTime waktuPengiriman;
    public Kurir(){
    id=it;
    it++;
    }
    
    public void lihatPengiriman(Customer customer){
    //System.out.println(customer.getID()+" "+customer.getNama()+" "+customer.getAlamat()+" "
    }
    
    public void updateStatusPengiriman(Customer customer,int id){
    customer.getPengiriman(id).updateStatus();
    customer.getPengiriman(id).setWaktuPengiriman(waktuPengiriman.now());
    }
}
