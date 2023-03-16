import org.junit.Assert;
import org.junit.Test;

public class FirstTest {
    @Test
    public void test01(){

        Assert.assertTrue(7<9);
    }

    @Test
    public void test02(){
        Assert.assertTrue("Test Fail", 17<9);
        //Test kaldığında mesaj alırız.

    }

    @Test
    public void test03(){
Assert.assertEquals("Sayilar esit degil",3,6 );

    }}