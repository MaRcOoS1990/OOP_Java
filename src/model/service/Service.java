package model.service;

import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import model.writer.Writable;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyList;

    private Writable writable;



    public Service(Writable writable) {
        this.writable = writable;
        familyList = new FamilyTree<>();
        builder = new HumanBuilder();
//        Human human1 = builder.build(1, "Shopalev", "Sergey", LocalDate.of(1988, 4, 7), Gender.Male);
//        Human human2 = builder.build(2, "Selivanova", "Olga", LocalDate.of(1987, 3, 11), Gender.Female);
//        Human human3 = builder.build(3, "Shopalev", "Yurii", LocalDate.of(1940, 6, 15), Gender.Male);
//        Human human4 = builder.build(4, "Detkova", "Luba", LocalDate.of(1946, 3, 22), Gender.Female);
//        Human human5 = builder.build(5, "Selivanov", "Igor", LocalDate.of(1958, 2, 13), Gender.Male);
//        Human human6 = builder.build(6, "Selivanova", "Natalia", LocalDate.of(1980, 6, 18), Gender.Female);
//        Human human7 = builder.build(7, "Detkov", "Fedor", LocalDate.of(1926, 1, 19), Gender.Male);
//        Human human8 = builder.build(8, "Ilevarova", "Anastasiya", LocalDate.of(1924, 2, 13), Gender.Female);
//        Human human9 = builder.build(9, "Detkova", "Elvira", LocalDate.of(1957, 8, 21), Gender.Female);
//        Human human10 = builder.build(10, "Shopaleva", "Ekaterina", LocalDate.of(2012, 4, 2), Gender.Female);
//        Human human11 = builder.build(11, "Kuprinova", "Ludmila", LocalDate.of(1941, 1, 15), Gender.Female);
//
//        familyList.addHuman(human1);
//        familyList.addHuman(human2);
//        familyList.addHuman(human3);
//        familyList.addHuman(human4);
//        familyList.addHuman(human5);
//        familyList.addHuman(human6);
//        familyList.addHuman(human7);
//        familyList.addHuman(human8);
//        familyList.addHuman(human9);
//        familyList.addHuman(human10);
//        familyList.addHuman(human11);

    }

    public void addHuman(List info){
        String lastname = info.get(0).toString();
        String name = info.get(1).toString();
        LocalDate birth = (LocalDate) info.get(2);
        LocalDate death = (LocalDate) info.get(3);
        Gender gender = getInfoGender(info);
        Human human = builder.build(lastname, name, birth, death, gender);
        familyList.addHuman(human);
    }

    public String getHumanListInfo(){
        return familyList.allTree();
    }

    public FamilyTree< Human > getFamilyTree() {
        return familyList;
    }

    public void read(){
        familyList = load();
        System.out.println(familyList.allTree());
    }

    private FamilyTree<Human> load() {
        String filePath = "src/model/writer/tree.txt";
        System.out.println("Upload file: ");
        return (FamilyTree<Human>) writable.read(filePath);
    }

    public void save(){
        String filePath = "src/model/writer/tree.txt";
        boolean saved = writable.save(familyList, filePath);
        System.out.println("Save file: " + saved);
    }

    public void sortByName(){
        familyList.sortByName();
    }
    public void sortByLastname(){
        familyList.sortByLastname();
    }
    public void sortByAge(){
        familyList.sortByAge();
    }
    public void sortById(){
        familyList.sortById();
    }

    public String searchByNameSurname(String name){
        return familyList.SearchByNameSurname(name);
    }

    public void setChild(int idParent, int idChild){
        Human parent = searchById(idParent);
        Human child = searchById(idChild);
        parent.setChild(child);
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }


    public Human searchById(int idHuman) {
        return familyList.searchById(idHuman);
    }
    private LocalDate setDate(List date, int indexY, int indexM, int indexD){
        int year = Integer.parseInt(date.get(0).toString());
        int month = Integer.parseInt(date.get(1).toString());
        int day = Integer.parseInt(date.get(2).toString());
        LocalDate dateOut = LocalDate.of(year, month, day);
        return dateOut;
    }
    private Gender getInfoGender(List list){
        Gender gender;
        if(list.get(5).toString().contains("Male"))
            gender = Gender.Male;
        else gender = Gender.Female;
        return gender;
    }
}
