

interface Button {
    abstract void press();
}

interface CheckBox {
    abstract void check();    
}

class WindowButton implements Button{

    @Override
    public void press() {
        System.out.println("pressing windows button..");
    }

}


class WindowCheckBox implements CheckBox{

    @Override
    public void check() {
        System.out.println("pressing windows checkbox..");
    }

}


class MacButton implements Button{

    @Override
    public void press() {
        System.out.println("pressing MacBook button..");
    }

}


class MacCheckBox implements CheckBox{

    @Override
    public void check() {
        System.out.println("pressing macbook check box..");
    }

}


interface AbstractFactory{
    abstract Button createButton();
    abstract CheckBox createCheckBox();
}

class WindowFactory implements AbstractFactory{

    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}

class MacFactory implements AbstractFactory{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }

}


public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory windows = new WindowFactory();
        Button windowsButton = windows.createButton();
        windowsButton.press();
        CheckBox windowsCheckBox = windows.createCheckBox();
        windowsCheckBox.check();

        AbstractFactory mac = new MacFactory();
        Button macButton = mac.createButton();
        macButton.press();

        CheckBox macCheckBox = mac.createCheckBox();
        macCheckBox.check();

    }
}
