package test;

//import static array.Array.transponeer;
import static org.junit.Assert.*;
import org.junit.Test;
import array.Array;

public class ArrayTest {
  
  @Test
  public void testTransponeer() {
    //een n bij m array met n > m
    int[][] a = { {1,2,3,4},
                  {1,2,3,4},
                  {1,2,3,4},
                  {1,2,3,4},
                  {1,2,3,4} };
    //de getransponeerde van a
    int[][] b = { {1,1,1,1,1},
                  {2,2,2,2,2},
                  {3,3,3,3,3},
                  {4,4,4,4,4} };
    //de getransponeerde van a is b
    assertArrayEquals(b, Array.transponeer(a));
    //en als je b weer terug transponeert krijg je a;
    //dit is tegelijkertijd een testgeval van de vorm
    //"een n bij m array met n < m"
    assertArrayEquals(a, Array.transponeer(b));
    
    //een n bij m array met n = m
    int[][] c = { {1,2,3,4,5},
                  {1,2,3,4,5},
                  {1,2,3,4,5},
                  {1,2,3,4,5},
                  {1,2,3,4,5} };
    //de getransponeerde van c
    int[][] d = { {1,1,1,1,1},
                  {2,2,2,2,2},
                  {3,3,3,3,3},
                  {4,4,4,4,4},
                  {5,5,5,5,5} };
    //de getransponeerde van c is d
    assertArrayEquals(d, Array.transponeer(c));
    //en als je d weer terug transponeert krijg je c 
    assertArrayEquals(c, Array.transponeer(d));
    
    //randgeval: n = m = 1
    int[][] e = {{5}};
    assertArrayEquals(e, Array.transponeer(e));
    
    //randgeval: n = 1, m > 1
    int[][] i = {{1, 2, 3}};
    int[][] j = {{1},
                 {2},
                 {3}};
    assertArrayEquals(j, Array.transponeer(i));
    //randgeval: n > 1, m = 1
    assertArrayEquals(i, Array.transponeer(j));
  }
}
