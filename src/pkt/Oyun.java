/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/
package pkt;

import java.util.List;

public class Oyun {
	
	public void Rount(List<Koloni> list, int rount) {
		System.out.println("Rount: "+rount);
		System.out.println("Karakter\tPopulasyon\tYemek Stogu\tKazanma\tKaybetme");
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).populasyon==0) {//olu koloni
				System.out.println("--\t\t--\t\t--\t\t--\t--");
			}
			else {//hayatta olan koloni
				System.out.println((char)list.get(i).karakter+"\t\t"+list.get(i).populasyon+"\t\t"+list.get(i).yemek+"\t\t"+list.get(i).kazanma+"\t"+list.get(i).kaybetme);
			}
		}
		System.out.println("----------------------------------------------------------------");
	}
}
