package model.human;
import model.tree.FamilyTreeItem;

import java.time.*;
import java.util.*;

//public class Human implements Serializable, FamilyTreeItem< Human >, Comparable<Human> {
public class Human implements FamilyTreeItem< Human > {
    private int id;
    private String lastname;
    private String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private Gender gender;
    private Map< String, Human > parents;
    private List< Human > children;
    Human spouse;

    public Human(int id, String lastname, String name, LocalDate birthday, LocalDate dayOfDeath, Gender gender) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap< String, Human >();
        this.children = new ArrayList<>();
        setDayOfBirth(birthday);
        setDayOfDeath(dayOfDeath);
    }

    public Human(int id, String lastname, String name, LocalDate of, Gender gender) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap< String, Human >();
        this.children = new ArrayList< Human >();
    }

    public Human(int id, String lastname, String name, LocalDate birthday, LocalDate dayOfDeath, Gender gender, Human parent1, Human parent2) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap< String, Human >();
        this.children = new ArrayList< Human >();
        setDayOfBirth(birthday);
        setDayOfDeath(dayOfDeath);
        if (parent1 != null) {
            setParent(parent1);
        }
        if (parent2 != null) {
            setParent(parent2);
        }
    }


    //геттеры:

    public String getId() {
        return this.id + ". ";
    }


    public String getName() {
        return name;
    }


    public String getLastname() {
        return lastname;
    }


    public String getFullName() {
        return this.getLastname() + " " + this.getName();
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }


    public int getAge() {
            return Period.between(this.dayOfBirth, LocalDate.now()).getYears();
    }

    public Gender getGender() {
        return gender;
    }


    public String getParents() {
        StringBuilder sb = new StringBuilder("Parents: ");
        if (this.parents.isEmpty()) {
            sb.append("Not found");
        } else {
            sb.append(this.parents);
        }
        return sb.toString().replace("=", ": ");
    }


    public String getChildren() {
        if (this.children.isEmpty()) {
            return "Not found children";
        }
        return "Children: " + this.children;
    }


    public String getSpouse() {
        if (this.spouse == null) {
            return "Not married";
        }
        return "Spouse: " + this.spouse;
    }

    // Сетеры:

    public void setId(int id) {
        this.id = id;
    }


    public void setParner(Human partner) {
        this.spouse = partner;
        partner.spouse = this;
    }


    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }


    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }



    public void setParent(Human human) {
        if (human.getGender() == Gender.Male) {
            this.parents.put("Father",  human);
        }
        else this.parents.put("Mother ", human);
    }


    public void setChild(Human child) {
        if (!children.contains(child)) {
            this.children.add(child);
            child.setParent(this);
        }
    }


    @Override
    public String toString() {
        return (lastname + " " + name + " " + dayOfBirth + " " + gender);
    }

//    @Override
//    public int compareTo(Human o) {
//        if(this.getAge()>o.getAge())
//            return 1;
//        else if (getAge()<o.getAge())
//            return -1;
//        else return 0;
//    }
}