package enhetstest;

import com.soprasteria.boot.domain.Konsulent;
import com.soprasteria.boot.service.KonsulentService;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.util.List;


/**
 * Created by olovholm on 21.04.2015.
 */
public class KonsulentServiceTest {
    List<Konsulent> konsulentList;
    KonsulentService konsulentService;

    @Before
    public void setup() {
        this.konsulentService = new KonsulentService();
        this.konsulentList = konsulentService.hentAlleKonsulenter();
    }


    @Test
    public void addKonsulentIncreasesSizeOnList() {
        Konsulent k = new Konsulent();
        int initalSize = this.konsulentList.size();
        this.konsulentList.add(k);
        Assert.assertEquals(initalSize+1, this.konsulentList.size());
    }

    @Test
    public void hentMedIdFetchesCorrectObject() {
        Konsulent k = new Konsulent();
        k.setNavn("TestTestTest");
        k.setId(101);
        this.konsulentList.add(k);
        Konsulent konsulent_kopi = this.konsulentService.hentMedId(101);
        Assert.assertEquals(k, konsulent_kopi);

    }


}
