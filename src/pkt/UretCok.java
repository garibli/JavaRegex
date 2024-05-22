/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/
package pkt;
import java.util.Random;
public class UretCok implements Uretim{

	@Override
	public void Uret(Koloni k) {
		Random random = new Random();
		k.yemek=k.yemek+1+random.nextInt(10);
	}

	@Override
	public void DegerGuncelle(Koloni k) {
		k.populasyon=k.populasyon+(k.populasyon*2)/10;
		k.yemek=k.yemek-(k.populasyon*2);
		if(k.yemek<0) {
			k.yemek=0;
			k.populasyon=0;
		}
	}
	
}
