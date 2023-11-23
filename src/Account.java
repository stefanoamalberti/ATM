// Account.java
// Represents a bank account

public class Account 
{
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private long availableBalance; // funds available for withdrawal
   private long totalBalance; // funds available + pending deposits

   // Account constructor initializes attributes
   public Account( int theAccountNumber, int thePIN, 
      long theAvailableBalance, long theTotalBalance )
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   } // end Account constructor

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // end method validatePIN
   
   // returns available balance
   public long getAvailableBalance()
   {
      return availableBalance;
   } // end getAvailableBalance

   // returns the total balance
   public long getTotalBalance()
   {
      return totalBalance;
   } // end method getTotalBalance

   // credits an amount to the account
   public void credit( long amount )
   {
      totalBalance += amount; // add to total balance
   } // end method credit

   // debits an amount from the account
   public void debit( long amount )
   {
      availableBalance -= amount; // subtract from available balance
      totalBalance -= amount; // subtract from total balance
   } // end method debit

   // returns account number
   public int getAccountNumber()
   {
      return accountNumber;  
   } // end method getAccountNumber
} // end class Account


/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/