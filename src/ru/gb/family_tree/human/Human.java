package ru.gb.family_tree.human;
import ru.gb.family_tree.family_tree.FamilyTree;

import java.io.Serializable;
import java.time.*;
import java.util.*;

public class Human implements Serializable {
    private int id;
    private String lastname;
    private String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private Gender gender;
    private Map< String, String > parents;
    private List< Human > children;
    Human partner;

    public Human(FamilyTree family, String lastname, String name, LocalDate birthday, Gender gender) {
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap<>();
        this.children = new ArrayList<>();
        setDayOfBirth(birthday);
        family.addHuman(this);
    }



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


    public String getAge() {
        if (this.dayOfDeath == null) {
            return Integer.toString(Period.between(this.dayOfBirth, LocalDate.now()).getYears());
        } else {
//            return String.valueOf(this.dayOfDeath);
            return Integer.toString(Period.between(this.dayOfBirth,this.dayOfDeath).getYears());
        }
    }

    public Gender getGender() {
        return gender;
    }


    public String getParents() {
        StringBuilder sb = new StringBuilder("Parents: ");
        if (this.parents.isEmpty()){
            sb.append("no data available");
        }
        else{
            sb.append(this.parents);
        }
        return sb.toString();
    }


    public String getChildren() {
        if(this.children.isEmpty()){
            return "no children";
        }
        return "Children: " + this.children;
    }


    public String getPartner() {
        if(this.partner == null){
            return "Not married";
        }
        return "Spouse: " + this.partner;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setPartner(Human partner) {
        this.partner = partner;
        partner.partner = this;
    }


    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }


    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }


    private void setParent(Human human) {
        if (human.getGender() == Gender.Male) {
            this.parents.put("Father " , " " + human.getFullName());
        }
        else this.parents.put("Mother " , " " + human.getFullName());
    }


    public void setChild(Human human) {
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }


//    @Override
//    public String toString() {return (lastname + " " + name); }


    @Override
    public String toString() {
        return getId()+getFullName()+" "+getDayOfBirth()+", "+getAge()+" years";
    }


}
