package domain;

public class Appereance {
    private Head head;
    private Shoes shoes;

    public Appereance() {
        this.head = new Head();
        this.shoes = new Shoes();
    }

    public Head getHead() {
        return head;
    }

    public Shoes getShoes() {
        return shoes;
    }
}
