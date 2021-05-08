/**
 * 单例模式：提供一个且只有一个对象实例的方法
 *
 * @author litong.deng@foxmail.com
 * @date 2021/4/29
 */
interface Resource {
    int getValue();
    void setValue(int x);
}

/**
 * 设置为 final 可防止通过继承添加可克隆性，这也实现了线程安全的延迟初始化
 * Singleton 没有从 Cloneable 基类继承而且没有添加可克隆性，所以可以使用 final 修饰
 */
final class Singleton {

    private static final class ResourceImpl implements Resource {
        private int i;

        public ResourceImpl(int i) {
            this.i = i;
        }

        @Override
        public int getValue() {
            return i;
        }

        @Override
        public void setValue(int x) {
            i = x;
        }
    }

    // 创建单例的关键是防止客户端程序员直接创建对象
    // 在这里 ResourceHolder 类是懒惰加载的直到第一次被引用
    private static class ResourceHolder {
        // 类加载的时候静态初始化块将被调用，JVM 的静态初始化是线程安全的
        // 为了保证安全，Resource 中的 getter 和 setter 调用是同步的
        private static Resource resource = new ResourceImpl(47);
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Resource r = Singleton.getResource();
        System.out.println(r.getValue());
        Resource s2 = Singleton.getResource();
        s2.setValue(9);
        System.out.println(r.getValue());
        /*try {
            // compile-time error: clone() has protected access in ...
            Singleton s3 = (Singleton)s2.clone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}