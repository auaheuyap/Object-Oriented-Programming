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
public class NewSingleton {
    
    private NewSingleton() {
    }
    
    public static NewSingleton getInstance() {
        return NewSingletonHolder.INSTANCE;
    }
    
    private static class NewSingletonHolder {

        private static final NewSingleton INSTANCE = new NewSingleton();
    }
    
    public void print(){
        System.out.println("###Sistem Informasi Katering###");
        System.out.println("M. NOFRIZAN (12/329878/PA/14383) ");
        System.out.println("KARTIKA VIDYA RIAN P (12/331020/PA/14425)");
        System.out.println("RAFINKANISA W (12/330832/PA/14393)");
        System.out.println("FITRI HASANAH AMHAR (12/334729/PA/14961)");
        System.out.println("MULYAHADI J.(12/334638/PA/14871)");
        System.out.println();
    }
}
