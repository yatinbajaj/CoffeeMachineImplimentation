//package machine;

import java.util.Scanner;
// Other imports go here
// Do NOT change the class name
//package machine;

public class coffeeMachine {
    private int water,milk,coffee,amount,disposable;
    coffeeMachine(int water,int milk,int coffee,int amount,int disposable)
    {
        this.water=water;
        this.milk=milk;
        this.coffee=coffee;
        this.amount=amount;
        this.disposable=disposable;
    }


    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDisposable(int disposable) {
        this.disposable = disposable;
    }

    public int getWater() {
        return water;
    }
    public int getMilk() {
        return milk;
    }
    public int getAmount() {
        return amount;
    }
    public int getCoffee() {
        return coffee;
    }
    public int getDisposable() {
        return disposable;
    }
    public  void espresso()
    {
        if(getWater()>=250 &&getCoffee()>=16&&getDisposable()>=1)
        {
            System.out.println("I have enough resources, making you a coffee!");
            water-=250;
            coffee-=16;
            amount+=4;
            disposable-=1;
        }
        else
        {
            if(water<250)
                System.out.println("Sorry, not enough water!");
            if(coffee<16)
                System.out.println("Sorry, not enough coffee!");
            if(disposable<1)
                System.out.println("Sorry, not enough disposable!");
        }

    }
    public  void latte()
    {
        if(getWater()>=350 &&getCoffee()>=20&&getDisposable()>=1&&getMilk()>=75)
        {
            water-=350;
            milk-=75;
            coffee-=20;
            amount+=7;
            disposable-=1;
        }
        else
        {
            if(water<350)
                System.out.println("Sorry, not enough water!");
            if(coffee<20)
                System.out.println("Sorry, not enough coffee!");
            if(disposable<1)
                System.out.println("Sorry, not enough disposable!");
            if(milk<75)
                System.out.println("Sorry, not enough disposable!");
        }
    }
    public  void cappuccino()
    {
        if(getWater()>=200 &&getCoffee()>=12&&getDisposable()>=1&&getMilk()>=100)
        {
            water-=200;
            milk-=100;
            coffee-=12;
            amount+=6;
            disposable-=1;
        }
        else
        {
            if(water<200)
                System.out.println("Sorry, not enough water!");
            if(coffee<12)
                System.out.println("Sorry, not enough coffee!");
            if(disposable<1)
                System.out.println("Sorry, not enough disposable!");
            if(milk<1000)
                System.out.println("Sorry, not enough disposable!");
        }
    }
    public void buy()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String ch=in.nextLine();
        switch(ch)
        {
            case "1":espresso();
                break;
            case "2":latte();
                break;
            case "3":cappuccino();
                break;
            case "back":break;
        }

    }
    public void fill(int water,int milk,int coffee,int disposable)
    {
        this.water+=water;
        this.milk+=milk;
        this.coffee+=coffee;
        this.disposable+=disposable;

    }
    public void take()
    {
        this.amount-=this.amount;

    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int intial_water=1200;
        int intial_milk=540;
        int intial_coffee=120;
        int intial_disposable=9;
        int intial_money=550;
//        System.out.println("The coffee machine has:");
//        System.out.println(intial_water+" of water");
//        System.out.println(intial_milk+" of milk");
//        System.out.println(intial_coffee+" of coffee beans");
//        System.out.println(intial_disposable+" of disposable cups");
//        System.out.println(intial_money+" of money");
        coffeeMachine cf=new coffeeMachine(intial_water,intial_milk,intial_coffee,intial_money,intial_disposable);
        while(true)
        {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String ch=input.next();
            switch(ch)
            {
                case "buy":cf.buy();
//                System.out.println("The coffee machine has:");
//                System.out.println(cf.getWater()+" of water");
//                System.out.println(cf.getMilk()+" of milk");
//                System.out.println(cf.getCoffee()+" of coffee beans");
//                System.out.println(cf.getDisposable()+" of disposable cups");
//                System.out.println(cf.getAmount()+" of money");
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    int add_water=input.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int add_milk=input.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int add_coffee=input.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int add_disposable=input.nextInt();
                    cf.fill(add_water,add_milk,add_coffee,add_disposable);
//                System.out.println("The coffee machine has:");
//                System.out.println(cf.getWater()+" of water");
//                System.out.println(cf.getMilk()+" of milk");
//                System.out.println(cf.getCoffee()+" of coffee beans");
//                System.out.println(cf.getDisposable()+" of disposable cups");
//                System.out.println(cf.getAmount()+" of money");
                    break;
                case "take":
                    System.out.println("I gave you "+cf.getAmount());
                    cf.take();
//                System.out.println("The coffee machine has:");
//                System.out.println(cf.getWater()+" of water");
//                System.out.println(cf.getMilk()+" of milk");
//                System.out.println(cf.getCoffee()+" of coffee beans");
//                System.out.println(cf.getDisposable()+" of disposable cups");
//                System.out.println(cf.getAmount()+" of money");
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(cf.getWater()+" of water");
                    System.out.println(cf.getMilk()+" of milk");
                    System.out.println(cf.getCoffee()+" of coffee beans");
                    System.out.println(cf.getDisposable()+" of disposable cups");
                    System.out.println(cf.getAmount()+" of money");
                    break;
                case "exit":System.exit(0);
                default:System.out.println("pls enter valid input");
            }
        }


    }
}