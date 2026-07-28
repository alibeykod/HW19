package ir.maktabsharif.thread;

import ir.maktabsharif.model.Book;

public class WareHouse {
    private Book book;


    public synchronized void produce( Book newBook){
        while (book != null ){
            try {
                System.out.println("warehouse is full !");
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
        book = newBook;
        System.out.println(Thread.currentThread().getName() + " stored " + book.getTitle());
        notifyAll();
    }
    public synchronized void consume(){
        while (book == null){
            try {
                System.out.println("wareHouse is empty !");
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
        book = null;
        System.out.println(Thread.currentThread().getName() + " Shipped ");
        notifyAll();
    }

}
