package org.binarfud;

import org.binarfud.Model.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {
    static Map<Integer, MenuModel> listMenu = new HashMap<>();

    @Test
    void getId() {
        assertAll(
                () -> assertEquals(1, listMenu.get(1).getId()),
                () -> assertEquals(2, listMenu.get(2).getId()),
                () -> assertEquals(3, listMenu.get(3).getId())
        );

    }

    @Test
    void getName() {
        assertAll(
                () -> assertEquals("Nasi Goreng", listMenu.get(1).getName()),
                () -> assertEquals("Mie Goreng", listMenu.get(2).getName()),
                () -> assertEquals("Nasi + Ayam", listMenu.get(3).getName())
        );

    }

    @Test
    void getPrice() {
        assertAll(
                () -> assertEquals(15000, listMenu.get(1).getPrice()),
                () -> assertEquals(13000, listMenu.get(2).getPrice()),
                () -> assertEquals(18000, listMenu.get(3).getPrice())
        );
    }

    @Test
    void getAmount() {
        assertAll(
                () -> assertEquals(4, listMenu.get(1).getAmount()),
                () -> assertEquals(2, listMenu.get(2).getAmount()),
                () -> assertEquals(8, listMenu.get(3).getAmount())
        );
    }

    @Test
    void getTotalPrice() {
        assertAll(
                () -> assertEquals(60000, listMenu.get(1).getTotalPrice()),
                () -> assertEquals(26000, listMenu.get(2).getTotalPrice()),
                () -> assertEquals(144000, listMenu.get(3).getTotalPrice())
        );
    }
}
