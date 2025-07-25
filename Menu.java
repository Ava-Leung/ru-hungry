package restaurant;
/**
 * Use this class to test your Menu method. 
 * This class takes in two arguments:
 * - args[0] is the menu input file
 * - args[1] is the output file
 * 
 * This class:
 * - Reads the input and output file names from args
 * - Instantiates a new RUHungry object
 * - Calls the menu() method 
 * - Sets standard output to the output and prints the restaurant
 *   to that file
 * 
 * To run: java -cp bin restaurant.Menu menu.in menu.out
 * 
 */
public class Menu {
    public static void main(String[] args) {

	// 1. Read input files
	// Option to hardcode these values if you don't want to use the command line arguments
	   
        //String inputFile = args[0];
        //String outputFile = args[1];
        String inputFile = "menu.in";
        String stockFile = "stock.in";
        String orderFile = "order1.in";
        String donationFile = "donate1.in";
        String restockFile = "restock1.in";
        String transactionFile = "transaction1.in";
        //String outputFile = "output.in";
	
        // 2. Instantiate an RUHungry object
        RUHungry rh = new RUHungry();


	// 3. Call the menu() method to read the menu
        rh.menu(inputFile);
        rh.createStockHashTable(stockFile);
        rh.updatePriceAndProfit();
        //readOrders(orderFile, rh);
        //readDonations(donationFile, rh);
        //readRestock(restockFile, rh);
        transactions(transactionFile, rh);

	// 4. Set output file
	// Option to remove this line if you want to print directly to the screen
       //StdOut.setFile(outputFile);

        //testing addTransactionNode
        //rh.addTransactionNode(new TransactionData("test", "1", 0, 0, true));
        //rh.addTransactionNode(new TransactionData("test", "2", 0, 0, true));
        //rh.addTransactionNode(new TransactionData("test", "3", 0, 0, true));

	// 5. Print restaurant
        rh.printRestaurant();
        //rh.createStockHashTable(stockFile);
        //rh.printRestaurant();
        //rh.updatePriceAndProfit();
        //rh.printRestaurant();
        //rh.order(orderFile, rh);
        //rh.printRestaurant();
        //rh.donation(donationFile, rh);
        //rh.printRestaurant();
        //rh.updateRestock(restockFile, rh);
        //rh.printRestaurant();

    }

    public static void readOrders(String inputFile, RUHungry rh){
        StdIn.setFile(inputFile);
        int numOfOrders = Integer.parseInt(StdIn.readLine());
        for(int i = 0; i < numOfOrders; i++){
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.order(item, amount);
        }
    }

    public static void readDonations(String inputFile, RUHungry rh){
        StdIn.setFile(inputFile);
        int numOfDonations = Integer.parseInt(StdIn.readLine());
        for(int i = 0; i < numOfDonations; i++){
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.donation(item, amount);
        }
    }

    public static void readRestock(String inputFile, RUHungry rh){
        StdIn.setFile(inputFile);
        int numOfRestock = Integer.parseInt(StdIn.readLine());
        for(int i = 0; i < numOfRestock; i++){
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                rh.restock(item, amount);
        }
    }

    public static void readOrdersDish(String dishName, int quantity, RUHungry rh){
        rh.order(dishName, quantity);
    }

    public static void readDonationsDish(String dishName, int quantity, RUHungry rh){
        rh.donation(dishName, quantity);
    }

    public static void readRestockDish(String dishName, int quantity, RUHungry rh){
        rh.restock(dishName, quantity);
    }

    public static void transactions(String inputFile, RUHungry rh){
        StdIn.setFile(inputFile);
        int numOfTransactions = StdIn.readInt();
        StdIn.readLine();
        for(int i = 0; i < numOfTransactions; i++){
                String type = StdIn.readString();
                StdIn.readChar();
                int amount = StdIn.readInt();
                StdIn.readChar();
                String item = StdIn.readLine();
                if(type.equals("order")){
                        readOrdersDish(item, amount, rh);
                }else if(type.equals("donation")){
                        readDonationsDish(item, amount, rh);
                }else if (type.equals("restock")){
                        readRestockDish(item, amount, rh);
                }
        }
    }
}
