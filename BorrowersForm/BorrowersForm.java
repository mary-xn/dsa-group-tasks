import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BorrowersForm {
    /*The class "Book" is used for the books to have a blueprint. This makes it easier for us to assign the title for each book and not redo it again and again.*/
    static class Book{
        String title;

        //This is the constructor. It helps us assign the book's title right after we create a Book object.
        public Book(String title){
            this.title = title;
        }

        //Availability method to be added.
    }

    //This is the main method. Everything that is inside this is gonna run once we run the code.
    public static void main (String[] args){
        //Declaring variables.
        Scanner scanner = new Scanner(System.in);
        String studentId, fullName, program, section, bookCategory, bookName, categoryName;
        int bookNumber;

        /*This is a Map, similar to HashMaps but we don't need to "create" it that's why it doesn't have "New Map".
        It lets us store a key (category's code) and its corresponding value (the subject).
        k = key
        v = value

        This Map makes it easier for our system to search through the codes that the user will enter.
        This will make sense later in the bookCategory variable. I used this instead of switch cases for better readability.
        */
        Map<String, String> categoryNames = Map.ofEntries(
            Map.entry("000", "000 - General Works, Computer Science, Information"),
            Map.entry("100", "100 - Philosophy & Psychology"),
            Map.entry("200", "200 - Religion"),
            Map.entry("300", "300 - Social Sciences"),
            Map.entry("400", "400 - Language"),
            Map.entry("500", "500 - Science"),
            Map.entry("600", "600 - Technology"),
            Map.entry("700", "700 - Arts & Recreation"),
            Map.entry("800", "800 - Literature"),
            Map.entry("900", "900 - History & Geography")
        );

        /*
         This is categoryBooks HashMap. Similar to what we have above, but its values are list of books that each category has.
         Similar to the code above, it makes us easier for our system to look for the book according to its index (the corresponding number of each book in the list. Note: It always starts with 0.)
         */
        Map<String, List<Book>> categoryBooks = new HashMap<>();
        
        //.put() is a method in HashMap that lets us store keys and values in our HashMap(categoryBooks)
        categoryBooks.put("000", List.of(
            new Book("The Information: A History, a Theory, a Flood – James Gleick"),
            new Book("Computer Science Illuminated – Nell Dale"),
            new Book("How to Read a Book – Mortimer Adler"),
            new Book("Artificial Intelligence: A Modern Approach – Russell & Norvig"),
            new Book("Digital Minimalism – Cal Newport"),
            new Book("The Master Algorithm – Pedro Domingos")
        ));

        categoryBooks.put("100", List.of(
            new Book("Thinking, Fast and Slow – Daniel Kahneman"),
            new Book("Meditations – Marcus Aurelius"),
            new Book("The Power of Now – Eckhart Tolle"),
            new Book("The Republic – Plato"),
            new Book("Man's Search for Meaning – Viktor E. Frankl"),
            new Book("The Art of War – Sun Tzu")
        ));

        categoryBooks.put("200", List.of(
            new Book("Mere Christianity – C.S. Lewis"),
            new Book("The Case for Christ – Lee Strobel"),
            new Book("The Bhagavad Gita – Eknath Easwaran"),
            new Book("The Quran – Translation by M.A.S. Abdel Haleem"),
            new Book("The Bible – NIV Translation"),
            new Book("The Tao Te Ching – Laozi")
        ));

        categoryBooks.put("300", List.of(
            new Book("Freakonomics – Steven D. Levitt & Stephen J. Dubner"),
            new Book("The Tipping Point – Malcolm Gladwell"),
            new Book("Guns, Germs, and Steel – Jared Diamond"),
            new Book("Outliers – Malcolm Gladwell"),
            new Book("The Righteous Mind – Jonathan Haidt"),
            new Book("Quiet – Susan Cain")
        ));

        categoryBooks.put("400", List.of(
            new Book("The Elements of Style – William Strunk Jr. & E.B. White"),
            new Book("Eats, Shoots & Leaves – Lynne Truss"),
            new Book("English Grammar in Use – Raymond Murphy"),
            new Book("Fluent Forever – Gabriel Wyner"),
            new Book("The Sense of Style – Steven Pinker"),
            new Book("Word Power Made Easy – Norman Lewis")
        ));

        categoryBooks.put("500", List.of(
            new Book("A Brief History of Time – Stephen Hawking"),
            new Book("The Selfish Gene – Richard Dawkins"),
            new Book("Cosmos – Carl Sagan"),
            new Book("Astrophysics for People in a Hurry – Neil deGrasse Tyson"),
            new Book("The Elegant Universe – Brian Greene"),
            new Book("The Origin of Species – Charles Darwin")
        ));

        categoryBooks.put("600", List.of(
            new Book("Clean Code – Robert C. Martin"),
            new Book("The Pragmatic Programmer – Andrew Hunt"),
            new Book("Introduction to Algorithms – Cormen, Leiserson, Rivest, and Stein"),
            new Book("Code: The Hidden Language of Computer Hardware and Software – Charles Petzold"),
            new Book("Design Patterns – Erich Gamma et al."),
            new Book("Computer Networking: A Top-Down Approach – Kurose & Ross")
        ));

        categoryBooks.put("700", List.of(
            new Book("The Story of Art – E.H. Gombrich"),
            new Book("Ways of Seeing – John Berger"),
            new Book("Steal Like an Artist – Austin Kleon"),
            new Book("The War of Art – Steven Pressfield"),
            new Book("On Photography – Susan Sontag"),
            new Book("Understanding Comics – Scott McCloud")
        ));

        categoryBooks.put("800", List.of(
            new Book("The Great Gatsby – F. Scott Fitzgerald"),
            new Book("1984 – George Orwell"),
            new Book("To Kill a Mockingbird – Harper Lee"),
            new Book("The Odyssey – Homer"),
            new Book("Pride and Prejudice – Jane Austen"),
            new Book("Hamlet – William Shakespeare")
        ));

        categoryBooks.put("900", List.of(
            new Book("Sapiens: A Brief History of Humankind – Yuval Noah Harari"),
            new Book("A People's History of the United States – Howard Zinn"),
            new Book("Guns, Germs, and Steel – Jared Diamond"),
            new Book("The Silk Roads – Peter Frankopan"),
            new Book("Postwar – Tony Judt"),
            new Book("The History of the Ancient World – Susan Wise Bauer")
        ));

        //This is the start of the code that gets printed out in the terminal:
        System.out.println("==========================================");
        System.out.println("    \uD83D\uDCDA LIBRARY BORROWER'S FORM   ");
        System.out.println("==========================================\n\n");

        System.out.println(">> Enter Borrower Informaton");
        System.out.println("------------------------------------------");

        //These are the the information that the user has to answer/ fill out.
        studentId = inputWithValidation(scanner, "Student ID");
        fullName = inputWithValidation(scanner, "Full Name");
        program = inputWithValidation(scanner, "Program");
        section = inputWithValidation(scanner, "Section");

        
        System.out.println("\n\n>> \uD83D\uDCDA Browse Book Categories (Dewey Decimal System)");
        System.out.println("------------------------------------------");
        System.out.println("""
                           [000]  General Works, Computer Science, Information
                           [100]  Philosophy & Psychology
                           [200]  Religion
                           [300]  Social Sciences
                           [400]  Language
                           [500]  Science
                           [600]  Technology
                           [700]  Arts & Recreation
                           [800]  Literature
                           [900]  History & Geography""");
        System.out.print("\n\nEnter Category Code to Browse Books:   ");
        bookCategory = scanner.nextLine();

        //This is where our Map is being used.
        //.containsKey() is also a method in Map in Java that returs a boolean(true/false). It asks "Does the Map called categoryNames contains the key that the user entered?"
        if (categoryNames.containsKey(bookCategory)){
            displayBooksForCategory(bookCategory, categoryNames, categoryBooks, fullName, scanner);
        }else{
            System.out.println("❌ Invalid category code. Please restart and enter a valid one.");
        }
    }

    //This is for the validation of the user inputs. This is not yet finished so I'll leave this unexplained for I might do some changes.
    public static String inputWithValidation(Scanner scanner, String fieldName){
        while(true){
                String input;
                System.out.printf("%-20s:", fieldName);
                input = scanner.nextLine();

                if(input == null || input.trim().isEmpty()){
                    System.out.println(fieldName + " can't be empty. Please try again.");
                    continue;
                }
                
                if (fieldName.equals("Full Name")){
                    if (!input.matches("^[a-zA-Z\\s.,]+$")){
                        System.out.println("Full Name can only contain letters, spaces, and periods. Please try again.");
                        continue;
                    }
                }else {
                    if(!input.matches("^(?!.*[.-]{2})[a-zA-Z0-9\\s.-]+$")){
                        System.out.println("Input contains too many special characters. Only letters, numbers, and spaces are allowed.");
                        continue;
                    }
                }

                return input;
            
        }
    }

    //This is the method that will help us print out the confirmation form.
    public static void bookToBorrow(String bookName, String fullName, String categoryName){
        Scanner scanner = new Scanner(System.in);

        //For dates
        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(7);

        //This is to convert the date into a more readable format.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");


        System.out.println("\n\n>> Confirm Borrowing Details:");
        System.out.println("------------------------------------------");
        System.out.println("Borrower\t:" + fullName);
        System.out.println("Book Title\t:" + bookName);
        System.out.println("Book Category\t:" + categoryName);
        System.out.println("Borrow Date\t:" + borrowDate.format(formatter));
        System.out.println("Due Date\t:" + dueDate.format(formatter));
        System.out.print("\n\nConfirm borrow? (Y/N)\t:");
        char confirmation = scanner.next().charAt(0);

        //Swtich case for confirmation.
        switch(confirmation){
            case 'Y':
                System.out.println("\n🎉 Success!");
                System.out.println("✅ You have borrowed " + bookName);
                System.out.println("📅 Please return it by: " + dueDate.format(formatter));
                System.out.println("\n\n==================================================");
                System.out.println("      Thank you for using the library system!        ");
                System.out.println("==================================================");
                break;
            case 'N':
                System.out.println(">> Borrowing Cancelled");
                System.out.println("--------------------------------------------------");
                System.out.println("❌ The book was not borrowed.");
                System.out.println("ℹ️  Returning to book selection menu...");
                System.out.println("--------------------------------------------------");
                break;

            default:
                System.out.println("Invalid input.");
        }
        
    }

    //This is the method that displays the categories and the books it contain.
    public static void displayBooksForCategory(String code, Map<String, String> names, Map<String, List<Book>> books, String fullName, Scanner scanner){

        String categoryName = names.get(code);
        //List of the "Books" objects. This code basically tells the computer to "create a List of Books called 'bookList' and its content should be the books inside the category(code) that the user chose."
        List<Book> bookList = books.get(code);

        
        if (bookList == null || bookList.isEmpty()) {
            System.out.println("\n>> No books available in this category.");
            return;
        }

        System.out.println("\n\n>> Available Books in Category " + categoryName);
        System.out.println("------------------------------------------");

        //This is a for loop that displays all the books available in the category that the user chose.
        for(int i = 0; i< bookList.size(); i++){
            System.out.printf("[%d] %s%n", i+1, bookList.get(i).title);
        }

        //The variable for the book choice of the user.
        int choice = -1;

        /*A while loop that contains the logic for asking the user to choose a book. The loop is crucial so that every time the user enter an invalid choice, the user can always enter another choice again. It avoids the system from finishing.*/
        while (true) { 
           System.out.printf("%nEnter book to borrow [1-%d]: ", bookList.size());
           if(scanner.hasNextInt()){
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 1 && choice <= bookList.size()){
                break;
            }else{
                System.out.println("Invalid selection. Please enter a number from the list");
            }
           }else{
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); 
           }
           
        }

        /*This code states that an object of a book called "selectedBook" is a book in the booklist that has a 'key' that the user chose.
        The operation 'choice - 1' is crucial because as what I've said above, every index in the bookList starts with 0. So if the user chose the book 2, in the bookLost, it is actually book 3 because of its first number which is 0. That's why we have to subtract 1 from the choice variable.
        */
        Book selectedBook = bookList.get(choice - 1);

        //This will get displayed after the user entered a book s/he wants to borrow. selectedBook.title is important to access the title and not the whole Book object itself.
        bookToBorrow(selectedBook.title, fullName, categoryName);

    }
}


