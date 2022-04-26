package ru.job4j.map;

import junit.framework.TestCase;
import org.junit.Test;
import org.hamcrest.core.Is;
import static org.junit.Assert.assertThat;

public class SimpleMapTest extends TestCase {

    @Test
    public void testPutAndGet() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.put(4, "John");
        assertThat(simpleMap.get(4), Is.is("John"));
    }

    @Test
    public void testPutSameKeyAndDifferentValue() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.put(5, "John");
        simpleMap.put(5, "Jane");
        simpleMap.put(5, "Mari");
        assertThat(simpleMap.get(5), Is.is("John"));
    }
    @Test
    public void testPutCapacityOverflow() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.put(5, "John");
        simpleMap.put(6, "John");
        simpleMap.put(8, "John");
        simpleMap.put(7, "John");
        simpleMap.put(9, "John");
        simpleMap.put(3, "John");
        simpleMap.put(2, "John");
        simpleMap.put(1, "John");
        assertThat(simpleMap.put(0, "John"), Is.is(true));
    }

    @Test
    public void testGetNull() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.put(5, "John");
        assertNull(simpleMap.get(6));
    }

    @Test
    public void testRemoveTrue() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.put(5, "John");
        assertThat(simpleMap.remove(5), Is.is(true));
    }

    @Test
    public void testRemoveFalse() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        simpleMap.put(5, "John");
        assertThat(simpleMap.remove(6), Is.is(false));
    }

    @Test
    public void testRemoveFromEmptyMap() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        assertThat(simpleMap.remove(6), Is.is(false));
    }

    @Test
    public void whenDidntRemoveEntry() {
        Map<Integer, String> map = new SimpleMap<>();
        map.put(5, "five");
        assertFalse(map.remove(55));
    }
}
