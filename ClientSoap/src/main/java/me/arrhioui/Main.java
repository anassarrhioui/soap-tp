package me.arrhioui;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BankService bankService = new Se().getBankServicePort();
        System.out.println(bankService.conversion(200));
        System.out.println(bankService.getCompte(43));

    }
}