package com.dds.battery;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1`","2");
        Class clazz = HashMap.class;
        Field table = clazz.getDeclaredField("table");
        System.out.println(table);
        table.setAccessible(true);
        Object[] o = (Object[]) table.get(hashMap);
        System.out.println(o.length);
    }
}