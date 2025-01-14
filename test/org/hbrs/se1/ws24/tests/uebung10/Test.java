package org.hbrs.se1.ws24.tests.uebung10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyPrettyRectangleTest {
    private MyPrettyRectangle rect1;
    private MyPrettyRectangle rect2;

    @BeforeEach
    public void setup() {
        rect1 = new MyPrettyRectangle(0, 0, 4, 4);
        rect2 = new MyPrettyRectangle(1, 1, 3, 3);
    }

    @Test
    public void testContains() {
        assertTrue(rect1.contains(rect2));
        assertFalse(rect2.contains(rect1));
    }

    @Test
    public void testGetMidpoint() {
        assertEquals(new Point(2, 2), rect1.getMidpoint());
    }

    @Test
    public void testGetArea() {
        assertEquals(16, rect1.getArea());
        assertEquals(4, rect2.getArea());
    }

    @Test
    public void testGetBoundingBox() {
        MyPrettyRectangle boundingBox = rect1.getBoundingBox(rect2);
        assertEquals(new MyPrettyRectangle(0, 0, 4, 4), boundingBox);
    }

    @Test
    public void testEquals() {
        MyPrettyRectangle rect3 = new MyPrettyRectangle(0, 0, 4, 4);
        assertEquals(rect1, rect3);
    }
}
