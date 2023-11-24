package view.commands;

import view.View;

public class SortByAge extends Command{
    public SortByAge(View view) {
        super(view, "Sort by age");
    }

    @Override
    public void execute() {
        getView().sortByAge();
    }
}
