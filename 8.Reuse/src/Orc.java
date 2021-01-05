/**
 * @autor denglitong
 * @date 2019/7/27
 */

class Villian {
    private String name;

    protected void setName(String name) {
        this.name = name;
    }

    Villian(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villian and my name is " + name;
    }
}

public class Orc extends Villian {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        // access protected func
        setName(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + " : " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        System.out.println(orc);
        orc.change("Bob", 19);
        System.out.println(orc);
    }
}
