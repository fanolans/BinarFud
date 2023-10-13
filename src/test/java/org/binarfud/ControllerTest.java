package org.binarfud;

import org.binarfud.Controller.InputController;
import org.binarfud.Controller.MenuController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerTest {
    ArrayList<Integer> validate = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8));

    @BeforeEach
      void starter(){
        MenuController.insertMenu();
        MenuController.listMenu.get(1).setAmount(3);
        MenuController.listMenu.get(2).setAmount(4);
        MenuController.listMenu.get(3).setAmount(5);
        MenuController.listMenu.get(4).setAmount(7);
        MenuController.listMenu.get(5).setAmount(9);
    }

    @Test
    void countTotalAmount() {
        assertEquals(38, MenuController.totalAmountMenu());
    }

    @Test
    void countTotalPrice() {
        assertEquals(353000, MenuController.totalPriceMenu());
    }

    @Test
    void inputInt() {
        provideInput("4");
        assertEquals(4, InputController.inputUser());
    }

    @Test
    void inputIntError() {
        provideInput("using string");
        assertThrows(IllegalArgumentException.class, InputController::inputUser);
    }

    @Test
    public void validateInputArray() {
        provideInput("1");
        assertEquals(1, InputController.validateInput(validate));
    }

    @Test
    public void validateInputArray1() {
        provideInput("5");
        assertEquals(5, InputController.validateInput(validate));
    }

    @Test
    void validateInputArray2() {
        provideInput("6");
        assertThrows(IllegalArgumentException.class, () -> InputController.validateInput(validate));
    }

    @Test
    void validateInputArray3() {
        provideInput("8");
        assertEquals(8, InputController.validateInput(validate));
    }

    @Test
    void ValidateInputHighLow() {
        provideInput("0");
        assertThrows(IllegalArgumentException.class, () -> InputController.validateInput(1, 7));
    }

    @Test
    void ValidateInputHighLow1() {
        provideInput("1");
        assertEquals(1, InputController.validateInput(1, 7));
    }

    @Test
    void ValidateInputHighLow2() {
        provideInput("3");
        assertEquals(3, InputController.validateInput(1, 7));
    }

    @Test
    void ValidateInputHighLow3() {
        provideInput("7");
        assertEquals(7, InputController.validateInput(1, 7));
    }

    @Test
    void ValidateInputHighLow4() {
        provideInput("8");
        assertThrows(IllegalArgumentException.class, () -> InputController.validateInput(1, 7));
    }

    @Test
    void testValidateInputPositive() {
        provideInput("-3");
        assertThrows(IllegalArgumentException.class, () -> InputController.validateInput(true, -2));
    }

    @Test
    void testValidateInputPositive2() {
        provideInput("-2");
        assertEquals(-2, InputController.validateInput(true, -2));
    }

    @Test
    void testValidateInputPositive3() {
        provideInput("4");
        assertEquals(4, InputController.validateInput(true, -2));
    }

    @Test
    void testValidateInputNegative() {
        provideInput("1");
        assertThrows(IllegalArgumentException.class, () -> InputController.validateInput(false, 0));
    }

    @Test
    void testValidateInputNegative2() {
        provideInput("0");
        assertEquals(0, InputController.validateInput(false, 0));
    }

    @Test
    void testValidateInputNegative3() {
        provideInput("-4");
        assertEquals(-4, InputController.validateInput(false, 0));
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
