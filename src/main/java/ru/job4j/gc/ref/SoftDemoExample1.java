package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**+
 * Soft Reference
 *  не смотря на то, что мы за'null'уляем сильную ссылку,
 *  на объект остается безопасная ссылки, а это значит объект будет удален только при нехватке памяти.
 */
public class SoftDemoExample1 {

    public static void main(String[] args) {
        example1();
    }

    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }
}