/**
 * @author denglitong
 * @date 2021/1/30
 */
@DBTable(name = "MEMBER")
public class Member {
    // 不适用 名-值 对的语法时，该元素的命名必须为 value
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constrains = @Constraints(primaryKey = true))
    String reference;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getReference() {
        return reference;
    }
    public Integer getAge() {
        return age;
    }
    @Override
    public String toString() {
        return reference;
    }
}
