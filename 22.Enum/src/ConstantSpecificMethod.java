import java.text.DateFormat;
import java.util.Date;

/**
 * @author denglitong
 * @date 2021/1/24
 */
public enum ConstantSpecificMethod {
    // table-driven code
    DATE_TIME {
        // 可以为每个 enum 实例重写 abstract 方法
        @Override
        String getInfo() {
            return DateFormat.getDateInstance()
                    .format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.name() + ": " + csm.getInfo());
        }
    }
}
