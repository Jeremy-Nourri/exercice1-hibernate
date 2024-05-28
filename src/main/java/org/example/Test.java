package org.example;

import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Test {

    public static void displayProduct2(Session session) {
        Product productFound = session.load(Product.class, 2);
        System.out.println(productFound);
    }
    public static void deleteProduct3(Transaction transaction, Session session) {
        transaction.begin();
        Product productToDelete = session.load(Product.class, 3);
        session.delete(productToDelete);
        transaction.commit();
    }

    public static void updateProduct1(Transaction transaction, Session session){
        transaction.begin();
        Product productToUpdate = session.load(Product.class, 1);
        productToUpdate.setDateAchat(LocalDate.parse("2024-05-01"));
        productToUpdate.setStock(9);
        productToUpdate.setPrix(200.0);
        productToUpdate.setReference("nike20240501");
        transaction.commit();
    }
    public static void createProducts(Transaction transaction, Session session) {

        transaction.begin();

        Product product1 = Product.builder()
                .dateAchat(LocalDate.parse("2023-01-01"))
                .stock(10)
                .marque("nike")
                .reference("nike01122023")
                .prix(120.0)
                .build();

        Product product2 = Product.builder()
                .dateAchat(LocalDate.parse("2023-01-01"))
                .stock(10)
                .marque("puma")
                .reference("puma01012024")
                .prix(90.0)
                .build();

        Product product3 = Product.builder()
                .dateAchat(LocalDate.parse("2023-01-01"))
                .stock(10)
                .marque("jordan")
                .reference("jordan01022024")
                .prix(140.0)
                .build();

        Product product4 = Product.builder()
                .dateAchat(LocalDate.parse("2023-01-01"))
                .stock(10)
                .marque("new balance")
                .reference("newbalance01032024")
                .prix(130.0)
                .build();

        Product product5 = Product.builder()
                .dateAchat(LocalDate.parse("2023-01-01"))
                .stock(10)
                .marque("addidas")
                .reference("addidas01032024")
                .prix(140.0)
                .build();

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);

        transaction.commit();
    }
}
