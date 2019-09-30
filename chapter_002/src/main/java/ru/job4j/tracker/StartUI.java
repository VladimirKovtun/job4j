package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker, BaseAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = (int) input.askLong("Select: ", userActions.length);
            UserAction userAction = userActions[select];
            run = userAction.execute(tracker, input);
        }
    }

    private void showMenu(BaseAction[] userActions) {
        System.out.println("");
        System.out.println("Menu input:");
        for (BaseAction action : userActions) {
            System.out.println(action.info());
        }
    }

    public static void main(String[] args) {
        BaseAction[] userActions = {new CreateAction(0, "Create item."),
                new ShowAllAction(1, "Show all items."),
                new DeleteAction(2, "Delete item."),
                new EditAction(3, "Replace item."),
                new FindByNameAction(4, "Find items by name."),
                new FindByIdAction(5, "Find item by ID."),
                new ExitAction(6, "Exit program.")};
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI().init(input, new Tracker(), userActions);
    }
}
