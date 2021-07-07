import java.util.Scanner;

public class Machine {
    //machine state enum

    private enum State{
        READY,BUYING,EXIT, FILL_WATER, FILL_MILK, FILL_COFFEE, FILL_CUPS
    }

    //coffee variant enum
    private enum coffeeCup{
        ESPRESSO(250,0,16,1,4),
        LATTE(350,75,20,1,7),
        CAPPUCCINO(200,100,12,1,6);

        public final int water,milk,coffee,cup,amount;

        coffeeCup(int water,int milk,int coffee,int cup,int amount)
        {
            this.water=water;
            this.milk=milk;
            this.coffee=coffee;
            this.cup=cup;
            this.amount=amount;
        }

    }// coffee enum end

    private State state;
    private int water,milk,coffee,amount,cup;
    //Machine class constructor
    public Machine()
    {
        this.water=400;
        this.milk=540;
        this.coffee=120;
        this.cup=9;
        this.amount=550;
        setReady();
    }
    public boolean isExited(){
        return state==State.EXIT;
    }

    public  void process(String command)
    {
        switch (state)
        {
            case READY:onReady(command);
                break;
            case BUYING:
                processBuying(command);
                break;
            case FILL_WATER:
                water+=Integer.parseInt(command);
                set_milk();
                break;
            case FILL_MILK:
                milk+=Integer.parseInt(command);
                set_cup();
                break;
            case FILL_CUPS:
                cup+=Integer.parseInt(command);
                set_coffee();
                break;
            case FILL_COFFEE:
                coffee+=Integer.parseInt(command);
                setReady();
                break;
            case EXIT:
                throw new IllegalArgumentException("I'm switched off");
            default:
                throw new IllegalArgumentException("unknown state");
        }
    }
    private void onReady(String command)
    {
        switch(command)
        {
            case "buy":
                setBuying();
                break;
            case "take":
                take();
                break;
            case "fill":
                set_water();
                break;
            case "remaining":
                reportRemaining();
                break;
            case "exit":
                state=State.EXIT;
                break;
            default:
                throw new IllegalArgumentException("unknown command: "+command);

        }
    }

    private void setReady() {
        if (state != null) {
            System.out.println();
        }
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        state = State.READY;
    }

    public void processBuying(String command)
    {
        coffeeCup aCup;
        switch(command)
        {
            case "1":
                aCup=coffeeCup.ESPRESSO;
                break;
            case "2":
                aCup=coffeeCup.LATTE;
                break;
            case "3":
                aCup=coffeeCup.CAPPUCCINO;
                break;
            case "back":
                setReady();
                return;
            default:
                throw new IllegalArgumentException("unknown coffee");
        }
        if(check(aCup))
        {
            serve(aCup);
        }
        setReady();
    }
    private void serve(coffeeCup aCup) {
        System.out.println("I have enough resources, making you a coffee!");
        water -= aCup.water;
        milk -= aCup.milk;
        coffee -= aCup.coffee;
        cup -= 1;
        amount += aCup.amount;
    }
    private boolean check(coffeeCup aCup) {
        if (water < aCup.water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < aCup.milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffee < aCup.coffee) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cup < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }
    private void setBuying()
    {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        state=State.BUYING;
    }

    private void reportRemaining()
    {
        System.out.println("The coffee machine has:");
        System.out.println(water+" of water");
        System.out.println(milk+" of milk");
        System.out.println(coffee+" of coffee beans");
        System.out.println(cup+" of disposable cups");
        System.out.println(amount+" of money");
        setReady();
    }
    public void set_water()
    {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        state=State.FILL_WATER;
    }
    public void set_milk()
    {
        System.out.println();
        System.out.println("Write how many ml of milk do you want to add:");
        state=State.FILL_MILK;
    }
    public void set_coffee()
    {
        System.out.println();
        System.out.println("Write how many ml of coffee beans do you want to add:");
        state=State.FILL_COFFEE;
    }
    public void set_cup()
    {
        System.out.println();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        state=State.FILL_CUPS;
    }
    public void take()
    {
        System.out.println("I gave you $"+ amount);
        amount = 0;
        setReady();
    }

    public static void main(String[] args) {
        try{
            Scanner input=new Scanner(System.in);
            Machine cm=new Machine();
            //calling class isExit function to check exit state is called or not
            while(!cm.isExited()){
                String command=input.nextLine();
                cm.process(command.toLowerCase());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
