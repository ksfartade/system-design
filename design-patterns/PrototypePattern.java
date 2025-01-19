
/*
 * When our class can be used as template, then it is important to create the object clonable easily.
 */

interface Template {
    abstract Template createTemplate();
}

class WordDocument implements Template{

    String textStype;
    String username;

    public WordDocument(String textStype, String username) {
        this.textStype = textStype;
        this.username = username;
    }

    @Override
    public String toString() {
        return "WordDocument [textStype=" + textStype + ", username=" + username + "]";
    }


    @Override
    public Template createTemplate() {
        return new WordDocument(this.textStype, this.username);
    }
    
}

public class PrototypePattern {
    public static void main(String[] args) {
        WordDocument doc1 = new WordDocument("Email writing on AI", "GPT ");

        System.out.println(doc1);


        WordDocument template1 = (WordDocument)doc1.createTemplate();
        System.out.println("Tempalte: " + template1.username);
    }
}
