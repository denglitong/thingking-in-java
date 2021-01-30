import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/30
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annos = field.getDeclaredAnnotations();
                if (annos.length < 1) {
                    continue;
                }
                if (annos[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger)annos[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT " + getConstrains(sInt.constrains()));
                }
                if () {

                }
            }
        }
    }

    private static String getConstrains(Constraints con) {
        String constrains = "";
        if (!con.allowNull()) {
            constrains += " NOT NULL";
        }
        if (con.primaryKey()) {
            constrains += " PRIMARY KEY";
        }
        if (con.unique()) {
            constrains += " UNIQUE";
        }
        return constrains;
    }
}
