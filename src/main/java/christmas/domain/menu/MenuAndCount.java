package christmas.domain.menu;

import christmas.exception.PromotionExceptionMaker;

public class MenuAndCount {
    private final Menu menu;
    private final int count;

    public MenuAndCount(Menu menu, int count) {
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    private void validateCount(int count) {
        if (count < 1) {
            throw PromotionExceptionMaker.INVALID_COUNT.makeException();
        }
    }

    public static MenuAndCount from(String order){
        String[] split = order.split("-");
        Menu menu = Menu.from(split[0]);
        int count = Integer.parseInt(split[1]);
        return new MenuAndCount(menu, count);
    }

    public int calcPrice() {
        return menu.getPrice() * count;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }

    public boolean isCategory(Category category) {
        return category.contains(menu);
    }
}
