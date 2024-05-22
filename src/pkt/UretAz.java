/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/
package pkt;

public class UretAz implements Uretim{

	@Override
	public void Uret(Koloni k) {
        k.yemek=k.yemek + 2;
	}
	
	@Override
	public void DegerGuncelle(Koloni k) {
		k.populasyon=k.populasyon+(k.populasyon*2)/10;
		k.yemek=k.yemek-(k.populasyon*2);
		if(k.yemek<0)
		{
			k.yemek=0;
			k.populasyon=0;
		}
	}
}
