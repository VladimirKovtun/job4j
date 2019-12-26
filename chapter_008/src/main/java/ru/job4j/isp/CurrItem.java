package ru.job4j.isp;

import java.util.List;

public class CurrItem implements Item<CurrItem> {
    private final String info;
    private List<CurrItem> items;
    private SomeAction action;

    public CurrItem(String info, List<CurrItem> items) {
        this.info = info;
        this.items = items;

    }

    public CurrItem(String info, List<CurrItem> items, SomeAction action) {
        this.info = info;
        this.items = items;
        this.action = action;
    }

    public List<CurrItem> getItems() {
        return items;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public void add(List<CurrItem> list) {
        if (items != null) {
            items.addAll(list);
        } else {
            items = list;
        }
    }

    @Override
    public void execute(Input input) {
        if (action != null) {
            action.act(input);
        }
    }

    @Override
    public List<CurrItem> show() {
        List<CurrItem> list = null;
        System.out.println(info);
        if (items != null) {
            list = items;
        }
        return list;
    }
}
