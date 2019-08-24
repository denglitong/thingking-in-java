package com.denglitong.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @autor denglitong
 * @date 2019/8/17
 */

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInterface {
    public static void main(String[] args) {
        // Arrays.asList is fixed array
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder()
        );
        // snow1.add(new Heavy()); // UnsupportedOperationException

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy()
        );
        // snow2.add(new Slush());

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavy(), new Powder());
        snow3.add(new Crusty());

        // Hint with explicit type argument specification
        // 显示声明告诉编译器生成的List类型的实际目标类型是什么
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush()
        );
        // snow4.add(new Powder());
    }
}
