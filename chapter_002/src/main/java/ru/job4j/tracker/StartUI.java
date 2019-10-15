package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class StartUI {


    public void init(Input input, Tracker tracker, List<BaseAction> userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = (int) input.askLong("Select: ", userActions.size());
            UserAction userAction = userActions.get(select);
            run = userAction.execute(tracker, input);
        }
    }

    private void showMenu(List<BaseAction> userActions) {
        System.out.println("");
        System.out.println("Menu input:");
        for (BaseAction action : userActions) {
            System.out.println(action.info());
        }
    }

    public static void main(String[] args) {
        ArrayList<BaseAction> userActions = new ArrayList<>();
        userActions.add(new CreateAction(0, "Create item."));
        userActions.add(new ShowAllAction(1, "Show all items.", System.out::print));
        userActions.add(new DeleteAction(2, "Delete item."));
        userActions.add(new EditAction(3, "Replace item."));
        userActions.add(new FindByNameAction(4, "Find items by name.", System.out::print));
        userActions.add(new FindByIdAction(5, "Find item by ID.", System.out::print));
        userActions.add(new ExitAction(6, "Exit program."));

        Input input = new ValidateInput(new ConsoleInput());
        new StartUI().init(input, new Tracker(), userActions);
    }
}
