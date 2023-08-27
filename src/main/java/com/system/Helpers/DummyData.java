package com.system.Enums;
import com.system.Models.*;

public class DummyData {
    public static void addDummyData() {
        Frames frames1 = new Frames(1, 200);
        Frames frames2 = new Frames(2, 400);
        Frames frames3 = new Frames(3, 300);

        Client client1 = new Client("Anna", "Nowak", 123456789);
        Client client2 = new Client("Maria", "Nowak", 987654321,
                "1234567890", "Akacjowa 2/3, Warszawa");
        Client client3 = new Client("Piotr", "Kowalski", 111222333);

        Owner owner = new Owner(1234, "A", "B");
        Seller seller = new Seller("s111", "Janusz", "Komin", 456723812, 5000,
                "januszk@email.com");
        Optician optician1 = new Optician("o111", "Mariola", "Kot", 456723812, 5000,
                "januszk@email.com");


        Doctor doctor1 = new Doctor("d111", "Anne", "Shirley", 256387156, 4000,
                "anneshirley@email.com", 1111);
        Doctor doctor2 = new Doctor("d222", "Marilla", "Cuthbert", 409176245, 3600,
                "marillacuthbert@email.com", 2222);
        Doctor doctor3 = new Doctor("d333", "Diana", "Barry", 901728516, 1000,
                "dianabarry@email.com", 3333);

        Prescription prescription1 = new Prescription(1, "some details", doctor1);
        Prescription prescription2 = new Prescription(2, "left eye -0,5, right eye -1", doctor1);
        Prescription prescription3 = new Prescription(3, "some details", doctor1);
        Prescription prescription4 = new Prescription(4, "some details", doctor2);
        Prescription prescription5 = new Prescription(5, "some details", doctor2);
        Prescription prescription6 = new Prescription(6, "some details", doctor2);
        Prescription prescription7 = new Prescription(7, "some details", doctor2);
        Prescription prescription8 = new Prescription(8, "blue glasses to work with computer", doctor3);

        Order order1 = new Order( new Glasses(frames1, new Lenses(LensesType.CLEAR, 300, 0.5, 0.5)),
                client1, prescription1);
        Order order2 = new Order(new Glasses(frames3, new Lenses(LensesType.SUN, 300, 0, 2.5)),
                client1, prescription3);
        Order order3 = new Order(new Glasses(frames1, new Lenses(LensesType.BLUE, 300, 0, 0)), client3);
    }
}
