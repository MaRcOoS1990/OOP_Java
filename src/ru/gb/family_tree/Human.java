package ru.gb.family_tree;
import java.time.*;
import java.util.*;

public class Human {
    private int id;
    private final String lastname;
    private final String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private final Gender gender;
    private final Map< String, String > parents;
    private final List< Human > children;
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


    /**
     * Определение значения ID
     */
    public String getId() {
        return this.id + ". ";
    }

    /**
     * Определение Имени
     */
    public String getName() {
        return name;
    }

    /**
     * Определение фамилии
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Определение "Имя Фамилия"
     */
    public String getFullName() {
        return this.getLastname() + " " + this.getName();
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    /**
     * Определение возраста для живых, возврата даты смерти для умерших
     */
    public String getAge() {
        if (this.dayOfDeath == null) {
            return Integer.toString(Period.between(this.dayOfBirth, LocalDate.now()).getYears());
        } else {
            return String.valueOf(this.dayOfDeath);
        }
    }

    public Gender getGender() {
        return gender;
    }

    /**
     * Получение списка родителей
     */
    public String getParents() {
        StringBuilder sb = new StringBuilder("Родители: ");
        if (this.parents.isEmpty()){
            sb.append("Данных нет");
        }
        else{
            sb.append(this.parents);
        }
        return sb.toString();
    }

    /**
     * Получение списка детей
     */
    public String getChildren() {
        if(this.children.isEmpty()){
            return "Детей нет";
        }
        return "Дети: " + this.children;
    }

    /**
     * Получение Имени и Фамилии супруга
     */
    public String getPartner() {
        if(this.partner == null){
            return "Не женат/замужем";
        }
        return "Супруг: " + this.partner;
    }

    /**
     * Добавление ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Установка супружества: супруг1.partner(супруг2)
     */
    public void setPartner(Human partner) {
        this.partner = partner;
        partner.partner = this;
    }

    /**
     * Добавление дня рождения
     */
    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * Добавление дня смерти
     */
    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    /**
     * присвоение родителя человеку
     */
    private void setParent(Human human) {
        if (human.getGender() == Gender.Male) {
            this.parents.put("Отец " , " " + human.getFullName());
        }
        else this.parents.put("Мать " , " " + human.getFullName());
    }

    /**
     * объединение ребенка с человеком
     */
    public void setChild(Human human) {
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    /**
     * Переопределенние toString
     */
    @Override
    public String toString() {
        return (lastname + " " + name);
    }
}