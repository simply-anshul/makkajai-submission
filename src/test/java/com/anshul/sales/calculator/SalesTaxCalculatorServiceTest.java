package com.anshul.sales.calculator;

import com.anshul.sales.calculator.model.Item;
import com.anshul.sales.calculator.rule.SalesTaxCalculator;
import com.anshul.sales.calculator.service.SalesTaxCalculatorService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesTaxCalculatorServiceTest {

    @Test
    public void testTaxCalculator() {
        SalesTaxCalculator stc = new SalesTaxCalculatorService();
        List<Item> itemList = new ArrayList<>();

//      INPUT 01 From the Assignment
        itemList.add(new Item("book", 1, 12.49, true,false));
        itemList.add(new Item("music CD", 1,14.99, false, false));
        itemList.add(new Item("chocolate bar", 1,0.85,  true, false));
        String expectedResultString01  = "book: 12.49\n" +
                "music CD: 16.49\n" +
                "chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";
        assertEquals(expectedResultString01, stc.taxCalculator(itemList));

//      INPUT 02 FROM THE ASSIGNMENT
        itemList = new ArrayList<>();
        itemList.add(new Item("imported box of chocolates", 1,10.00, true, true));
        itemList.add(new Item("imported bottle of perfume", 1, 47.50, false, true));

        String expectedResultString02  = "imported box of chocolates: 10.50\n" +
                "imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";
        assertEquals(expectedResultString02, stc.taxCalculator(itemList));

//      INPUT 03 FROM THE ASSIGNMENT
        itemList = new ArrayList<>();
        itemList.add(new Item("imported bottle of perfume", 1, 27.99, false, true));
        itemList.add(new Item("bottle of perfume", 1, 18.99, false, false));
        itemList.add(new Item("packet of headache pills", 1, 9.75, true, false));
        itemList.add(new Item("imported box of chocolates", 1, 11.25, true, true));

        String expectedResultString03  = "imported bottle of perfume: 32.19\n" +
                "bottle of perfume: 20.89\n" +
                "packet of headache pills: 9.75\n" +
                "imported box of chocolates: 11.85\n" +
                "Sales Taxes: 6.70\n" +
                "Total: 74.68";
        assertEquals(expectedResultString03, stc.taxCalculator(itemList));

    }


}
