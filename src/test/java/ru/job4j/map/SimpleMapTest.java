/*
package ru.job4j.map;

import junit.framework.TestCase;
import org.junit.Test;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

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
        assertThat(simpleMap.get(5), Is.is("Jane"));
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
        assertThat(simpleMap.put(0, "John"), Is.is(false));
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
    public void testIterator() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        assertNull(simpleMap.iterator().next());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorException() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap();
        Iterator<Integer> rsl = simpleMap.iterator();
        while (rsl.hasNext()) {
            simpleMap.put(5, "John");
            rsl.next();
        }
    }
}

 */