import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CsvReaderTest {
	/**
	 * @author Yair Ivgi and Idan Holander
	 * test the readCsv method 
	 */
	@Test
	public void test() {
		CsvReader cr = new CsvReader();
		File f= new File("data\\WigleWifi_20171031190803.csv");
		List<RawData>data = new ArrayList<RawData>();
		f = null;
		try {
			data=cr.readCsv(f,data);
		} catch (Exception e) {
			assertFalse("failed: "+e.toString(),true);
		}
		assertTrue(data.size()>0);
		String lastTime=null;

		for(int i=0;i<data.size();i++) {
			String currentTime = null;
			currentTime=data.get(i).getSamples().get(0).getFirstSeen();
			assertFalse(lastTime!=null&&lastTime.equals(currentTime));
		}
	}

}
