package ir.maktabsharif.thread;

public class BorrowTask implements Runnable{
private final SharedBook sharedBook;
private final boolean safe;

    public BorrowTask(SharedBook sharedBook, boolean safe) {
        this.sharedBook = sharedBook;
        this.safe = safe;
    }


    @Override
    public void run() {
        if (safe){
            sharedBook.borrowBookSafe();
        }
        else {
            sharedBook.borrowBookUnsafe();
        }
    }
}
