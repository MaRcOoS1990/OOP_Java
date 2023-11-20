package ru.gb.family_tree.comporators;

import ru.gb.family_tree.family_tree.TreeItem;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByGender<T extends TreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getGender().compareTo(o2.getGender());
    }
}
