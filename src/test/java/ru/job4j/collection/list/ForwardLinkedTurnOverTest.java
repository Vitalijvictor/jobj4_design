package ru.job4j.collection.list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

public class ForwardLinkedTurnOverTest {

    @Test
    public void whenAddThenIter() {
        ForwardLinkedTurnOver<Integer> linked = new ForwardLinkedTurnOver<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinkedTurnOver<Integer> linked = new ForwardLinkedTurnOver<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenSize0ThenReturnFalse() {
        ForwardLinkedTurnOver<Integer> emptyList = new ForwardLinkedTurnOver<>();
        assertFalse(emptyList.revert());
    }

    @Test
    public void whenSize1ThenReturnFalse() {
        ForwardLinkedTurnOver<Integer> singleList = new ForwardLinkedTurnOver<>();
        singleList.add(1);
        assertFalse(singleList.revert());
    }

}