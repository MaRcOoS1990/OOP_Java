package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public interface TreeItem<E> extends Comparable<E>, Serializable {
    String getAge();
    String getId();

    String getName();
    String getLastname();
    String getFullName();
    LocalDate getDayOfBirth();
    LocalDate getDayOfDeath();
    String getParents();
    void setParent(E human);

    void setPartner(E human);
    Gender getGender();
    String getChildren();
    String getPartner();
    void setId(int id);
    void addHuman();




}
