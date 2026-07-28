package ir.maktabsharif.thread;

public class SharedBook {
    private String title;
    private int availableCopies;


    public SharedBook(String title, int availableCopies) {
        this.title = title;
        this.availableCopies = availableCopies;
    }

    public void borrowBookUnsafe() {
        borrow();
    }

    public synchronized void borrowBookSafe() {
        borrow();
    }

    private void borrow() {
        if (availableCopies > 0) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            availableCopies--;
            System.out.println(Thread.currentThread().getName() + " -> Borrowed " + title);
        }
        System.out.println(Thread.currentThread().getName() + " -> Failed ");
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}
