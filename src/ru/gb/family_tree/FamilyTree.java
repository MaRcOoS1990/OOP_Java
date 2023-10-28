package ru.gb.family_tree;

import java.util.*;

public class FamilyTree {
    private final List< Human > FamilyList;
    private int id = 1;
    public FamilyTree() {
        FamilyList = new ArrayList<>();
    }

    /**
     * Добавление человека в FamilyList с проверкой
     */
    public void addHuman(Human human) {
        human.setId(id++);
        if (!FamilyList.contains(human)) FamilyList.add(human);
    }

    /**
     * Вывод в строках всех членов семьи с их датами, родителями, детьми, возрастом, полом и ID, полученная при переборе элементов в FamilyList
     */
    public String AllTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("All family members :\n").append("- - ".repeat(30)).append("\n");
        for (Human member: FamilyList) {
            sb.append(member.getId());
            sb.append(member.getFullName());
            sb.append("; ");
            sb.append("Day of Birth: ").append(member.getDayOfBirth()).append("; ");

            if(member.getDayOfDeath()!=null) {
                sb.append("Day of Death : ");
                sb.append(member.getAge());
                sb.append("; ");
            }
            else {
                sb.append("Aga: ");
                sb.append(member.getAge());
                sb.append(" years; ");
            }
            sb.append(member.getParents().replace("{", "").replace("}", ""));
            sb.append("; ");
            sb.append(member.getPartner());
            sb.append("; ");
            sb.append(member.getChildren().replace("[", " ").replace("]", " ").strip()).append("\n");
            sb.append("- - ".repeat(30));
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Поиск и вывод в строку Данных о человеке по запросу "name", которое может содержаться в имени или фамилии
     */
    public String SearchByNameSurname (String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Search results: \n");
        for (Human member: FamilyList) {
            if(member.getName().contains(name)|| member.getLastname().contains(name)){
                sb.append(member.getId());
                sb.append(member.getFullName());
                sb.append("; ");
                sb.append(member.getParents().replace("{", "").replace("}", ""));
                sb.append("; ");
                sb.append(member.getChildren().replace("[", "").replace("]", ""));
                sb.append("; ");
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}