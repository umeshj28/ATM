import java.util.Scanner;
 
public class ATM{
private double balence;
private String[] transactions;
private int transactionCount;

public ATM(){
this.balence=0.0;
this.transactions=new String[10];
this.transactionCount=0;
}

public void startATM(double amount){
this.balence=amount;
}

public void depositMoney(double amount){
this.balence+=amount;
addTransaction(String.format("Deposit: Rs.%.2f", amount));
}

public void withdrawMoney(double amount){
this.balence-=amount;
addTransaction(String.format("Withdrawal: Rs.%.2f", amount));
}

public void addTransaction(String transcation){
transactions[transactionCount] = transcation;
transactionCount  = transactionCount + 1;
}

public double getBalance(){
return this.balence;
}
public void Transactionhistory(){
System.out.println("Mini Statement:");
for (int i=0; i<transactionCount;i++){
System.out.println(transactions[i]);
}
}

public static void main(String[] args){
Scanner sc=new Scanner(System.in);
ATM atm=new ATM();
System.out.print("Enter initial balance: ");
double initialBalance=sc.nextDouble();
atm.startATM(initialBalance);
while (true) 
{
System.out.println("1. Deposit Money");
System.out.println("2. Withdraw Money");
System.out.println("3. Check Balance");
System.out.println("4. Get Mini Statement");
System.out.print("Enter your choice: ");
int choice = sc.nextInt();
if (choice == 5) 
{
break;
}
switch (choice) 
{
	case 1:
	System.out.print("Enter deposit amount: ");
	double depositAmount=sc.nextDouble();
	atm.depositMoney(depositAmount);
	break;

	case 2:
	System.out.print("Enter withdrawal amount: ");
	double withdrawAmount=sc.nextDouble();
	atm.withdrawMoney(withdrawAmount);
	break;

	case 3:
	System.out.println("Final balance: INR " + atm.getBalance());
	break;

	case 4:
	System.out.println("Priting mini statement: ");
	atm.Transactionhistory();
	break;
	
	default:
	System.out.println("Invalid choice!");
	continue;
}
}
sc.close();
}
}


