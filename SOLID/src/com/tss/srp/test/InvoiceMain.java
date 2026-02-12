package com.tss.srp.test;

import com.tss.srp.model.PrintInvoice;
import com.tss.srp.model.Invoice;
import com.tss.srp.model.TaxCalculate;

public class InvoiceMain {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1, "This is Invoice", 200.0, 2);
        TaxCalculate taxCalculate = new TaxCalculate(invoice);
        PrintInvoice printInvoice = new PrintInvoice(taxCalculate);

        printInvoice.print();
    }
}
