package com.zcl;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void sortList(){
        List<String> list = Lists.newArrayList();
        list.add("csdf");
        list.add("bsd");
        list.add("awqew");
        System.out.println(list);
        AnnotationAwareOrderComparator.sort(list);
        System.out.println(list);
    }
}
