package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.spring.kodillahibernate.KodillaHibernateApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = KodillaHibernateApplication.class)
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Product product1 = new Product("Product A");
        Product product2 = new Product("Product B");

        productDao.save(product1);
        productDao.save(product2);

        Item item1 = new Item(product1, new BigDecimal("100.00"), 2, new BigDecimal("200.00"));
        Item item2 = new Item(product1, new BigDecimal("50.00"), 3, new BigDecimal("150.00"));

        Invoice invoice = new Invoice("INV/2025/01");
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        Invoice savedInvoice = invoiceDao.save(invoice);
        int id = savedInvoice.getId();

        //Then

        assertTrue(invoiceDao.findById(id).isPresent());
        assertEquals(2, savedInvoice.getItems().size());

        // CleanUp
        //invoiceDao.deleteById(id);
    }
}
