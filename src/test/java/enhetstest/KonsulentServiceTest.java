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
    KonsulentService konsulentService;

    @Before
    public void setup() {
        this.konsulentService = new KonsulentService();
    }


    @Test
    public void addKonsulentIncreasesSizeOnList() {
        Konsulent k = new Konsulent();
        int initalSize = this.konsulentService.antall();
        this.konsulentService.lagre(k);
        Assert.assertEquals(initalSize+1, this.konsulentService.antall());
    }

    @Test
    public void hentMedIdFetchesCorrectObject() {
        Konsulent k = new Konsulent();
        k.setNavn("TestTestTest");
        k.setId(101);
        this.konsulentService.lagre(k);
        Konsulent konsulent_kopi = this.konsulentService.hentMedId(101);
        Assert.assertEquals(k, konsulent_kopi);

    }

    @Test
    public void deleteKonsulentRemovesKonsulentFromList() {
        Konsulent k = new Konsulent();
        k.setId(99);
        this.konsulentService.lagre(k);
        this.konsulentService.slett(k);
        Assert.assertEquals(konsulentService.hentMedId(99),null);

    }

    @Test
    public void deleteNotExistingKonsulentReturnsFalse(){
        Konsulent k = new Konsulent(12);
        Assert.assertEquals(konsulentService.slett(k),false);
    }


}
