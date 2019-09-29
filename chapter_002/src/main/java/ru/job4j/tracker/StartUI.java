package ru.job4j.tracker;


public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] userActions) {
        boolean run = true;
        while (run) {
            showMenu(userActions);
            int select = (int) input.askLong("Select: ", userActions.length);
            UserAction userAction = userActions[select];
            run = userAction.execute(tracker, input);
        }
    }

    private void showMenu(UserAction[] userActions) {
        System.out.println("");
        System.out.println("Menu input:");
        for (int i = 0; i < userActions.length; i++) {
            System.out.printf("%d. %s%n", i, userActions[i].name());
        }
    }

    public static void main(String[] args) {
        UserAction[] userActions = {new CreateAction(),
                new ShowAllAction(),
                new DeleteAction(),
                new EditAction(),
                new FindByNameAction(),
                new FindByIdAction(),
                new ExitAction()};
        Input input = new ValidateInput();
        new StartUI().init(input, new Tracker(), userActions);
    }
}
