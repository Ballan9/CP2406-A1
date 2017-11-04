import org.junit.Test;
public class GridTest {
    @Test
    public void GridTester() throws Exception{
    Grids gridTest = new Grids();

    gridTest.praint();
    System.out.println(gridTest.grids[0][0]);
    assert gridTest.grids[0][0] == 0;
    }
}
