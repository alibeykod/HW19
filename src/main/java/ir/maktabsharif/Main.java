package ir.maktabsharif;


import ir.maktabsharif.exception.BookNotFoundException;
import ir.maktabsharif.exception.InvalidDataException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Member;
import ir.maktabsharif.repository.BookRepositoryInterface;
import ir.maktabsharif.repository.MemberRepository;
import ir.maktabsharif.service.impl.BookServiceImpl;
import ir.maktabsharif.service.impl.MemberServiceImpl;
import ir.maktabsharif.thread.*;
import ir.maktabsharif.util.StreamReports;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        StreamReports streamReports = new StreamReports();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        while (true) {
            System.out.println("""
                    ==========    Library Book Management System    ==========
                    
                    
                        1.Add Book
                        2.Update Book
                        3.Delete Book
                        4.Add Member
                        5.Update Member
                        6.Delete Member
                        7.Reports
                        8.Thread Exercises
                            a.Race Condition
                            b.Producer Consumer
                            c.Executor Service
                        9.Exit
                    """);
            System.out.println("Please Enter ََA Number Between 1 To 9 : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("========== Add A Book ==========");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please Enter ََAuthor's Name : ");
                    String author = scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter Available Copies Of The Book : ");
                    int availableCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter Price Of The Book : ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println(" And One More Thing Please Enter Title Of The Book : ");
                    String title = scanner.nextLine();
                    bookService.save(new Book(title, author, availableCopies, price));
                    break;
                }
                case 2: {

                    System.out.println("========== Update A Book ==========");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please Enter  Id : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter New ََAuthor's Name : ");
                    String newAuthor = scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter New Available Copies Of The Book : ");
                    int newAvailableCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter New Price Of The Book : ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println(" And One More Thing Please Enter New Title Of The Book : ");
                    String newTitle = scanner.nextLine();
                    bookService.update(new Book(id , newTitle , newAuthor ,newAvailableCopies ,newPrice));
                    break;
                }

                case 3: {
                    System.out.println("========== Delete A Book ==========");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please Enter ID Of Book That You Want To Remove : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    try {
                        bookService.delete(id);
                    } catch (Exception e) {
                        throw new InvalidDataException("Book Did Not Deleted yet" + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("==========    Add Member   ==========");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please Enter Name Of Member : ");
                    String name = scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter Phone Number Of Member : ");
                    String phone = scanner.nextLine();
                    System.out.println(" + + + + + + ");

                    memberService.save(new Member(name, phone));
                    break;
                }
                case 5: {
                    System.out.println("==========    Update Member   ==========");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please Enter ID Of Member : ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter New Name Of Member : ");
                    String newName = scanner.nextLine();
                    System.out.println(" + + + + + + ");
                    System.out.println("Please Enter New Phone Number Of Member : ");
                    String newPhone = scanner.nextLine();
                    System.out.println(" + + + + + + ");

                    memberService.update(new Member(id , newName, newPhone));
                    break;
                }

                case 6: {
                    System.out.println("==========    Delete Member   ==========");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please Enter The Id Of That Member You Want To Delete : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    try {
                        memberService.delete(id);
                    } catch (Exception e) {
                        throw new InvalidDataException("Member Did Not Deleted Yet !" + e.getMessage());
                    }
                    break;
                }
                case 7: {
                    System.out.println("==========    Repots ( Streams )   ==========");
                    System.out.println();
                    System.out.println();
                    // get total of books
                    System.out.println("How Many Book We Have In Library : ");
                    System.out.println(streamReports.totalNumberOfBooks());
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~");
                    System.out.println();
                    // get average of books
                    System.out.println("What Is The Average Price Of Books In This Library : ");
                    System.out.println(streamReports.averageBookPrice());
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~");
                    System.out.println();
                    // get the most expensive Book
                    System.out.println("What Is The Average Price Of Books In This Library : ");
                    try {
                        System.out.println(streamReports.mostExpensiveBook());
                    } catch (Exception e) {
                        throw new InvalidDataException("No Book HAs Been Found In The Library " + e.getMessage());
                    }
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~");
                    System.out.println();
                    break;
                }
                case 8:
                    System.out.println("=========    THREAD    =========");
                    SharedBook sharedBook = new SharedBook("Hansel" , 1);
                    Thread thread1 = new Thread(new  BorrowTask(sharedBook , false));
                    Thread thread2 = new Thread(new  BorrowTask(sharedBook , false));
                    thread1.start();
                    thread2.start();

                    try {
                        thread1.join();
                        thread2.join();
                    }catch (Exception e){
                        System.out.println("Interrupted");
                    }
                    System.out.println("Remaining Copies " + sharedBook.getAvailableCopies());

                    System.out.println("==========================================================");

                    System.out.println("Producer Consumer ");

                    WareHouse warehouse = new WareHouse();

                    Thread producer =
                            new Thread(new Producer(warehouse));

                    Thread consumer =
                            new Thread(new Consumer(warehouse));

                    producer.start();
                    consumer.start();

                    try {
                        producer.join();
                        consumer.join();
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }


                    System.out.println("Producer-Consumer finished.");
                    break;
                case 9: {
                    scanner.close();
                    System.out.println("Exiting Of The Library Management ....");
                    return;
                }
                default:
                    System.out.println("Wrong Number Please Try Again ...");
            }//End Of Switch
        }//End Of While Loop

    }//End Of Main Method
}//End Of Class
