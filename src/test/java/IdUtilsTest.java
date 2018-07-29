import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gfournier[at]despegar.com on 17/06/17.
 */
public class IdUtilsTest {

    @Test
    public void testPadding(){
        Assert.assertEquals("String of length 0 should add 0 chars", 0, IdUtils.getPad(0));
        Assert.assertEquals("String of length 1 should add 5 chars", 5, IdUtils.getPad(1));
        Assert.assertEquals("String of length 2 should add 4 chars", 4, IdUtils.getPad(2));
        Assert.assertEquals("String of length 3 should add 3 chars", 3, IdUtils.getPad(3));
        Assert.assertEquals("String of length 4 should add 2 chars", 2, IdUtils.getPad(4));
        Assert.assertEquals("String of length 5 should add 1 chars", 1, IdUtils.getPad(5));
        Assert.assertEquals("String of length 6 should add 0 chars", 0, IdUtils.getPad(6));
    }
}