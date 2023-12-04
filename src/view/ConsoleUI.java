package view;

import java.time.LocalDate;
import java.util.Scanner;
import presenter.Presenter;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work) {
            printMenu();
            scanMenu();
        }
    }
    private void scanMenu() {
        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    @Override
    public void answer(String answer) {
            System.out.println(answer);
        }

    @Override
    public void sortByAge() {
        presenter.sortByAge();
        presenter.getHumanListInfo();
    }

    @Override
    public void sortByName() {
        presenter.sortByName();
        presenter.getHumanListInfo();
    }

    @Override
    public void sortBySurname() {
        presenter.sortBySurname();
        presenter.getHumanListInfo();
    }

    @Override
    public void sortById() {
        presenter.sortById();
        presenter.getHumanListInfo();
    }

    private void printMenu(){
        System.out.println(menu.print());
    }
    private void error() {
        System.out.println("Error");
    }

    public void finish() {
        work = false;
    }

    @Override
    public void getFamilyList() {
        presenter.getHumanListInfo();
    }

    @Override
    public void load() {
            presenter.load();
            presenter.getHumanListInfo();

    }

    @Override
    public void save() {
            presenter.save();
            presenter.getHumanListInfo();

    }

    @Override
    public void addHuman() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Input ID");
        String idStr = scanner.nextLine();
        int id = Integer.parseInt(idStr);
        System.out.println("Input lastname");
        String lastname = scanner.nextLine();
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Date of birth 'yyy-mmm-ddd'");
        LocalDate dayOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.println("Date of death 'yyy-mmm-ddd'");
        String dayStr = scanner.nextLine();
        LocalDate dayOfDeath;
        if (!(dayStr.isEmpty())) {
            dayOfDeath = LocalDate.parse(dayStr.subSequence(0, dayStr.length()));
        } else dayOfDeath = null;
        System.out.println("Input sex (Male, Female)");
        String gender = scanner.nextLine();
        sb.append(id);
        sb.append(", ");
        sb.append(lastname);
        sb.append(", ");
        sb.append(name);
        sb.append(", ");
        sb.append(dayOfBirth);
        sb.append(", ");
        sb.append(dayOfDeath);
        sb.append(", ");
        sb.append(gender);
        String info = sb.toString();
        presenter.addHuman(info);

    }

    @Override
    public void setChild() {
        System.out.println("Input ID parent: ");
        Scanner scanner = new Scanner(System.in);
        String idParentStr = scanner.nextLine();
        int idParent = Integer.parseInt(idParentStr);
        System.out.println("Input ID child: ");
        String idChildStr = scanner.nextLine();
        int idChild = Integer.parseInt(idChildStr);
        presenter.setChild(idParent,idChild);
        presenter.getHumanListInfo();
    }



    @Override
    public void findByName() {
        System.out.println("Input a word: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(presenter.searchByName(name));
    }
}
