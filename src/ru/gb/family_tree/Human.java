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
     * ����������� �������� ID
     */
    public String getId() {
        return this.id + ". ";
    }

    /**
     * ����������� �����
     */
    public String getName() {
        return name;
    }

    /**
     * ����������� �������
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * ����������� "��� �������"
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
     * ����������� �������� ��� �����, �������� ���� ������ ��� �������
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
     * ��������� ������ ���������
     */
    public String getParents() {
        StringBuilder sb = new StringBuilder("��������: ");
        if (this.parents.isEmpty()){
            sb.append("������ ���");
        }
        else{
            sb.append(this.parents);
        }
        return sb.toString();
    }

    /**
     * ��������� ������ �����
     */
    public String getChildren() {
        if(this.children.isEmpty()){
            return "����� ���";
        }
        return "����: " + this.children;
    }

    /**
     * ��������� ����� � ������� �������
     */
    public String getPartner() {
        if(this.partner == null){
            return "�� �����/�������";
        }
        return "������: " + this.partner;
    }

    /**
     * ���������� ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * ��������� �����������: ������1.partner(������2)
     */
    public void setPartner(Human partner) {
        this.partner = partner;
        partner.partner = this;
    }

    /**
     * ���������� ��� ��������
     */
    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * ���������� ��� ������
     */
    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    /**
     * ���������� �������� ��������
     */
    private void setParent(Human human) {
        if (human.getGender() == Gender.Male) {
            this.parents.put("���� " , " " + human.getFullName());
        }
        else this.parents.put("���� " , " " + human.getFullName());
    }

    /**
     * ����������� ������� � ���������
     */
    public void setChild(Human human) {
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    /**
     * ���������������� toString
     */
    @Override
    public String toString() {
        return (lastname + " " + name);
    }
}