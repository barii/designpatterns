package visitor;

interface ICarElementVisitor {
    public void visit(Car element);
    public void visit(Body element);
    public void visit(Wheel element);
}

interface ICarElement {
    public void accept(ICarElementVisitor visitor);
}

class CarPrintVisitor implements ICarElementVisitor {
    @Override
    public void visit(Car car) {
        System.out.println("this is a car");
    }
    
    @Override
    public void visit(Body car) {
        System.out.println("this is a " + car.color);
    }
    
    
    @Override
    public void visit(Wheel wheel) {
        System.out.println("this is a " + wheel.name);
    }
}

class Body implements ICarElement{
    String color;
    
    public Body(String color) {
        this.color = color;
    }
        
    @Override
    public void accept (ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Wheel implements ICarElement{
    String name;
    
    public Wheel(String name) {
        this.name=name;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public void accept (ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Car implements ICarElement{
    ICarElement[] elements = new ICarElement[] { new Body("red"), new Wheel("Left"), new Wheel("Right") };

    @Override
    public void accept (ICarElementVisitor visitor) {
        for (ICarElement element : elements) {
            element.accept(visitor);
        }
        
        visitor.visit(this);
    }
}


public class VisitorPattern {
    public static void main(String[] args) {
        ICarElement car = new Car();
        car.accept(new CarPrintVisitor());
    }
    
}
