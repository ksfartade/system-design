package stackoverflow;

public enum Tag {
    CODING("coding"), LEARNING("learning"), DSA("dsa") ;

    String name ;
    Tag(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
