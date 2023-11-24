package view.commands;

import view.View;

public class FindByName extends  Command{
    public FindByName(View view) {
        super(view, "Search by word");
    }

    @Override
    public void execute() {
        getView().findByName();
    }
}
