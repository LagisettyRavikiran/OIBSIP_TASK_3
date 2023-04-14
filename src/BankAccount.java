
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ravikiran
 */
class BankAccount {

    String Name;
	String UserName;
	String password;
	String accountNo;
	float balance = 20000f;
	int Funding = 0;
	String FundingHistory = "";

    boolean Login() {
        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 boolean Login = false;
		Scanner sc = new Scanner(System.in);
		while ( !Login ) {
			System.out.print("\nEnter Username: ");
			String Username = sc.nextLine();
			if ( Username.equals(UserName) ) {
				while ( !Login ) {
					System.out.print("\nEnter Password: ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("\nLogin successful!!");
						Login = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return Login;
    }

    void Registration() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Name - ");
		this.Name = sc.nextLine();
		System.out.print("\nEnter Your Username - ");
		this.UserName = sc.nextLine();
		System.out.print("\nEnter Your Password - ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number - ");
		this.accountNo = sc.nextLine();
		System.out.println("\nThank you for Registration, Login to get access!!! ");
    }

    void FundHistory() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    if ( Funding == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + FundingHistory);
		}
	}

    void Balance() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.println("\n" + balance + " Rs");
    }

    void Transaction() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Reciever's Name - ");
		String Reciever = sc.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					Funding++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + Reciever);
					String str = amount + " Rs transfered to " + Reciever + "\n";
					FundingHistory = FundingHistory.concat(str);
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
    }
    

    void Deposit() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 20000f ) {
				Funding++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				FundingHistory = FundingHistory.concat(str);
			}
			else {
				System.out.println("\n Soory , The limit is 20000!!!");
			}
			
		}
		catch ( Exception e) {
		}
    }

    void draw() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    System.out.print("\nEnter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				Funding++;
				balance -= amount;
				System.out.println("\nSuccessfully Completed Withdrawl!!!");
				String str = amount + " Rs Withdrawed\n";
				FundingHistory = FundingHistory.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
    }
    
    
}
