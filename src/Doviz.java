import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Doviz {


    public float DovizCevir(String birim1, String birim2){

        if(birim1.equals(birim2)){
            return 1;
        }

        String fiyat1;
        String fiyat2;
        if (birim2.equals("TRY")){
            try {
                Document doc = Jsoup.connect("https://www.doviz.com").get();
                Element fiyat1Elementi = doc.select("div.item span[data-socket-key=" + birim1 + "]").first();
                fiyat1 = fiyat1Elementi.text();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(birim1.equals("bitcoin")){
                fiyat1 = fiyat1.replace("$", "");
                fiyat1 = fiyat1.replace(".", "");
                return Float.parseFloat(fiyat1)*DovizCevir("USD","TRY");
            }
            else if(birim1.equals("gram-altin")){
                fiyat1 = fiyat1.replace(".", "");
            }

            fiyat1 = fiyat1.replace(',', '.');
            return Float.parseFloat(fiyat1);
        }
        else if(birim1.equals("TRY")){
            try {
                Document doc = Jsoup.connect("https://www.doviz.com").get();
                Element fiyat2Elementi = doc.select("div.item span[data-socket-key=" + birim2 + "]").first();
                fiyat2 = fiyat2Elementi.text();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(birim2.equals("bitcoin")){
                fiyat2 = fiyat2.replace("$", "");
                fiyat2 = fiyat2.replace(".", "");
                return 1/(Float.parseFloat(fiyat2)*DovizCevir("USD","TRY"));
            }
            else if(birim2.equals("gram-altin")){
                fiyat2 = fiyat2.replace(".", "");

            }

            fiyat2 = fiyat2.replace(',', '.');
            return 1/Float.parseFloat(fiyat2);

        }
        else{
            try {
                Document doc = Jsoup.connect("https://www.doviz.com").get();
                Element fiyat1Elementi = doc.select("div.item span[data-socket-key=" + birim1 + "]").first();
                fiyat1 = fiyat1Elementi.text();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Document doc = Jsoup.connect("https://www.doviz.com").get();
                Element fiyat2Elementi = doc.select("div.item span[data-socket-key=" + birim2 + "]").first();
                fiyat2 = fiyat2Elementi.text();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(birim1.equals("gram-altin")){
                fiyat1 = fiyat1.replace(".", "");

            }
            else if(birim2.equals("gram-altin")){
                fiyat2 = fiyat2.replace(".", "");
            }
            if(birim1.equals("bitcoin")){
                fiyat1 = fiyat1.replace("$", "");
                fiyat1 = fiyat1.replace(".", "");
                if(birim2.equals("USD")){
                    return Float.parseFloat(fiyat1);
                }
                else{
                    return Float.parseFloat(fiyat1)/DovizCevir(birim2,"USD");
                }
            }
            else if(birim2.equals("bitcoin")){
                fiyat2 = fiyat2.replace("$", "");
                fiyat2 = fiyat2.replace(".", "");
                fiyat1 = fiyat1.replace(',', '.');
                fiyat2 = fiyat2.replace(',', '.');
                return Float.parseFloat(fiyat1)/(Float.parseFloat(fiyat2)*DovizCevir("USD","TRY"));
            }

            fiyat1 = fiyat1.replace(',', '.');
            fiyat2 = fiyat2.replace(',', '.');
            return Float.parseFloat(fiyat1)/Float.parseFloat(fiyat2);
        }


    }

}



