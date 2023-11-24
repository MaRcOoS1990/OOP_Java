package view.commands;

import view.View;

public class SortByName extends Command {

    public SortByName(View view) {
        super(view, "Sort by name");
    }


    @Override
    public void execute() {
        getView().sortByName();
    }
}
