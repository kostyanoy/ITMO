package lab3.functionality;

public class ItemFactory implements AbstractFactory{
    private Item item;
    public ItemFactory(String name, String description, boolean consumable, Action ...actions) {
        item = new Item(name, p -> String.format(description, p), consumable);
        for (var action : actions) {
            item.addAction(action);
        }
    }

    @Override
    public Item getElement() {
        return item;
    }
}
