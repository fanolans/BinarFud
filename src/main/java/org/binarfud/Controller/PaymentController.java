package org.binarfud.Controller;

import org.binarfud.Model.MenuModel;
import org.binarfud.View.MenuView;

import java.util.ArrayList;

import static org.binarfud.Controller.InputController.pressAnyKey;
import static org.binarfud.Controller.InputController.validateInput;
import static org.binarfud.Controller.MenuController.*;
import static org.binarfud.Controller.ReceiptController.printReceipt;

public class PaymentController {
    public static void paymentOrder(){
        int totalAmount = totalAmountMenu();
        int totalPrice = totalPriceMenu();

        ArrayList<MenuModel> orderMenu = new ArrayList<>();

        listMenu.forEach((k, m) -> {
            if (m.getAmount() > 0) {
                orderMenu.add(m);
            }});
        MenuView.paymentView(orderMenu, totalAmount, totalPrice);

        while(true){
            try{
                input = validateInput(0, 2);
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (input == 1){
            if (totalAmount == 0){
                MenuView.noOrderView();
                pressAnyKey();
                menuController();
            }else{
                System.out.println("Mencetak Struk!");
                printReceipt(orderMenu, totalAmount, totalPrice);
            }
        }else if(input == 2){
            menuController();
        }
    }
}
