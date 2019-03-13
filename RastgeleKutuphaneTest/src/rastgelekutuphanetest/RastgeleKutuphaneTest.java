/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastgelekutuphanetest;

import RastgeleKarakterKutuphanesi.*;

/**
 *
 * @author murat
 */
public class RastgeleKutuphaneTest {

     public static void main(String[] args) {
         RastgeleKarakter r=new RastgeleKarakter();
         System.out.println("Rastgele Karakter: "+r.randChar());
         System.out.println("Rastgele Karakter: "+r.randChar());
         
         System.out.println("Rastgele 3 Karakter: "+r.randChar(3));
         System.out.println("Rastgele 3 Karakter: "+r.randChar(3));
         
         System.out.println("Verilen iki karakter (a,k): "+r.randAralik('a', 'k'));
         System.out.println("Verilen iki karakter (a,k): "+r.randAralik('a', 'k'));
         
         System.out.println("Belirtilen Karakterler: (g,y,u,c,n,e)"+
                 r.randArasindan('g','y','u','c','n','e'));
         System.out.println("Belirtilen Karakterler: (g,y,u,c,n,e)"+
                 r.randArasindan('g','y','u','c','n','e'));
        System.out.println("Belirtilen Karakterler (5 adet): (g,y,u,c,n,e)"+
                 r.randArasindan(5,'g','y','u','c','n','e'));

         System.out.println("Rastgele cümle: "+r.randCumle());
         System.out.println("Rastgele cümle (5 kelime): "+r.randCumle(4));

         
         
         
         
         
     
     }
    
}
