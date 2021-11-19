public class AddOrder extends Thread{

    private int ordernum;

    public AddOrder(int ordernum) {
        this.ordernum=ordernum;
    }

    @Override
    public void run() {
        synchronized (Main.orderArrayList){
            Main.orderArrayList.add(new Order(ordernum));
            System.out.println(Thread.currentThread().getName());

        }
    }
}
