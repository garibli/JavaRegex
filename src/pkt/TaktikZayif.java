/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/
package pkt;
import java.util.Random;

public class TaktikZayif implements Taktik{

	@Override
	public int Savas() {
		Random random = new Random();
        int deger = random.nextInt(501);
		return deger;
	}

	@Override
	public int TaktikBelirle(Koloni kol1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
