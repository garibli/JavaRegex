/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/
package pkt;
import java.util.Random;

public class TaktikGuclu implements Taktik{

	@Override
	public int Savas() {
		Random random = new Random();
        int deger = random.nextInt(501);
		return deger+500;
	}

	@Override
	public int TaktikBelirle(Koloni kol1) {
		if(kol1.populasyon>30)
			return Savas();
		else
		{
			TaktikZayif taktik = new TaktikZayif();
			return taktik.Savas();
		}
	}

}
