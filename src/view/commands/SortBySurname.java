package view.commands;

import view.View;

public class SortBySurname extends Command{
    public SortBySurname(View view) {
        super(view, "Sort by lastname");
    }

    @Override
    public void execute() {
        getView().sortBySurname();
    }
}
