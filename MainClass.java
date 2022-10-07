package Sde;

import java.util.*;

public class MainClass {
    int g1 = 0;
            long g2 = 0;
    Map<Integer, Bank> map = new Hashtable<Integer, Bank>();
    Map<Integer, LoadCash> loadMap = new HashMap<>();

    public boolean accountComparision(int accn){

        for(Map.Entry<Integer, Bank> entry:map.entrySet()){
//            int key=entry.getKey();
            Bank b=entry.getValue();
            if(b.AccNo==accn)
            {

                g1=b.pinNo;
                g2=b.AccNo;
                return true;

            }
//            System.out.println(b.AccNo);
        }


        return false;
    }
    public boolean pinVerify(int temPi)
    {

         if(g1==temPi)
         {
             return true;
         }
         else
         {
             return false;
         }
        }

    void cDeposit(int dAmount,int twok,int fivehun,int hun)
    {
        if ((2000 * twok + 500 * fivehun + 100 * hun) == dAmount) {
            for(Map.Entry<Integer, Bank> entry:map.entrySet())
            {
                Bank b=entry.getValue();
                if(g2==b.AccNo){
                    System.out.println("Previous balance = "+b.Accountbalance);
                    b.Accountbalance+=dAmount;
                    System.out.println("Current balance = "+b.Accountbalance);
                }
            }
            for (Map.Entry<Integer, LoadCash> e : loadMap.entrySet()) {
                int k = e.getKey();
                LoadCash lq = e.getValue();
                if (k == 1) {
                    lq.number += twok;
                } else if (k == 2) {
                    lq.number += fivehun;
                } else if (k == 3) {
                    lq.number += hun;
                }

            }
        }
        else
        {
            System.out.println("No. of denominations mismatch\n");
        }
    }
    void cWithdrawal(int withAmo){
        cashupdater(withAmo);
        for(Map.Entry<Integer, Bank> entry:map.entrySet())
        {
            Bank b=entry.getValue();
            if(b.Accountbalance>withAmo){

                System.out.println("Previous balance = "+b.Accountbalance);
                b.Accountbalance-=withAmo;
                System.out.println("Current balance = "+b.Accountbalance);
                break;

            }else{
                System.out.println("Insufficient balance");
                break;
            }
        }

    }
    void cashupdater(int amt)
    {
        int twok1=0,fivehun1=0,hun1=0;
        int r=0;
        if(amt>=5000)
        {
            twok1=2; //5
            fivehun1=(amt-4000)/500; //7
            hun1=((amt-4000)%500)/100; //2
        }
        else if(amt<5000)
        {
            int u=0;
            if(amt>1500)
            {
                amt=amt-1000;
                u=10;
            }
            twok1=amt/2000; //5
            fivehun1=(amt%2000)/500; //7
            hun1=((amt%2000)%500)/100;
            hun1=hun1+u;
        }
        for(Map.Entry<Integer, LoadCash> e:loadMap.entrySet())
        {
            int k=e.getKey();
            LoadCash lq=e.getValue();
            if(k==1 && lq.number<twok1)
            {
                r=1;
            }
            else if(k==2 && lq.number<twok1)
            {
                r=1;
            }
            else if(k==3 && lq.number<twok1)
            {
                r=1;
            }
        }
        if(r==1)
        {
            System.out.println("Unable to dispense the amount");

        }
        else
        {
            for(Map.Entry<Integer, LoadCash> e:loadMap.entrySet())
            {
                int k=e.getKey();
                LoadCash lq=e.getValue();
                if(k==1)
                {
                    lq.number-=twok1;
                }
                else if(k==2)
                {
                    lq.number-=fivehun1;
                }
                else if(k==3)
                {
                    lq.number-=hun1;
                }
            }
        }
    }

    void cBalance()
    {
        for(Map.Entry<Integer, Bank> entry:map.entrySet())
        {
            Bank b=entry.getValue();
            if(g2==b.AccNo){

                System.out.println("Available balance = "+b.Accountbalance);

            }
        }
    }
    void cTransfer(int receiveracc,int amount)
    {

        for(Map.Entry<Integer, Bank> entry:map.entrySet())
        {
            Bank b=entry.getValue();
            if(receiveracc==b.AccNo)
            {
                b.Accountbalance+=amount;
            }
        }
        for(Map.Entry<Integer, Bank> entry:map.entrySet())
        {
            Bank b=entry.getValue();
            if(g2==b.AccNo){
                System.out.println("Previous balance = "+b.Accountbalance);
                b.Accountbalance-=amount;
                System.out.println("Current balance = "+b.Accountbalance);
            }
        }
    }

    void sDeposit(int amt,int twok,int fivehun,int hun) {
        if((2000*twok + 500*fivehun + 100*hun)==amt) {
            for (Map.Entry<Integer, LoadCash> e : loadMap.entrySet()) {
                int k = e.getKey();
                LoadCash lq = e.getValue();
                if (k == 1) {
                    lq.number += twok;
                } else if (k == 2) {
                    lq.number += fivehun;
                } else if (k == 3) {
                    lq.number += hun;
                }

            }
        }
        else
        {
            System.out.println("No. of denominations mismatch\n");
        }
    }
    void sAtmBalance() {
        int total=0;
        System.out.println("denominations"+" "+"number"+" "+"Value");
        for(Map.Entry<Integer, LoadCash> entry:loadMap.entrySet()){
            int key=entry.getKey();
            LoadCash b=entry.getValue();
//            System.out.println(key+" Details:");

          System.out.println(b.denominations+"        "+b.number+"   "+b.denominations*b.number);
          total+=(b.denominations*b.number);
        }
        System.out.println("Total Amount available in the ATM ="+total);
    }
    void allcustbalance() {
        int total=0;
        System.out.println("AccNo"+" "+"AccountHolder"+" "+"pinNo"+" "+"Accountbalance");
        for(Map.Entry<Integer, Bank> entry:map.entrySet()){
//            int key=entry.getKey();
            Bank b=entry.getValue();
//            System.out.println(key+" Details:");
          System.out.println(b.AccNo+" "+b.AccountHolder+" "+b.pinNo+" "+b.Accountbalance);
        }
    }
    public void display(){

        //Creating map of Books

        //Creating objects
        Bank b1=new Bank(101,"Suresh",2343,25234);
        Bank b2=new Bank(102,"Ganesh ",5432,34123);
        Bank b3=new Bank(103,"Magesh",7854,26100);
        Bank b4=new Bank(104,"Naresh",2345,80000);
        Bank b5=new Bank(105,"Harish",1907,103400);

        LoadCash l1 = new LoadCash(2000,20);
        LoadCash l2 = new LoadCash(500,100);
        LoadCash l3 = new LoadCash(100,100);

        //Operation
        Operation o = new Operation();

        //Adding objects to map
        map.put(1,b1);
        map.put(2,b2);
        map.put(3,b3);
        map.put(4,b4);
        map.put(5,b5);

        //Adding objects to map
        loadMap.put(1,l1);
        loadMap.put(2,l2);
        loadMap.put(3,l3);

        //Traversing map
        for(Map.Entry<Integer, Bank> entry:map.entrySet()){
//            int key=entry.getKey();
            Bank b=entry.getValue();
//            System.out.println(key+" Details:");
//            System.out.println(b.AccNo+" "+b.AccountHolder+" "+b.pinNo+" "+b.Accountbalance);
        }
        //Traversing loadmap
        for(Map.Entry<Integer, LoadCash> entry:loadMap.entrySet()){
            int key=entry.getKey();
            LoadCash b=entry.getValue();
//            System.out.println(key+" Details:");
//            System.out.println(b.denominations+" "+b.number+" "+b.denominations*b.number);
        }
    }

}