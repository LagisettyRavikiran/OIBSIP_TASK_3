import java.util.Scanner;
class Bank {
	String Name;
	String UserName;
	String password;
	String accountNo;
	float balance = 20000f;
	int Funding = 0;
	String FundingHistory = "";
	public void Registration() {
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
	public boolean Login() {
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
	public void draw() {
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
	public void Deposit() {
		
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
	public void Transaction() {
		
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
	public void Balance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void FundHistory() {
		if ( Funding == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + FundingHistory);
		}
	}
 }
public class AtmInterface {
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Enter the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		}
		return input;
	}
	public static void main(String[] args) {
		
		System.out.println("\n..........OASIS INFOBYTE ATM............\n");
		System.out.println("1.Register \n2.Quit");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			BankAccount b = new BankAccount();
			b.Registration();
			while(true) {
				System.out.println("\n1.Login \n2.Quit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.Login()) {
						System.out.println( "\n\n**********WELCOME BACK OASIS INFOBYTE ATM*********\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1 -> b.draw();
								case 2 -> b.Deposit();
								case 3 -> b.Transaction();
								case 4 -> b.Balance();
								case 5 -> b.FundHistory();
								case 6 -> isFinished = true;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
		
		
		
	}
}	