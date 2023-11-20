package ru.gb.family_tree.comporators;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.family_tree.TreeItem;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends TreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
