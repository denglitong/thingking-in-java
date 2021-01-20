package problems;

import apple.laf.JRSUIConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class NeedCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0]));
        List<JRSUIConstants.Widget> shapes = (List<JRSUIConstants.Widget>)in.readObject();
    }
}
