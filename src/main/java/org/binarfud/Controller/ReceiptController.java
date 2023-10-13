package org.binarfud.Controller;

import org.binarfud.Model.MenuModel;

import java.io.PrintWriter;
import java.util.List;

import static org.binarfud.Controller.MenuController.line;

public class ReceiptController {

    public static void printReceipt(List<MenuModel> pesanan, int totalAmount, int totalPrice){
        try(PrintWriter receipt = new PrintWriter("receipt.txt")){
            receipt.println(line);
            receipt.println("BinarFud");
            receipt.println(line);
            receipt.println();
            receipt.println("Terima Kasih sudah memesan");
            receipt.println("di BinarFud");
            receipt.println();
            receipt.println("Dibawah ini adalah pesanan anda");
            receipt.println();
            pesanan.forEach(m -> {
                int price = m.getTotalPrice();
                receipt.printf("%-15s %d %,10d", m.getName(), m.getAmount(), price);
                receipt.println();
            });
            receipt.println("-------------------------- +");
            receipt.printf("%-15s %d %,10d", "Total", totalAmount, totalPrice);
            receipt.println();
            receipt.println("Pembayaran : BinarCash");
            receipt.println();
            receipt.println(line);
            receipt.println("Simpan struk ini sebagai");
            receipt.println("bukti pembayaran");
            receipt.println(line);
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
