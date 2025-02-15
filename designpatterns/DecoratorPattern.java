
interface Pizza {
    String description();
    int price();
}


class BasePizza implements Pizza{

    @Override
    public String description() {
        return "Pizza is made by wheat.";
    }

    @Override
    public int price() {
        return 50;
    }
}


abstract class PizzaDecorator implements Pizza{
    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    
    @Override
    public String description(){
        return pizza.description();
    }

    @Override
    public int price(){
        return pizza.price();
    }
}


class PaneerDecorator extends PizzaDecorator{
    public PaneerDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String description(){
        System.out.println("You can test paneer with your pizza...");
        return super.description() + " Extra added paneer" ;
    }

    @Override
    public int price(){
        System.out.println("Adding Rs.30 of paneer cost...");
        return super.price() + 30;
    }
}


class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String description(){
        System.out.println("You can test cheese with your pizza...");
        return super.description() + " Extra added cheese" ;
    }

    @Override
    public int price(){
        System.out.println("Adding Rs.20 of cheese cost...");
        return super.price() + 20;
    }
    
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza simplePizza = new BasePizza();

        Pizza paneerPizza = new PaneerDecorator(simplePizza);

        Pizza pannerWithCheesePizza = new CheeseDecorator(paneerPizza);
        System.out.println(pannerWithCheesePizza.description());
        System.out.println(pannerWithCheesePizza.price());

    }
}
