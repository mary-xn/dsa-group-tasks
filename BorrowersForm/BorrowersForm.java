import java.util.Scanner;

public class BorrowersForm {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String studentId, fullName, programSection, bookCategory;
        int bookNumber;

        System.out.println("==========================================");
        System.out.println("    \uD83D\uDCDA LIBRARY BORROWER'S FORM   ");
        System.out.println("==========================================\n\n");

        System.out.println(">> Enter Borrower Informaton");
        System.out.println("------------------------------------------");
        studentId = inputWithValidation(scanner, "Student ID");
        fullName = inputWithValidation(scanner, "Full Name");
        programSection = inputWithValidation(scanner, "Program & Section");

        
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

        switch (bookCategory){
            case "000" :
                System.out.println("\n\n>> Available Books in Category 000 - General Works, Computer Science, Information ");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] The Information: A History, a Theory, a Flood \u2013 James Gleick
                                   [2] Computer Science Illuminated \u2013 Nell Dale
                                   [3] How to Read a Book \u2013 Mortimer Adler
                                   [4] Artificial Intelligence: A Modern Approach \u2013 Russell & Norvig
                                   [5] Digital Minimalism \u2013 Cal Newport
                                   [6] The Master Algorithm \u2013 Pedro Domingos""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            case "100" :
                System.out.println("\n\n>> Available Books in Category 100 - Philosophy & Psychology");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] Thinking, Fast and Slow \u2013 Daniel Kahneman
                                   [2] Meditations \u2013 Marcus Aurelius
                                   [3] The Power of Now \u2013 Eckhart Tolle
                                   [4] The Republic \u2013 Plato
                                   [5] Man's Search for Meaning \u2013 Viktor E. Frankl
                                   [6] The Art of War \u2013 Sun Tzu""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            case "200" :
                System.out.println("\n\n>> Available Books in Category 200 - Religion");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] Mere Christianity \u2013 C.S. Lewis
                                   [2] The Case for Christ \u2013 Lee Strobel
                                   [3] The Bhagavad Gita \u2013 Eknath Easwaran
                                   [4] The Quran \u2013 Translation by M.A.S. Abdel Haleem
                                   [5] The Bible \u2013 NIV Translation
                                   [6] The Tao Te Ching \u2013 Laozi""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            case "300" :
                System.out.println("\n\n>> Available Books in Category 300 - Social Sciences");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] Freakonomics \u2013 Steven D. Levitt & Stephen J. Dubner
                                   [2] The Tipping Point \u2013 Malcolm Gladwell
                                   [3] Guns, Germs, and Steel \u2013 Jared Diamond
                                   [4] Outliers \u2013 Malcolm Gladwell
                                   [5] The Righteous Mind \u2013 Jonathan Haidt
                                   [6] Quiet \u2013 Susan Cain""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            case "400" :
                System.out.println("\n\n>> Available Books in Category 400 - Language");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] The Elements of Style \u2013 William Strunk Jr. & E.B. White
                                   [2] Eats, Shoots & Leaves \u2013 Lynne Truss
                                   [3] English Grammar in Use \u2013 Raymond Murphy
                                   [4] Fluent Forever \u2013 Gabriel Wyner
                                   [5] The Sense of Style \u2013 Steven Pinker
                                   [6] Word Power Made Easy \u2013 Norman Lewis""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            case "500" :
                System.out.println("\n\n>> Available Books in Category 500 - Science");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] A Brief History of Time \u2013 Stephen Hawking
                                   [2] The Selfish Gene \u2013 Richard Dawkins
                                   [3] Cosmos \u2013 Carl Sagan
                                   [4] Astrophysics for People in a Hurry \u2013 Neil deGrasse Tyson
                                   [5] The Elegant Universe \u2013 Brian Greene
                                   [6] The Origin of Species \u2013 Charles Darwin""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            case "600" :
                System.out.println("\n\n>> Available Books in Category 400 - Technology (Applied Sciences)");
                System.out.println("------------------------------------------");
                System.out.println("""
                                   [1] Clean Code \u2013 Robert C. Martin
                                   [2] The Pragmatic Programmer \u2013 Andrew Hunt
                                   [3] Introduction to Algorithms \u2013 Cormen, Leiserson, Rivest, and Stein
                                   [4] Code: The Hidden Language of Computer Hardware and Software \u2013 Charles Petzold
                                   [5] Design Patterns \u2013 Erich Gamma et al.
                                   [6] Computer Networking: A Top-Down Approach \u2013 Kurose & Ross""");
                System.out.print("\nEnter book to borrow [1-6]: ");
                bookNumber = scanner.nextInt();
                break;

            default :
                System.out.println("Option unavailable.");
                break;

        }
    }

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
}
