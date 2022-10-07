package Sde;
import com.sun.source.tree.Tree;

import java.util.*;
class Bank {
    long AccNo;
    String AccountHolder;
    int pinNo;
    double Accountbalance;
    public Bank(long AccNo, String AccountHolder,int pinNo,double Accountbalance) {
        this.AccNo = AccNo;
        this.AccountHolder = AccountHolder;
        this.pinNo=pinNo;
        this.Accountbalance=Accountbalance;
    }
}