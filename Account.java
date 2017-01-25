/**
 * A class that maintains information on an account.
 * This might form part of a larger application such
 * as a Bank system, for instance.
 *
 * @author Jarred Black 101000247
 * @version 1/24/17
 */
public class Account {
    //stores account  ID in an int
    private int id;
    //stores the name associated with the account in 1 string
    private String name;
    //stores the balance of the account in a double
    private double balance;

    public Account(int id, String name){
        this.name = name;
        this.id = id;
    }
    public Account(int id, String name, float balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public double setBalance(double amount){
        this.balance = amount;
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            return balance;
        } else {
            balance = this.balance + amount;
            return balance;
        }
    }

    public double withdraw(double amount){
        if(this.balance < amount || amount < 0){
            System.err.println("Amount to be withdrawn exceeds the balance");
            return 0;
        }
        else{
            this.balance = balance - amount;
            return this.balance;
        }
    }

    public void transferTo(Account account, double amountToBeTransfered){
        if(this.balance < amountToBeTransfered || amountToBeTransfered < 0 || account == null){
            System.err.println("Amount to be withdrawn exceeds the balance");
        }
        else{
            this.balance = balance - amountToBeTransfered;
            account.balance = account.balance + amountToBeTransfered;
        }
    }

    public String toString(Account account){
        StringBuilder response = new StringBuilder();
        response.append("Account [id=");
        response.append(account.getId());
        response.append(", name=");
        response.append(account.getName());
        response.append(", balance=$");
        response.append(getBalance());
        response.append("]");
        return response.toString();
    }

    public void print(Account account){
        System.out.println(toString(account));
    }
}
