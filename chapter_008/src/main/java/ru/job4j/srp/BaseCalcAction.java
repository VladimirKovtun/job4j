package ru.job4j.srp;

/**
 * Actions abstract class.
 */
public abstract class BaseCalcAction implements ICalcAction {
    /**
     * Serial number action in menu.
     */
    private final String number;
    /**
     * Name action in menu.
     */
    private final String text;

    protected BaseCalcAction(final String number, final String text) {
        this.number = number;
        this.text = text;
    }

    /**
     * Full info for menu.
     *
     * @return ready string for menu.
     */
    public String info() {
        return String.format("\"%s\" = %s", number, text);
    }
}
