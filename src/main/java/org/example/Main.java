package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.getTransaction();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Menu : ");
            System.out.println("1/ Créer les produits");
            System.out.println("2/ Afficher le produit avec l'id 2");
            System.out.println("3/ Supprimer le produit avec l'id 3");
            System.out.println("4/ Modifier le produit avec l'id 1");
            System.out.println("-------------------");
            int entry = sc.nextInt();
            switch (entry) {
                case 1:
                    Test.createProducts(transaction, session);
                    break;
                case 2:
                    Test.displayProduct2(session);
                    break;
                case 3:
                    Test.deleteProduct3(transaction, session);
                    break;
                case 4:
                    Test.updateProduct1(transaction, session);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }

        } while (true);
    }
}