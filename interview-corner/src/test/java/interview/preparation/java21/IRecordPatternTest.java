package interview.preparation.java21;

import interview.preparation.newjava.java21.IRecordPattern;
import interview.preparation.newjava.java21.RecordPatternImpl;
import interview.preparation.newjava.java21.model.ColoredRectangle;
import interview.preparation.newjava.java21.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class IRecordPatternTest {

    private IRecordPattern irp;

    @Before
    public void init()
    {
        irp = new RecordPatternImpl();
    }

    @Test
    public void collectLineInstanceOfTest()
    {
        List<Point> list = irp.collectLineInstanceOf(RecordsUtils.getRecords());
        System.out.println(list.get(0));
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void collectColoredRecordsTest()
    {
        Map<String, Object> coloredShapesMap = irp.collectColoredRecords(RecordsUtils.getRecords());
        System.out.println(coloredShapesMap);
        Assert.assertEquals(4, coloredShapesMap.size());
    }

    @Test
    public void test()
    {
        ColoredRectangle coloredRectangle = new ColoredRectangle(100,200,"Blue");
        System.out.println(coloredRectangle.color());
    }
}
