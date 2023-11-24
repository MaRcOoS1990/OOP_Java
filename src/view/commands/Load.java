package view.commands;

import view.View;

public class Load extends Command {


    public Load(View view) {
        super(view, "Upload");
    }

    @Override
    public void execute() {
        getView().load();
    }
}
