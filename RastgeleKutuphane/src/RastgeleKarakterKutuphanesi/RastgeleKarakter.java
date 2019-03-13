package RastgeleKarakterKutuphanesi;

import java.util.Arrays;

public class RastgeleKarakter {

    private boolean sonBasamak = true;
    private char[] Harfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz".toCharArray();

     //nanoTime() fonksiyonundaki sayının son basamağını ya da sondan bir öncekini döndürür
    //her çağrıldığında sırayla bir sondan, bir sondan bir öncekinden sayı döndürür.
    public long rand() {
        if (sonBasamak) {
            long l = System.nanoTime();
            String s = String.valueOf(l);
            long randSayi = Long.parseLong(s.substring(s.length() - 1));

            sonBasamak = false;
            return randSayi;
        } else {
            long l = System.nanoTime();
            String s = String.valueOf(l);
            long randSayi = Long.parseLong(s.substring(s.length() - 2, s.length() - 1));

            sonBasamak = true;
            return randSayi;
        }

    }

     //int basamak adedinde random sayı döndürür.stringlerin üzerine eklendiği için
    //ilk basamak 0 olunca eksik basamaklı sayı çıkıyor. ayrıca yeterince random değil.
    public long rand(int basamak) {
        String sayi = "";
        for (int i = 0; i < basamak; i++) {
            sayi = sayi.concat(String.valueOf(rand()));
        }
        return Long.parseLong(sayi);
    }

     //tüm alfabeden rastgele bir harf döndürür
    //rand(2): 2 basamaklı random sayı. yani max 99 olabilir.rand()%harfler.lenght yapınca
    // da alfabe indexini aşmayan bir sayı dönmüş oluyor
    public String harfAliyim() {
        return Character.toString(Harfler[(int) rand(2) % Harfler.length]);
    }

    public String randChar() {
        return harfAliyim();
    }

    public String randChar(int harfSayisi) {
        String s = "";
        for (int i = 1; i <= harfSayisi; i++) {
            s = s.concat(harfAliyim());
        }
        return s;
    }

     //verilen iki harf aralığından rastgele bir harf döndürür
    //iki karakter arasında kaç harf var bulunur
    //tüm harf dizisinin %fark ı alınır.
    //sonuç + a' nın indexi eklenir.
    //örn:a=3. harf b= 10. harf. tüm alfabenin %7si alınır.sonuç 0'dan 6ya kadardır.%7 + 3 yapılırsa sonuç 3'ten 9a kadardır.
    public String randAralik(char a, char b) {
        int index_a = Arrays.asList(String.copyValueOf(Harfler)).toString().indexOf(a);
        int index_b = Arrays.asList(String.copyValueOf(Harfler)).toString().indexOf(b);

        int fark = Math.abs(index_a - index_b);
        int kucukindex = index_a < index_b ? index_a : index_b;

        /*
         *indexOf() sayma sayıları ile çalıştığından ve diziye erişim 0 dahilinde 
         *olduğundan +1 ve -1 ekleyerek manuel olarak ayarladım. çoğu testte bir
         *sorun olmadı.
         */
        return Character.toString(Harfler[((int) rand(2) % (fark + 1) + kucukindex) - 1]);

    }

     //girilen parametredeki karakterler arasından rastgele birini string olarak döndürür.
    //rand(4) kullanılmasının sebebi 4 rakam ile 9999a kadar sayı üretilebilmesidir.
    //bu sayede 10000e kadar argümanları döndürebilir.
    public String randArasindan(Character... args) {
        return args[(int) rand(4) % args.length].toString();
    }

    public String randArasindan(Integer adet, Character... args) {
        String chars = "";
        for (int i = 0; i < adet; i++) {
            chars = chars.concat(args[(int) rand(4) % args.length].toString());
        }

        return chars;
    }

    //rastgele harflerden ve kelimelerden oluşan bir cümle döndürür.(max 50 kelime)
    public String randCumle() {
        String cumle = "";
        int MAX_KELIME_UZ = 15;

        //kelime döngüsü
        for (int i = 0; i < rand(2) % 50; i++) {
            cumle = cumle.concat(
                    randChar((int) (rand(2) % MAX_KELIME_UZ))
            );
            cumle = cumle.concat(" ");
        }
        cumle = cumle.trim();
        return cumle.concat(".");
    }

    public String randCumle(int kelime) {
        String cumle = "";
        int MAX_KELIME_UZ = 15;
        for (int i = 0; i < kelime; i++) {
            cumle = cumle.concat(
                    randChar((int) (rand(2) % MAX_KELIME_UZ))
            );
            cumle = cumle.concat(" ");
        }
        cumle = cumle.trim();
        return cumle.concat(".");
    }
}
