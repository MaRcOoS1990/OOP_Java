package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable {
    private  List<Human> FamilyList;
    private int id = 1;
    public FamilyTree() {
        FamilyList = new ArrayList<>();
    }


    public void addHuman(Human human) {
        human.setId(id++);
        if (!FamilyList.contains(human)) FamilyList.add(human);
    }


    public String allTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("All family members :\n").append("- - ".repeat(30)).append("\n");
        for (Human member: FamilyList) {
            sb.append(member.getId());
            sb.append(member.getFullName());
            sb.append("; ");
            sb.append("Day of Birth: ").append(member.getDayOfBirth()).append("; ");

            if(member.getDayOfDeath()!=null) {
                sb.append("Day of Death : ");
                sb.append(member.getDayOfDeath());
                sb.append(" , ");
                sb.append(member.getAge());
                sb.append(" years; ");
            }
            else {
                sb.append("Age: ");
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


    public String searchByNameSurname(String name){
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