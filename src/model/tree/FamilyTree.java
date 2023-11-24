package model.tree;
import model.human.comparators.ComparatorByAge;
import model.human.comparators.ComparatorById;
import model.human.comparators.ComparatorByLastname;
import model.human.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyTreeItem<T> > implements Serializable, Iterable< T > {
    private int id = 1;
    private List< T > familyList;
    public FamilyTree() {
//        familyList = new ArrayList<>();
        this(new ArrayList<>());
    }

    public FamilyTree(List< T> familyList) {
        this.familyList=familyList;
    }


    public void addHuman(T human) {
        human.setId(id++);
        if (!familyList.contains(human)) familyList.add(human);

    }


    public String allTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("All family tree\n").append("-".repeat(128)).append("\n");
        for (T member: familyList) {
            sb.append(member.getId());
            sb.append(member.getFullName());
            sb.append("; ");
            sb.append("Day of birth: ").append(member.getDayOfBirth()).append("; ");

            if(member.getDayOfDeath()!=null) {
                sb.append("Day of death: ");
                sb.append(member.getDayOfDeath());
                sb.append("; ");
                sb.append("Age: ");
                sb.append(member.getAge());
                sb.append(" age; ");
            }
            else {
                sb.append("Age: ");
                sb.append(member.getAge());
                sb.append(" age; ");
            }
            sb.append(member.getParents().replace("{", "").replace("}", ""));
            sb.append("; ");
            sb.append(member.getSpouse());
            sb.append("; ");
            sb.append(member.getChildren().replace("[", " ").replace("]", " ").strip()).append("\n");
            sb.append("-".repeat(80));
            sb.append("\n");
        }
        return sb.toString();
    }


    public String SearchByNameSurname (String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Result: \n");
        for (T member: familyList) {
            if(member.getName().contains(name)|| member.getLastname().contains(name)){
                sb.append(member.getId());
                sb.append(member.getFullName());
                sb.append("; ");
                sb.append(member.getDayOfBirth());
                sb.append("; ");
                sb.append(member.getAge());
                sb.append("; ");
                sb.append(member.getParents().replace("{", "").replace("}", ""));
                sb.append("; ");
                sb.append(member.getSpouse());
                sb.append("; ");
                sb.append(member.getChildren().replace("[", "").replace("]", ""));
                sb.append("; ");
                sb.append("\n");
            }
        }
        return sb.toString();
    }



    @Override
    public Iterator< T > iterator() {
        return new HumanIterator<>(familyList);
    }

    public void sortByName(){
        System.out.println("Sort by name\n");
        familyList.sort(new ComparatorByName<>());
    }

    public void sortByLastname(){
        System.out.println("Sort by lastname\n");
        familyList.sort(new ComparatorByLastname<>());
    }

    public void sortByAge(){
        System.out.println("Sort by age\n");
        familyList.sort(new ComparatorByAge<>());
    }

    public T searchById(int id){
        StringBuilder sb = new StringBuilder();
        StringBuilder sbId = new StringBuilder();
        String idS = sbId.append(id).toString();
        for (T member: familyList) {
            if(member.getId().contains(idS)){
                return member;
            }
        }
        return null;
    }

    public void sortById() {
        System.out.println("Sort by ID\n");
        familyList.sort(new ComparatorById<>());
    }
}
