/**
 * @autor denglitong
 * @date 2019/7/23
 */
public class SimpleEnumUse {

    public static void main(String[] args) {
        // 每个枚举常量都是枚举类的实例
        Spiciness howHot = Spiciness.MEDIUM;
        System.out.println(howHot); // MEDIUM
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }

}

class Burrito {

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.print("This burrito is ");
        switch (degree) {
            case NOT:
                System.out.println("not spicy at all");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little hot.");
                break;
            case HOT:
            case FLAMING:
                default:
                System.out.println("maybe too hot.");

        }
    }

    public static void main(String[] args) {
        Burrito plain = new Burrito(Spiciness.HOT);
        plain.describe();
    }

}