public class Order {
    int orderNum;

    public Order(int orderNum) {
        this.orderNum = orderNum;
    }

    public static synchronized boolean cook_exist() {
        if (Main.cook_number > 0){
            return true;
        }
        return false;
    }

}
