import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BorrowersForm {
    /*The class "Book" is used for the books to have a blueprint. This makes it easier for us to assign the title for each book and not redo it again and again.*/
    static class Book{
        String title, author;
        boolean availability;

        //This is the constructor. It helps us assign the book's title right after we create a Book object.
        public Book(String title, String author, boolean availability){
            this.title = title;
            this.author = author;
            this.availability = true;
        }

        //Availability method to be added.
        public boolean isAvailable(){
            return this.availability;
        }

        public void setAvailability(boolean availability){
           this.availability = availability;
        }

        public void getAvailabilityStatus(){
            System.out.println("\n\n>> Book Availability Status");
            System.out.println("--------------------------------------------------");
            System.out.println("Title\t: " + this.title);
            System.out.println("Author\t: " + this.author);
            
            if (this.availability == true){
                System.out.println("Status\t: ✅ Available");
            }else{
                System.out.println("Status\t: ❌ Not Available");
            }
        }
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
            new Book("The Information: A History, a Theory, a Flood", "James Gleick", true),
            new Book("Computer Science Illuminated", "Nell Dale", true),
            new Book("How to Read a Book", "Mortimer Adler", true),
            new Book("Artificial Intelligence: A Modern Approach", "Russell & Norvig", true),
            new Book("Digital Minimalism", "Cal Newport", true),
            new Book("The Master Algorithm", "Pedro Domingos", true)
        ));

        categoryBooks.put("100", List.of(
            new Book("Thinking, Fast and Slow", "Daniel Kahneman", true),
            new Book("Meditations", "Marcus Aurelius", true),
            new Book("The Power of Now", "Eckhart Tolle", true),
            new Book("The Republic", "Plato", true),
            new Book("Man's Search for Meaning", "Viktor E. Frankl", true),
            new Book("The Art of War", "Sun Tzu", true)
        ));

        categoryBooks.put("200", List.of(
            new Book("Mere Christianity", "C.S. Lewis", true),
            new Book("The Case for Christ", "Lee Strobel", true),
            new Book("The Bhagavad Gita", "Eknath Easwaran", true),
            new Book("The Quran – Translation", "M.A.S. Abdel Haleem", true),
            new Book("The Bible", "NIV Translation", true),
            new Book("The Tao Te Ching", "Laozi", true)
        ));

        categoryBooks.put("300", List.of(
            new Book("Freakonomics","Steven D. Levitt & Stephen J. Dubner", true),
            new Book("The Tipping Point", "Malcolm Gladwell", true),
            new Book("Guns, Germs, and Steel"," Jared Diamond", true),
            new Book("Outliers", "Malcolm Gladwell", true),
            new Book("The Righteous Mind", "Jonathan Haidt", true),
            new Book("Quiet", "Susan Cain", true)
        ));

        categoryBooks.put("400", List.of(
            new Book("The Elements of Style", "William Strunk Jr. & E.B. White", true),
            new Book("Eats, Shoots & Leaves","Lynne Truss", true),
            new Book("English Grammar in Use","Raymond Murphy", true),
            new Book("Fluent Forever","Gabriel Wyner", true),
            new Book("The Sense of Style","Steven Pinker", true),
            new Book("Word Power Made Easy","Norman Lewis", true)
        ));

        categoryBooks.put("500", List.of(
            new Book("A Brief History of Time","Stephen Hawking", true),
            new Book("The Selfish Gene","Richard Dawkins", true),
            new Book("Cosmos","Carl Sagan", true),
            new Book("Astrophysics for People in a Hurry","Neil deGrasse Tyson", true),
            new Book("The Elegant Universe","Brian Greene", true),
            new Book("The Origin of Species","Charles Darwin", true)
        ));

        categoryBooks.put("600", List.of(
            new Book("Clean Code","Robert C. Martin", true),
            new Book("The Pragmatic Programmer","Andrew Hunt", true),
            new Book("Introduction to Algorithms","Cormen, Leiserson, Rivest, and Stein", true),
            new Book("Code: The Hidden Language of Computer Hardware and Software","Charles Petzold", true),
            new Book("Design Patterns","Erich Gamma et al.", true),
            new Book("Computer Networking: A Top-Down Approach","Kurose & Ross", true)
        ));

        categoryBooks.put("700", List.of(
            new Book("The Story of Art","E.H. Gombrich", true),
            new Book("Ways of Seeing","John Berger", true),
            new Book("Steal Like an Artist","Austin Kleon", true),
            new Book("The War of Art","Steven Pressfield", true),
            new Book("On Photography","Susan Sontag", true),
            new Book("Understanding Comics","Scott McCloud", true)
        ));

        categoryBooks.put("800", List.of(
            new Book("The Great Gatsby","F. Scott Fitzgerald", true),
            new Book("1984","George Orwell", true),
            new Book("To Kill a Mockingbird","Harper Lee", true),
            new Book("The Odyssey","Homer", true),
            new Book("Pride and Prejudice"," Jane Austen", true),
            new Book("Hamlet","William Shakespeare", true)
        ));

        categoryBooks.put("900", List.of(
            new Book("Sapiens: A Brief History of Humankind","Yuval Noah Harari", true),
            new Book("A People's History of the United States","Howard Zinn", true),
            new Book("Guns, Germs, and Steel","Jared Diamond", true),
            new Book("The Silk Roads","Peter Frankopan", true),
            new Book("Postwar","Tony Judt", true),
            new Book("The History of the Ancient World","Susan Wise Bauer", true)
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
        /* .containsKey() is also a method in Map in Java that returs a boolean(true/false). 
        It asks "Does the Map called categoryNames contains the key that the user entered?"
        */
        if (categoryNames.containsKey(bookCategory)){
            displayBooksForCategory(bookCategory, categoryNames, categoryBooks, fullName, scanner);
        }else{
            System.out.println("❌ Invalid category code. Please restart and enter a valid one.");
        }
    }

    public static void exitSystem(){
        System.out.println("\n\nExiting...");
        System.out.println("--------------------------------------------------");
        System.out.println("No book was borrowed.");
        System.out.println("Thank you for visiting the library!");
    }

    //To be explained in person.
    public static String inputWithValidation(Scanner scanner, String fieldName){
        while(true){
                String input;
                System.out.printf("%-20s: ", fieldName);
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

                    if (input.matches(".*(?i)([a-z])\\1.*")) {
                        System.out.println("Full Name cannot contain repeated letters. Please try again.");
                        continue;
                    }
                }else if (fieldName.equals("Program")) {
                    if (!input.matches("^[a-zA-Z\\s]+$")){
                        System.out.println("Program can only contain letters and spaces. Please try again.");
                        continue;
                    }
                }else {
                    if (!input.matches("^[a-zA-Z0-9\\s.-]+$")) {
                        System.out.println("Input can only contain letters, numbers, spaces, periods, and hyphens.");
                        continue;
                    }

                    if (input.matches(".*(?i)([a-z])\\1.*")) {
                        System.out.println("Input cannot contain repeated letters. Please try again.");
                        continue;
                    }
                }
                return input;
            
        }
    }

    //This is the method that will help us print out the confirmation form.
    public static void borrowingConfirmation(String bookName, String fullName, String categoryName){
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
        System.out.println("Category\t:" + categoryName);
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
                System.out.println("\n\nNote: This title is now marked as Not Available.");
                System.out.println("\n\n==================================================");
                System.out.println("      Thank you for using the library system!        ");
                System.out.println("==================================================");
                break;
            case 'N':
                System.out.println(">> Borrowing Cancelled");
                System.out.println("--------------------------------------------------");
                System.out.println("❌ The book was not borrowed.");
                System.out.println("ℹ️  Exiting the system...");
                System.out.println("--------------------------------------------------");
                break;

            default:
                System.out.println("Invalid input.");
        }
        
    }

    //This is the method that displays the categories and the books it contain.
    public static void displayBooksForCategory(String code, Map<String, String> names, Map<String, List<Book>> books, String fullName, Scanner scanner){

        String categoryName = names.get(code);
        /*List of the "Books" objects. 
        This code basically tells the computer to "create a List of Books called 'bookList' 
        and its content should be the books inside the category(code) that the user chose."
        */
        List<Book> bookList = books.get(code);

        
        if (bookList == null || bookList.isEmpty()) {
            System.out.println("\n>> No books available in this category.");
            return;
        }

        System.out.println("\n\n>> Available Books in Category " + categoryName);
        System.out.println("------------------------------------------");

        //This is a for loop that displays all the books available in the category that the user chose.
        for(int i = 0; i< bookList.size(); i++){
            System.out.printf("[%d] %s by %s%n", i+1, bookList.get(i).title, bookList.get(i).author);
        }

        //The variable for the book choice of the user.
        int choice = -1;

        /*A while loop that contains the logic for asking the user to choose a book. 
        The loop is crucial so that every time the user enter an invalid choice, 
        the user can always enter another choice again. It avoids the system from finishing.*/
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
        The operation 'choice - 1' is crucial because as what I've said above, every index in the bookList starts with 0. 
        So if the user chose the book 2, in the bookList, it is actually book 3 because of its first number which is 0. 
        That's why we have to subtract 1 from the choice variable.
        */
        Book selectedBook = bookList.get(choice - 1);
        selectedBook.getAvailabilityStatus();

        if (selectedBook.availability){
            /*This will get displayed after the user entered a book s/he wants to borrow. 
            'selectedBook.title' is important to access the title and not the whole Book object itself.
            Revisit the borrowingConfirmation() method above to understand what it does.*/
            borrowingConfirmation(selectedBook.title, fullName, categoryName);
            selectedBook.setAvailability(false);
        }else{
            int choiceForUnavailableBook = 0;
            System.out.println("What would you like to do?");
            System.out.println("--------------------------------------------------");
            System.out.println("[1] Choose another book");
            System.out.println("[2] Reserve this book");
            System.out.println("[3] Exit");

            switch(choiceForUnavailableBook){
                case 1:
                    displayBooksForCategory(code, names, books, fullName, scanner);
                    break;
                case 2:
                    exitSystem();
                    break;
                default:
                    System.out.println("Option unavailable. ");
                    exitSystem();
            }
        }

    }
}


