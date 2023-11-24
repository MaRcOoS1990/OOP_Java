package view.commands;

import view.View;

public class SetChild extends Command {
    public SetChild(View view) {
        super(view, "Add the child");
    }

    @Override
    public void execute() {
        getView().setChild();
    }
}
