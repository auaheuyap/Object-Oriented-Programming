/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cateringpbo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ACER
 */

public class CateringPBO {
    static Menu [] menu = new Menu [] {new Menu("Menu1",10000),new Menu("Menu2",20000),new Menu("Menu3",30000),new Menu("Menu4",40000)};
    static List <Menu> list = Arrays.asList(menu);
    static LinkedList <Menu> menuList = new LinkedList <Menu>(list);
//    static LinkedList <Pesanan> globalPesananList = new LinkedList <Pesanan>();
//    static LinkedList <Pengiriman> globalPengirimanList = new LinkedList <Pengiriman>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//    NewSingleton namaTim = NewSingleton.getInstance();
//    namaTim.print();

///////////////////////////////////////TES PESANAN///////////////////////////////////////////////
        Customer a = new Customer("hadi","080989999","jakal");
        a.lihatMenu(menuList);
//        a.pesan(2);
//        a.getPesanan(0).hitungTotalHarga(menuList);
//        System.out.println("Total harga pesanan 0 : "+a.getPesanan(0).getHarga());
//        System.out.println();
////        a.pesan(2);
////        a.getPesanan(1).hitungTotalHarga(menuList);
////        System.out.println("Total harga pesanan 1 : "+a.getPesanan(1).getHarga());
////        System.out.println();
////////////////////////////////////////////TES PEMBAYARAN////////////////////////////////////////////        
//        System.out.println("Status Pembayaran 0 : "+a.getPembayaran(0).getStatus());
//        System.out.println("Tanggal Dibuat Pembayaran 0 : "+a.getPembayaran(0).getDateCreated());
//        System.out.println();
//        a.bayar(0);
//        System.out.println("Status Pembayaran 0 : "+a.getPembayaran(0).getStatus());
//        System.out.println("Tanggal Bayar Pembayaran 0 : "+a.getPembayaran(0).getDatePaid());
//        System.out.println();
//////////////////////////////////////////TES KOKI/////////////////////////////////////
//          Koki e = new Koki();
//          System.out.println("Status pesanan 0 : "+a.getPesanan(0).getStatus());
//          e.updateStatusPesanan(a, 0);
//          System.out.println("Status pesanan 0 : "+a.getPesanan(0).getStatus());
//          System.out.println();
//////////////////////////////////////////TES PENGIRIMAN/////////////////////////////////////
//         Kurir d = new Kurir();
//         System.out.println("Waktu Dibuat Pengiriman 0 : "+a.getPengiriman(0).getDateCreated());
//         System.out.println("Status Pengiriman 0 : "+a.getPengiriman(0).getStatus());
//         System.out.println("Jadwal Pengiriman 0 : "+a.getPengiriman(0).getSentSchedule());
//         System.out.println();
//         d.updateStatusPengiriman(a, 0);
//         System.out.println("Status Pengiriman 0 : "+a.getPengiriman(0).getStatus());
//         System.out.println("Waktu Terkirim Pengiriman 0 : "+a.getPengiriman(0).getDateSent());
//         System.out.println();
////////////////////////////////////TES ADMIN////////////////////////////////////////////          
//        Admin b = new Admin("admin","admin");
//        b.addMenu(menuList, "Menu5", 50000);
//        b.lihatMenu(menuList);
//        b.login("admin","admin");
//        b.addMenu(menuList, "Menu5", 50000);
//        b.lihatMenu(menuList);
//        b.deleteMenu(menuList, 4);
//        b.lihatMenu(menuList);
    }
    
}
