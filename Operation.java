package Sde;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        {
            MainClass m = new MainClass();
            Scanner sc = new Scanner(System.in);

            m.display();
            while (true) {
                System.out.println("1.Customer\n2.Servicemen");
                int temppin=0;
                switch (sc.nextInt()) {
                    case 1:System.out.println("Enter the account number:\n");
                        if (m.accountComparision(sc.nextInt()))
                        {
                            System.out.println("Enter the Pin no:\n");
                            temppin = sc.nextInt();
                            if (m.pinVerify(temppin))
                            {
                        while (true) {
                            System.out.println("1.Deposit\n2.Withdrawal\n3.Balance\n4.Bank transfer\n5.exit\n");
                            int ch = sc.nextInt();
                            switch (ch) {
                                case 1:

                                    System.out.println("Enter the Total amount to be deposited\n");
                                    int dAmount = sc.nextInt();
                                    System.out.println("Enter the denominations\n");

                                    System.out.println("2000 -  ");
                                    int twok = sc.nextInt();
                                    System.out.println("500 -   ");
                                    int fivehun = sc.nextInt();
                                    System.out.println("100-    ");
                                    int hun = sc.nextInt();
                                    m.cDeposit(dAmount, twok, fivehun, hun);


                                    break;
                                case 2:
                                    System.out.println("Enter the Withdrawal amount\n");
                                    int withAmo = sc.nextInt();
                                    m.cWithdrawal(withAmo);
                                    break;
                                case 3:
                                    m.cBalance();
                                    break;
                                case 4:
                                    System.out.println("Enter the Recipient Account Number -\n");
                                    int receiveracc = sc.nextInt();
                                    System.out.println("Enter the amount to be transferred -\n");
                                    int amount1 = sc.nextInt();
                                    m.cTransfer(receiveracc, amount1);
                                    break;
                                case 5:
                                    break;

                                default:
                                    System.out.println("Invalid details");
                                    break;
                            }
                            break;
                        }
                            }
                            else
                            {
                                System.out.println("invalid Pin");
                                break;
                            }
                        break;
                        }
                        else
                        {
                            System.out.println("invalid Accno");
                            break;
                        }


                    case 2:
                        System.out.println("Enter Atm access pin");
                        if(sc.nextInt()==12345) {
                            while (true) {
                                System.out.println("1.Deposit/Feed Money to ATM\n2.Check balance available in ATM\n3.Check Details of All the Customers\n4.exit");
                                int ch = sc.nextInt();
                                switch (ch) {
                                    case 1:
                                        System.out.println("Enter the Amount to be loaded\n");
                                        int amt = sc.nextInt();
                                        System.out.println("Enter the denominations first:\n ");
                                        System.out.println("2000 -  ");
                                        int twok1 = sc.nextInt();
                                        System.out.println("500 -   ");
                                        int fivehun1 = sc.nextInt();
                                        System.out.println("100-    ");
                                        int hun1 = sc.nextInt();
                                        m.sDeposit(amt, twok1, fivehun1, hun1);
                                        break;
                                    case 2:
                                        System.out.println("Atm Balance:\n");
                                        m.sAtmBalance();
                                        break;
                                    case 3:
                                        m.allcustbalance();
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("Invalid details");
                                        break;
                                }
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("Atm access pin Mismatch");
                        }

                }
//
            }
        }
    }
}
