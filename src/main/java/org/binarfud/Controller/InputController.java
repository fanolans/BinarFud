package org.binarfud.Controller;

import java.util.List;
import java.util.Scanner;

public class InputController {
    static int input;

    public static int inputUser(){
        int inputChoice;
        try{
            System.out.print("=> ");
            Scanner input = new Scanner (System.in);
            inputChoice = input.nextInt();
            return inputChoice;
        }
        catch(Exception e){
            throw new IllegalArgumentException("Harus input angka!");
        }
    }

    public static int validateInput(List<Integer> params){
        input = inputUser();
        if (params.stream().anyMatch(x -> x == input)){
            return input;
        }
        throw new IllegalArgumentException("Pilihan tidak valid!");
    }

    public static int validateInput(int low, int high){
        input = inputUser();
        if (input >= low && input <= high){
            return input;
        }
        throw new IllegalArgumentException("Pilihan tidak valid!");
    }

    public static int validateInput(boolean positiveOrNegative, int start){
        input = inputUser();
        if (positiveOrNegative){
            if (input >= start){
                return input;
            }
        }else{
            if (input <= start){
                return input;
            }
        }
        throw new IllegalArgumentException("Pilihan tidak valid!");
    }

    public static void pressAnyKey(){
        System.out.println("Tekan tombol apapun untuk lanjut...");
        Scanner enter = new Scanner(System.in);
        enter.nextLine();
    }
}
