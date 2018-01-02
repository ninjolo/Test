/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.aifa.gov;

import com.github.javafaker.Faker;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author andrea
 */
public class FakerTester {

    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));

        for (int i = 0; i < 10000; i++) {
            String firstName = faker.name().firstName(); // Emory
            System.out.println("nome: " + firstName);
            Date data = faker.date().birthday();
            System.out.println("Data di nascita: "+data);
            String lastName = faker.name().lastName(); // Barton
            System.out.println("cognome: " + lastName);
            String city = faker.address().city();
            System.out.println("città: " + city);
            String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
            System.out.println("indirizzo: " + streetAddress);
            String favRead = faker.book().title();
            System.out.println("libro preferito: "+favRead);
            System.out.println("Storia preferita: "+faker.chuckNorris().fact());
            System.out.println("--------------");
        }

    }
}
