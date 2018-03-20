package fi.vm.yti.codelist.common.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import fi.vm.yti.codelist.common.dto.Meta;
import static org.junit.Assert.assertEquals;

public class MetaTest {

    @Test
    public void testMetaAfter() {
        final Date isoDate = Meta.parseAfterFromString("2017-10-09");
        final Calendar date = new GregorianCalendar(2017, Calendar.OCTOBER, 9);
        assertEquals(isoDate.getTime(), date.getTime().getTime());
    }
}
