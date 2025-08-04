import java.util.*;

interface Person{
    public void spreadMsg(String msg);
}


class Employee implements Person{
    String name ;
    List<Person> connected = new ArrayList<>();

    public Employee(List<Person> connected, String name) {
        this.name = name;
        this.connected = connected;
    }

    public Employee(String name) {
        this.name = name;
    }

    public void implementFeature(){
        System.out.println("Implementing feature..");
    }

    @Override
    public void spreadMsg(String msg) {
        System.out.println("My name is "+ this.name + " I am now aware about this message: " + msg);
        for(Person person: connected){
            person.spreadMsg(msg);
        }
    }
}

class Management implements Person{
    String name ;
    List<Person> connected = new ArrayList<>();

    public Management(String name) {
        this.name = name;
    }

    public Management(List<Person> connected, String name) {
        this.name = name;
        this.connected = connected;
    }

    public void add(Person person){
        connected.add(person);
    }

    @Override
    public void spreadMsg(String msg) {
        System.out.println("My name is "+ this.name + " I am now aware about this message: " + msg);
        for(Person person: connected){
            person.spreadMsg(msg);
        }
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {

        Management CEO = new Management("Kiran");

        Management CTO = new Management("Rajesh");
        Management CEEO = new Management("Mukesh");

        CEO.add(CTO);
        CEO.add(CEEO);

        Employee munna = new Employee("Munna Bhai");
        Employee raju = new Employee("Raju bhai");

        CTO.add(raju);
        CTO.add(munna);

        CEO.spreadMsg("Hey we have gotten a new project...");
    }
}
