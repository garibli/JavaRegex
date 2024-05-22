/**
*
* @author Fuad Garibli fuad.garibli@ogr.sakarya.edu.tr
* @since 25 mayis 2023
* 
**/
package pkt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Koloni koloni = new Koloni(0);
        Oyun oyun = new Oyun();
        TaktikGuclu taktik = new TaktikGuclu();
        
        System.out.println("Lutfen populasyon sayilarini aralarinda bosluk birakarak girin!");
        System.out.print("sayilar: ");
        String girdi = scanner.nextLine();
        
        int sayac=1;
        koloni.PopulasyonAyir(girdi);

        List<Koloni> KoloniList = new ArrayList<>();//kolonilerin tutulacagi liste
        for (int i = 0; i < koloni.numbersArray.length; i++) {
        	Koloni k = new Koloni(koloni.numbersArray[i]);
        	KoloniList.add(k);//koloniler listeye eklenir
        }
        
        while(true) {
        	for(int i=0; i<KoloniList.size()-1; i++) {
            	for(int j=i+1;j<KoloniList.size(); j++) {
            		if(KoloniList.get(i).populasyon==1 && KoloniList.get(j).populasyon == 1) {
            			KoloniList.get(j).populasyon=0;//ilk saldiran taraf kazanir
            		}
            		if(KoloniList.get(i).populasyon!=0 && KoloniList.get(j).populasyon!=0) {//koloniler her iksi de hayattaysa karsilastirma icin devam edilir
            			int puan1 = taktik.TaktikBelirle(KoloniList.get(i));//savas degerleri olusturulur
            			int puan2 = taktik.TaktikBelirle(KoloniList.get(j));
            			int fark = puan1-puan2;
            			if(puan1>puan2) {
            				KoloniList.get(i).kazanma++;
            				KoloniList.get(j).kaybetme++;
            				KoloniList.get(j).populasyon=KoloniList.get(j).populasyon-(KoloniList.get(j).populasyon*(fark / 10)/100);
            				KoloniList.get(j).yemek=KoloniList.get(j).yemek-(KoloniList.get(j).yemek*(fark / 10)/100);
            				KoloniList.get(i).yemek=KoloniList.get(i).yemek+(KoloniList.get(j).yemek*(fark / 10)/100);
            				if(KoloniList.get(j).yemek<=0) {KoloniList.get(j).populasyon=0; KoloniList.get(j).yemek=0;}
            			}
            			else if(puan1<puan2) {
            				KoloniList.get(j).kazanma++;
            				KoloniList.get(i).kaybetme++;
            				KoloniList.get(i).populasyon=KoloniList.get(i).populasyon-(KoloniList.get(i).populasyon*(fark / 10)/100);
            				KoloniList.get(i).yemek=KoloniList.get(i).yemek-(KoloniList.get(i).yemek*(fark / 10)/100);
            				KoloniList.get(j).yemek=KoloniList.get(j).yemek+(KoloniList.get(i).yemek*(fark / 10)/100);
            				if(KoloniList.get(i).yemek<=0) {KoloniList.get(i).populasyon=0; KoloniList.get(i).yemek=0;}
            			}
            		}
            	}
            }
        	oyun.Rount(KoloniList, sayac);//rount sonunda ekrana guncel durum yazdirilir
        	sayac++;
        	int sonlandir=0;

        	for(int i=0;i<KoloniList.size();i++) {
        		if(KoloniList.get(i).populasyon==0) {
        			sonlandir++;
        		}
        		if(KoloniList.get(i).populasyon<4) {//populasyonu az koloniler icin farkli hesaplama gerceklestirilir
        			UretAz uret = new UretAz();
        			uret.Uret(KoloniList.get(i));
        			uret.DegerGuncelle(KoloniList.get(i));
        		}
        		else{
        			UretCok uret = new UretCok();
        			uret.Uret(KoloniList.get(i));
        			uret.DegerGuncelle(KoloniList.get(i));
        		}
        	}
        	if(sonlandir>=(KoloniList.size()-1)) {
        		break;
        	}
        }
        scanner.close();
	}
}
