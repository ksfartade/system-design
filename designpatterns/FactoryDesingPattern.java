
interface Shape {
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing circle..");
    }
    
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing square...");
    }

    // this method will not be accessible using the interface object. Shape circle = new Circle()
    public double area(int r){
        return 3.14 * r * r;
    }

}

class Factory {
    public static Shape getShape(String type){
        if(type == "circle"){
            return new Circle();
        }
        if(type == "square"){
            return new Square();
        }
        return null;
    }
}

public class FactoryDesingPattern {
    public static void main(String[] args) {
        Shape circle = Factory.getShape("circle");
        circle.draw();

        Shape square = Factory.getShape("square");
        square.draw();
    }
    
}

