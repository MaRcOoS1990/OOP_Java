package view.commands;

import view.View;

public class SortById extends Command{
    public SortById(View view) {
        super(view, "Sort by ID");
    }

    @Override
    public void execute() {
        getView().sortById();
    }
}
