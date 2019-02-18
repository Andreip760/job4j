package ru.job4j.tracker;
/**
 * Class serving interaction with user.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class StartUI {
    private static final String SEPARATOR = System.getProperty("line.separator");
    /**
     * User menu selections
     */
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    /**
     * Input interface.
     */
    private final Input input;
    /**
     * Applications storage.
     */
    private final Tracker tracker;
    /**
     * Class's fields initializer (constructor)
     * @param input Input interface.
     * @param tracker Tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Main loop.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer){
                case ADD: createItem(); break;
                case SHOW_ALL: showAll(); break;
                case EDIT: editItem(); break;
                case DELETE: deleteItem(); break;
                case FIND_BY_ID: findById(); break;
                case FIND_BY_NAME: findByName(); break;
                case EXIT: exit = true; break;
            }
        }
    }
    /**
     * Adding a new item
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Showing all items
     */
    private void showAll() {
        System.out.println("------------ Все заявки --------------");
        for (Item item : this.tracker.findAll()){
            System.out.printf("%s %s %s%s", item.getId(), item.getName(), item.getDesc(), SEPARATOR);
        }
        System.out.println("--------------------------------------");
    }
    /**
     * Editing of existing item
     */
    private void editItem(){
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите Id заявки");
        String name = this.input.ask("Введите новое имя");
        String desc = this.input.ask("Введите новое описание");
        Item replacer = new Item(name, desc);
        if(this.tracker.replace(id, replacer)){
            System.out.printf("Заявка Id: %s заменена%s", id, SEPARATOR);
        }else {
            System.out.printf("Заявка Id: %s не найдена%s", id, SEPARATOR);
        }
        System.out.println("-------------------------------------------------");
    }
    /**
     * Deleting item
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите Id заявки ");
        if (this.tracker.delete(id)){
            System.out.printf("Заявка Id: %s удалена%s", id, SEPARATOR);
        }else {
            System.out.printf("Заявка Id: %s не найдена%s", id, SEPARATOR);
        }
        System.out.println("-------------------------------------------");
    }
    /**
     * Finding item by Id
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по Id ------------");
        String id = this.input.ask("Введите Id заявки");
        Item found = this.tracker.findById(id);
        if(found != null) {
            System.out.printf("%s %s %s%s", found.getId(), found.getName(), found.getDesc(), SEPARATOR);
        }else {
            System.out.printf("Заявка Id: %s не найдена%s", id, SEPARATOR);
        }
        System.out.println("-------------------------------------------");
    }
    /**
     * Finding item by name
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя ");
        for (Item item : this.tracker.findByName(name)){
            System.out.printf("%s %s %s%s", item.getId(), item.getName(), item.getDesc(), SEPARATOR);
        }
        System.out.println("-------------------------------------------------");
    }
    /**
     * Showing user's menu
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    /**
     * Entry point.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
