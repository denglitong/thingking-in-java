/**
 * @autor denglitong
 * @date 2019/9/8
 */
public class ExceptionMethods {
    public static void main(String[] args) throws Exception {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e);
            System.out.println("printStackTrace():");
            Thread.sleep(500);
            e.printStackTrace();
        }
    }
}
