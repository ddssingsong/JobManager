package com.dds.battery;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.dongnao.battery", appContext.getPackageName());
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1`","2");
        Class clazz = HashMap.class;
        Field table = clazz.getDeclaredField("table");
        System.out.println(table);
        table.setAccessible(true);
        Object[] o = (Object[]) table.get(hashMap);
    }
}
