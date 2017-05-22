/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

//import static cateringpbo.CateringPBO.globalPengirimanList;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class Pembayaran {
    private static int it=0;
    private int totalBayar,id;
    private LocalDateTime waktuDiciptakan,waktuBayar;
    private boolean statusBayar=false;
    private Customer customer;
    private Pesanan pesanan;

    
    public  Pembayaran(Pesanan pesanan){
    this.pesanan=pesanan;
    waktuDiciptakan=LocalDateTime.now();
    totalBayar=pesanan.getHarga();
    
    
//    globalPengirimanList.add(pengiriman);
    
    id=it;
    it++;
    }
    
    public void setWaktuBayar(LocalDateTime waktuBayar){
    this.waktuBayar=waktuBayar;
    }
    
    public Pesanan getPesanan(){
    return pesanan;
    }
    
    public void updateStatus(){
    statusBayar=true;
    }
    
    public void setCustomer(Customer customer){
    this.customer=customer;
    }
    
    
    public int getHarga(){
    return totalBayar;
    }
    
    public boolean getStatus(){
    return statusBayar;
    }
    
    public LocalDateTime getDateCreated(){
    return waktuDiciptakan;
    }
    
    public LocalDateTime getDatePaid(){
    return waktuBayar;
    }
    
}
