/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

//import static cateringpbo.CateringPBO.globalPesananList;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Customer {
private static int it=0;
private int id;
private String nama,kontak,alamat;
private List <Pesanan> pesananList = new LinkedList <Pesanan>();
private List <Pembayaran> pembayaranList = new LinkedList <Pembayaran>();
private List <Pengiriman> pengirimanList = new LinkedList <Pengiriman>();
private List <IdJumlahMenu> idJumlahMenuList = new LinkedList <IdJumlahMenu>();
private IdJumlahMenu idJumlahMenu;
private Pengiriman pengiriman;
private Pembayaran pembayaran;
private Pesanan pesanan;

public Customer(String nama, String kontak, String alamat){
this.nama=nama;
this.kontak=kontak;
this.alamat=alamat;
id=it;
it++;
}

public Pengiriman getPengiriman(int id){
return pengirimanList.get(id);
}

public Pesanan getPesanan(int id){
return pesananList.get(id);
}

public Pembayaran getPembayaran(int id){
return pembayaranList.get(id);
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

public void pesan(int jumlahItem){ 
pesanan=new Pesanan();
if(pesanan.getKuotaTersisa()<=pesanan.kuotaPesananPerHari){
pesanan.setCustomer(this);

int idMenu,jumlahMenu;
Scanner scanner = new Scanner(System.in);

for(int i=0;i<jumlahItem;i++){
System.out.print("input id Menu : ");
idMenu=scanner.nextInt();
System.out.print("input jumlah Menu : ");
jumlahMenu=scanner.nextInt();
pesanan.addMenu(idMenu, jumlahMenu);
System.out.println();
}

pesananList.add(pesanan);
//globalPesananList.add(pesanan);


pembayaran = new Pembayaran(pesanan);
pembayaran.setCustomer(this);
pembayaranList.add(pembayaran);
}
else System.out.println("Proses pesan gagal: kuota maksimal pesanan perhari terpenuhi");
}

public void pesanIterator(int jumlahItem){
pesanan=new Pesanan();
if(pesanan.getKuotaTersisa()<=pesanan.kuotaPesananPerHari){
pesanan.setCustomer(this);

int idMenu,jumlahMenu;
Scanner scanner = new Scanner(System.in);

for(int i=0;i<jumlahItem;i++){
idMenu=scanner.nextInt();
jumlahMenu=scanner.nextInt();
pesanan.addMenuIterator(idMenu, jumlahMenu);
}

pesananList.add(pesanan);
//globalPesananList.add(pesanan);


pembayaran = new Pembayaran(pesanan);
pembayaran.setCustomer(this);
pembayaranList.add(pembayaran);
}
else System.out.println("Proses pesan gagal: kuota maksimal pesanan perhari terpenuhi");
}

public void bayar(int id){
pembayaranList.get(id).updateStatus();
pembayaranList.get(id).setWaktuBayar(LocalDateTime.now());


pengiriman=new Pengiriman();
pengiriman.setCustomer(this);
pengiriman.setPesanan(pembayaranList.get(id).getPesanan());
pengirimanList.add(pengiriman);
}

public int getID(){
return id;
}

public String getNama(){
return nama;
}

public String getKontak(){
return kontak;
}

public String getAlamat(){
return alamat;
}

}
