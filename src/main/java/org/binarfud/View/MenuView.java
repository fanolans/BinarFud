package org.binarfud.View;

import org.binarfud.Model.MenuModel;

import java.util.List;
import java.util.Map;

public class MenuView {
    private static final String line= "==========================";
    public static void addMenuView(MenuModel menu){
        System.out.println(line);
        System.out.println("Berapa pesanan anda");
        System.out.println(line);
        System.out.println();
        System.out.printf("%d. %-12s | %,d", menu.getId(), menu.getName(), menu.getPrice());
        System.out.println();
        System.out.println("(input 0 untuk kembali)");
        System.out.println();
        System.out.println();
    }

    public static void mainMenuView(Map<Integer, MenuModel> listMenu){
        System.out.println(line);
        System.out.println("Selamat datang di BinarFud");
        System.out.println(line);
        System.out.println();
        System.out.println("Silahkan pilih makanan : ");
        listMenu.forEach((k, menu) -> {
            System.out.printf("%d. %-12s | %,d", menu.getId(), menu.getName(), menu.getPrice());
            System.out.println();
        });
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        System.out.println();
    }

    public static void paymentView(List<MenuModel> pesanan, int totalAmount, int totalPrice){
        System.out.println(line);
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println(line);
        System.out.println();
        pesanan.forEach(menu -> {
            int price = menu.getTotalPrice();
            System.out.printf("%-15s %d %,10d", menu.getName(), menu.getAmount(), price);
            System.out.println();
        });
        System.out.println("-------------------------- +");
        System.out.printf("%-15s %d %,10d", "Total", totalAmount, totalPrice);
        System.out.println();
        System.out.println();
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. keluar aplikasi");
        System.out.println();
    }

    public static void noOrderView(){
        System.out.println();
        System.out.println("Anda tidak memesan apa-apa,");
        System.out.println("silahkan pesan sesuatu");
        System.out.println();
    }

}
