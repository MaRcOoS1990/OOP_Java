package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;

import java.time.LocalDate;

public interface TreeItem<E> extends Comparable<E> {
    String getAge();
    String getId();

    String getName();
    String getLastname();
    String getFullName();
    LocalDate getDayOfBirth();
    LocalDate getDayOfDeath();
    String getParents();
    void setParent(E e);

    String toString();
    void setPartner(E e);
    Gender getGender();
    String getChildren();
    String getPartner();
    void setId(int id);
    void addHuman();




}
