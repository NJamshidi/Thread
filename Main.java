import java.util.*;

public class Main {

    public static int number_of_the_customer = 0;
    public static int capacity_resturant = 5;
    public static int cook_number = 2;

    static Queue<Customer> customerArrayList = new LinkedList<>();
    static ArrayList<Order> orderArrayList = new ArrayList<>();

    public static void main(String[] args) throws InputMismatchException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine();
        machine.start();

        while (true) {

            System.out.println("number of cooks are "+cook_number);
            System.out.println("number of customers are "+number_of_the_customer);
            System.out.println("1 - insert customer");
            System.out.println("2 - leave customer");
            System.out.println("3 - list customers");
            System.out.println("4 - submit the order");
            System.out.println("5 - list of order");

            int n = scanner.nextInt();

            if (n == 1){
                    System.out.println("enter name of customer");
                    String name = scanner.next();
                    AddCustomer addCustomer = new AddCustomer(name);
                    addCustomer.start();
                    addCustomer.join();

            }else if (n == 2){
                LeaveCustomer leaveCustomer = new LeaveCustomer();
                leaveCustomer.start();
                leaveCustomer.join();

            }else if (n == 3){
                for (Customer c:customerArrayList) {
                    System.out.println(c.name);
                }
            }else if (n == 4){

                if (Order.cook_exist()){
                    System.out.println("enter order number");
                    int ordernum = scanner.nextInt();
                    cook_number--;
                  AddOrder addOrder= new AddOrder(ordernum);
                  addOrder.start();

                }else {
                    System.out.println("no cook exist");
                }

            }else if (n == 5){
                for (Order order:orderArrayList) {
                    System.out.println(order.orderNum);
                }
            }


        }
    }
}
