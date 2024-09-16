package com.anshul.sales.calculator.rule;

import com.anshul.sales.calculator.model.Item;

import java.util.List;

public interface SalesTaxCalculator {

    public String taxCalculator(List<Item> items);

}
