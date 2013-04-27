/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Corespk;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
/**
 *
 * @author newbie
 */
public class CoreApps extends BasicDBObject{
    
    private String nik;
    private String nama;
    private String kelas;
    private double matematika;
    private double biolgi;
    private double fisika;
    private double kimia;
    private double akutansi;
    private double geografi;
    private double sosiologi;
    private String hasilMinat;
    
    public CoreApps(){
        
    }
    
    public CoreApps(DBObject data){
        
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
        put("nik", this.nik);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public double getMatematika() {
        return matematika;
    }

    public void setMatematika(double matematika) {
        this.matematika = matematika;
    }

    public double getBiolgi() {
        return biolgi;
    }

    public void setBiolgi(double biolgi) {
        this.biolgi = biolgi;
    }

    public double getFisika() {
        return fisika;
    }

    public void setFisika(double fisika) {
        this.fisika = fisika;
    }

    public double getKimia() {
        return kimia;
    }

    public void setKimia(double kimia) {
        this.kimia = kimia;
    }

    public double getAkutansi() {
        return akutansi;
    }

    public void setAkutansi(double akutansi) {
        this.akutansi = akutansi;
    }

    public double getGeografi() {
        return geografi;
    }

    public void setGeografi(double geografi) {
        this.geografi = geografi;
    }

    public double getSosiologi() {
        return sosiologi;
    }

    public void setSosiologi(double sosiologi) {
        this.sosiologi = sosiologi;
    }

    public String getHasilMinat() {
        return hasilMinat;
    }

    public void setHasilMinat(String hasilMinat) {
        this.hasilMinat = hasilMinat;
        put("nik", this.hasilMinat);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
