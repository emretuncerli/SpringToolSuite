package com.example.vaad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KayitCek {
	Connection con=null;
	PreparedStatement ps=null;
	public List<Birimler> getBirimlerTablosu() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//Hangi türde bir veri tabanını kullanacağını bildiriyoruz.
            con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.2:1521:orcl", "stajdemo","stajdemo");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            ps=con.prepareStatement("select bir.BIRIMADI,bir.BOLUMKODU,  bir.BIRIMKODU from birimler bir");//Birimler tablosundaki herşeyi çek diyoruz.
            ResultSet rs=ps.executeQuery();//SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<Birimler> liste=new ArrayList<>();//Bİrimler sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Birimler kısmına bu tiple ulaşacaz.
            while(rs.next()) //Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
            	Birimler aa=new Birimler();//SQL Sorgusundan sütunları çekip bu değişkenin içinde Adı veya Alani kısmına atıyacağız.
                aa.setBIRIMADI(rs.getString("BIRIMADI")); //ResultSet içinden o anki indisdeki "Adi" anahtar kelimesine karşı gelen değer alınıyor.
                aa.setBOLUMKODU(rs.getString("BOLUMKODU")); //ResultSet içinden o anki indisdeki "Alani" anahtar kelimesine karşı gelen değer alınıyor.
                aa.setBIRIMKODU(rs.getString("BIRIMKODU"));
                liste.add(aa);//Her bir dönen sonucu listeye ekliyoruz.
            }
            return liste;//Listeyi return ediyoruz.
        } 
        catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(con!=null){ //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    con.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    }
}

