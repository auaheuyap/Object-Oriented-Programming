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
public class Pengiriman {
    private static int it=0;
    private int id;
    private  boolean statusPengiriman=false;
    private Customer customer;
    private Pesanan pesanan;
    private LocalDateTime waktuPengiriman,waktuDiciptakan,jadwalPengiriman;
    
    public Pengiriman(){
    waktuDiciptakan=LocalDateTime.now();
    jadwalPengiriman=waktuDiciptakan.plusDays(2);
    id=it;
    it++;
    }
    
    public void setCustomer(Customer customer){
    this.customer=customer;
    }
    
    public void setPesanan(Pesanan pesanan){
    this.pesanan=pesanan;
    }
    
    public void setWaktuPengiriman(LocalDateTime waktuPengiriman){
    this.waktuPengiriman=waktuPengiriman;
    }
    
    public void updateStatus(){
    statusPengiriman=true;
    }
    
    public boolean getStatus(){
    return statusPengiriman;
    }
    
    public LocalDateTime getDateSent(){
    return waktuPengiriman;
    }
    
    public LocalDateTime getSentSchedule(){
    return jadwalPengiriman;
    }
    
    public LocalDateTime getDateCreated(){
    return waktuDiciptakan;
    }
    
}
