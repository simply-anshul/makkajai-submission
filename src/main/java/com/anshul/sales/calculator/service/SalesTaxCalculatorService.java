package com.anshul.sales.calculator.service;

import com.anshul.sales.calculator.model.Item;
import com.anshul.sales.calculator.rule.SalesTaxCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesTaxCalculatorService implements SalesTaxCalculator {

    private static final Double BASIC_SALES_TAX_RATE = 0.1;
    private static final Double IMPORT_DUTY_RATE = 0.05;

    @Override
    public String taxCalculator(List<Item> items) {
        StringBuilder message = new StringBuilder();

        Double totalSalesTax = 0.0;
        Double totalCost = 0.0;

        for (Item item : items) {
            Double price = item.getPrice();
            Double taxRate = 0.0;

            if (!item.getIsNonImportExemptedItem()) {
                taxRate += BASIC_SALES_TAX_RATE;
            }
            if (item.getIsImported()) {
                taxRate += IMPORT_DUTY_RATE;
            }

            double tax = calculateTax(price, taxRate);
            price += tax;

            totalSalesTax += tax;
            totalCost += price;

            message.append(item.getItemName())
                    .append(": ")
                    .append(String.format("%.2f", price))
                    .append("\n");
        }
        message.append("Sales Taxes: ")
                .append(String.format("%.2f", totalSalesTax))
                .append("\n");
        message.append("Total: ")
                .append(String.format("%.2f", totalCost));
        return message.toString();
    }

    private static Double calculateTax(Double price, Double taxRate) {
        int rupee = (int) (price * 100);
        int taxRupee = (int) (rupee * taxRate);
        taxRupee = (int) Math.ceil(taxRupee / 5.0) * 5;
        return taxRupee / 100.0;
    }
}
