package view.commands;

import view.View;

public class AddHuman extends Command{
    public AddHuman(View view) {
        super(view, "Add person");
    }

    @Override
    public void execute() {
        getView().addHuman();
    }
}
