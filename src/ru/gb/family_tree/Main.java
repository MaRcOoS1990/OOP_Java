package ru.gb.family_tree;

import java.time.*;
public class Main {
    public static void main(String[] args) {
        FamilyTree MyTree = new FamilyTree();
        Human human1 = new Human(MyTree, "Шопалев", "Сергей", LocalDate.of(1988, 4, 7), Gender.Male);
        Human human2 = new Human(MyTree, "Селиванова", "Ольга", LocalDate.of(1987, 3, 11), Gender.Female);
        Human human3 = new Human(MyTree, "Шопалев", "Юрий", LocalDate.of(1940, 6, 15), Gender.Male);
        Human human4 = new Human(MyTree, "Деткова", "Люба", LocalDate.of(1946, 3, 22), Gender.Female);
        Human human5 = new Human(MyTree, "Селиванов", "Игорь", LocalDate.of(1958, 2, 13), Gender.Male);
        Human human6 = new Human(MyTree, "Селиванова", "Наталья", LocalDate.of(1980, 6, 18), Gender.Female);
        Human human7 = new Human(MyTree, "Детков", "Федор", LocalDate.of(1926, 1, 19), Gender.Male);
        Human human8 = new Human(MyTree, "Ильченко", "Анастасия", LocalDate.of(1924, 2, 13), Gender.Female);
        Human human9 = new Human(MyTree, "Деткова", "Эльвира", LocalDate.of(1957, 8, 21), Gender.Female);
        Human human10 = new Human(MyTree, "Шопалева", "Екатерина", LocalDate.of(2012, 4, 2), Gender.Female);
        Human human11 = new Human(MyTree, "Купринова", "Людмила", LocalDate.of(1941, 1, 15), Gender.Female);

        human1.setPartner(human2);
        human3.setPartner(human4);
        human5.setPartner(human6);
        human7.setPartner(human8);

        human1.setChild(human10);
        human2.setChild(human10);
        human3.setChild(human1);
        human4.setChild(human1);
        human5.setChild(human2);
        human6.setChild(human2);
        human7.setChild(human9);
        human8.setChild(human9);
        human7.setChild(human4);
        human8.setChild(human4);
        human11.setChild(human6);

        human4.setDayOfDeath(LocalDate.of(2017, 7, 7));
        human5.setDayOfDeath(LocalDate.of(2011, 1, 11));
        human7.setDayOfDeath(LocalDate.of(2007, 7, 17));
        human8.setDayOfDeath(LocalDate.of(2010, 10, 10));

        /**
         * Вывод всех членов семьи
         */
        System.out.println("-*-*".repeat(30));
        System.out.println(MyTree.AllTree());

        System.out.println("-*-*".repeat(30));

        /**
         * Поиск по слову (имени)
         */
        String str = MyTree.SearchByNameSurname("Эльвира");
        System.out.println(str);
        System.out.println("\n");

        /**
         * Поиск по слову (фамилии)
         */
        String str1 = MyTree.SearchByNameSurname("Шопалев");
        System.out.println(str1);
        System.out.println("\n");
    }
}
