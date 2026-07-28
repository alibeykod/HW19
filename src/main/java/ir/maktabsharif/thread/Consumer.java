package ir.maktabsharif.thread;

public class Consumer implements Runnable{
   private final WareHouse wareHouse;

    public Consumer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 4 ; i++){
            wareHouse.consume();
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
