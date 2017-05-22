/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author ACER
 */
public class Pesanan {
    public static final int kuotaPesananPerHari=50;
    private static int it=0,jumlahPesananPerHari=0;
    private boolean statusPesanan=false;
    private int totalHarga=0,indexMenu=0,id;
    private int [] idMenu= new int [100],jumlahMenu = new int [100];
    private List <IdJumlahMenu> idJumlahMenuList = new LinkedList <IdJumlahMenu>();
    private IdJumlahMenu idJumlahMenu;
    private Customer customer;
    
    
    
    public Pesanan(){
    id=it;
    it++;
    jumlahPesananPerHari++;
    }
    
    public void getMenuPesanan(LinkedList <Menu> menuList){
    for(int  i=0;i<indexMenu;i++)System.out.println(menuList.get(idMenu[i]).getID()+" "+menuList.get(idMenu[i]).getNama()+" "+jumlahMenu[i]);
    }
    
    public void getMenuPesananIterator(LinkedList <Menu> menuList){
    for(int  i=0;i<indexMenu;i++)System.out.println(menuList.get(idMenu[i]).getID()+" "+menuList.get(idMenu[i]).getNama()+" "+jumlahMenu[i]);
    }
    
    public void updateStatus(){
    statusPesanan=true;
    }
    
    public void setCustomer(Customer customer){
    this.customer=customer;
    }
    
    public Customer getCustomer(){
    return customer;
    }
    
    public void addMenuIterator(int id, int jumlah){
    idJumlahMenu = new IdJumlahMenu(id,jumlah);
    idJumlahMenuList.add(idJumlahMenu);
    }
    
    public void addMenu(int id, int jumlah){
    idMenu[indexMenu]=id;
    jumlahMenu[indexMenu]=jumlah;
    indexMenu++;
    }
    
    public void hitungTotalHarga(LinkedList <Menu> menuList){
        for(int i=0;i<indexMenu;i++){
        totalHarga+=menuList.get(idMenu[i]).getHarga()*jumlahMenu[i];
        }    
    }
    
    public void hitungTotalHargaIterator(LinkedList <Menu> menuList){
        Iterator<IdJumlahMenu> itr = idJumlahMenuList.iterator();
        while(itr.hasNext()){
        IdJumlahMenu x=itr.next();
        totalHarga+=menuList.get(x.getID()).getHarga()*x.getJumlah();
          //System.out.println(menuList.get(x.getID()).getHarga()+" "+x.getJumlah());
        }
            
    }
    
    public int getId(){
    return id;
    }
    
    public int getHarga(){
        return totalHarga;
    }
    
    public boolean getStatus(){
        return statusPesanan;
    }
    
    public int getKuotaTersisa(){
        return kuotaPesananPerHari-jumlahPesananPerHari;
    }
}
