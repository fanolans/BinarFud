package org.binarfud.Controller;

import org.binarfud.Model.MenuModel;

import java.util.*;

import static org.binarfud.View.MenuView.*;

public class MenuController {
    static int input;
    static String line = "==========================";
    public static Map<Integer, MenuModel> listMenu = new HashMap<>();
    static ArrayList<Integer> params = new ArrayList<>();

    public static void insertMenu(){
        listMenu.put(1, new MenuModel(1,"Nasi Goreng", 15000));
        listMenu.put(2, new MenuModel(2,"Mie Goreng", 13000));
        listMenu.put(3, new MenuModel(3,"Nasi + Ayam", 18000));
        listMenu.put(4, new MenuModel(4,"Es Teh Manis", 3000));
        listMenu.put(5, new MenuModel(5,"Es Jeruk", 5000));
    }

    public static int totalAmountMenu(){
        return listMenu
                .entrySet()
                .stream()
                .reduce(0, (total, m) -> total + m.getValue().getAmount(), Integer::sum);
    }

    public static int totalPriceMenu(){
        return listMenu
                .entrySet()
                .stream()
                .reduce(0, (total, m) -> total + m.getValue().getTotalPrice(), Integer::sum);
    }

    public static void addQtyMenu(int id){
        MenuModel menu = listMenu.get(id);
        addMenuView(menu);

        // validate input
        while(true){
            try{
                input = InputController.validateInput(true, 0);
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if (input >= 1){
            menu.setAmount(input);
        }
        menuController();
    }

    public static void menuController(){
        insertMenu();
        mainMenuView(listMenu);

        // validate input
        params.clear();
        params = new ArrayList<>(listMenu.keySet());
        params.add(99);
        params.add(0);
        while (true) {
            try {
                input = InputController.validateInput(params);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (input > 0  && input <= listMenu.size()){
            addQtyMenu(input);
        }else if (input == 99){
            PaymentController.paymentOrder();
        }
    }
}
