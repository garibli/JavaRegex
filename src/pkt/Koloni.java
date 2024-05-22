/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/

package pkt;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

public class Koloni {
	int[] numbersArray;
	int populasyon;
	int kazanma;
	int kaybetme;
	int yemek;
	int karakter;
	
	public Koloni(int veri) {//ilk deger atamasi yapilir
		populasyon=veri;
		kazanma=0;
		kaybetme=kazanma;
		yemek=populasyon*veri;
		karakter=KarakterAyarla();
	}
	
	private int KarakterAyarla() {//rastgele karakter icin ascii araligindan bir sayi secilir
		Random random = new Random();
        int deger = random.nextInt(126);
        if(deger<33)
        	deger+=33;
		return deger;
	}

	public void PopulasyonAyir(String girdi) {//kullanici girdisi olan sayilar ayristirilir
		List<Integer> sayilarList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(girdi);
        
        while (matcher.find()) {
            int sayi = Integer.parseInt(matcher.group());
            sayilarList.add(sayi);
        }
        numbersArray = new int[sayilarList.size()];
        for (int i = 0; i < sayilarList.size(); i++) {
            numbersArray[i] = sayilarList.get(i);
        }
	}
}
