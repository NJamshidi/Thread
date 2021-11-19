public class LeaveCustomer extends Thread{

    @Override
    public void run() {
        synchronized (Main.customerArrayList) {
            if (!Main.customerArrayList.isEmpty()){
                Main.number_of_the_customer--;
                Main.customerArrayList.poll();
                Main.customerArrayList.notify();
                System.out.println(Thread.currentThread().getName());

                System.out.println("one customer left the resturant");
            }else {
                System.out.println(Thread.currentThread().getName());

                System.out.println("there is no customer in resturant");
            }
        }
    }
}
