public class AddCustomer extends Thread {

    private String name;

    public AddCustomer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (Main.customerArrayList) {
            if (Main.capacity_resturant > Main.number_of_the_customer) {
                Main.customerArrayList.add(new Customer(name));
                Main.number_of_the_customer++;
                System.out.println(Thread.currentThread().getName());

            } else {
                try {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("the resturant is full");
                    Main.customerArrayList.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
