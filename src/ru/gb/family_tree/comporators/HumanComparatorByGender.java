package ru.gb.family_tree.comporators;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByGender implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
