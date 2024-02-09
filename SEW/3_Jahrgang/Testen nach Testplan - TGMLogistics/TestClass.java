import TGMLogistics.Exceptions.*;
import TGMLogistics.Helper.Address;
import TGMLogistics.Item.ClothingSize;
import TGMLogistics.Item.Item;
import TGMLogistics.Item.Shirt;
import TGMLogistics.OrderLogistics.LogisticsSystem;
import TGMLogistics.OrderLogistics.Order;
import TGMLogistics.OrderLogistics.OrderStatus;
import TGMLogistics.Store.Store;
import TGMLogistics.User.PaymentMethod;
import TGMLogistics.User.User;
import TGMLogistics.User.UserKBohaczyk;
import TGMLogistics.User.UserPrivilege;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Kacper Bohaczyk
 * @verison 01-06-2023
 */
public class TestClass {

    @Test
    @DisplayName("Test Low")
    public void testCheckPasswordStrength_Weak() {
        String password = "1234567";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(0, strength);
    }

    @Test
    @DisplayName("Test Mid")
    public void testCheckPasswordStrength_Moderate() {
        String password = "SecurePwd123";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(2, strength);
    }

    @Test
    @DisplayName("Test High")
    public void testCheckPasswordStrength_Strong() {
        String password = "SecurePwd!202!äö!3";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(5, strength);
    }

    @Test
    public void testCheckPasswordStrength_DuplicateSpecialCharacters() {
        String password = "SecurePass!!";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(1, strength);
    }

    @Test
    @DisplayName("Test Lower Case characters")
    public void testLowerCase() {
        String password = "securepass";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(1, strength);
    }

    @Test
    @DisplayName("Test Upper Case characters")
    public void testUpperCase() {
        String password = "SECUREPASS";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(1, strength);
    }

    @Test
    @DisplayName("Test Laenge gibt bei einem Passwort unter 8 0 zurück")
    public void testLaenge() {
        String password = "se12'sd";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(0, strength);
    }


    @Test
    @DisplayName("Test Laenge zu lang")
    public void testLaenge2() {
        String password = "1234567890123";
        int strength = UserKBohaczyk.checkPasswordStrength(password);
        assertEquals(2, strength);
    }
}



