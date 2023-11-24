package view.commands;

import view.View;

public class Finish extends Command{
    public Finish(View view) {
        super(view, "Finish");
    }

    @Override
    public void execute() {
        getView().finish();
    }
}
