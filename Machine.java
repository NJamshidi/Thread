public class Machine extends Thread{

    String name;
    public Machine() {

    }


    public Machine(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while (true){
            synchronized (Main.orderArrayList){

                if (!Main.orderArrayList.isEmpty()){
                    System.out.println(Thread.currentThread().getName());

                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Main.orderArrayList.remove(0);
                    Main.cook_number++;
                    System.out.println("one order deliverd. you can order food");
                }

            }
        }

    }
}
