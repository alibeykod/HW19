package ir.maktabsharif.thread;

import ir.maktabsharif.model.Book;

public class Producer implements Runnable {
    private final WareHouse wareHouse ;

    public Producer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 4 ; i++){
            Book book = new Book();
            book.setTitle("book _ " + i);
            book.setAuthor("author _ " + i);
            book.setPrice(0.0 + i);
            book.setAvailableCopies(1);
            wareHouse.produce(book);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
            }
        }

    }

}
