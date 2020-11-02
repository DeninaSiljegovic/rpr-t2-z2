package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetna_tacka, krajnja_tacka;
    boolean pocetna_pripada, krajnja_pripada;

    Interval(double t1, double t2, boolean prva, boolean druga) throws IllegalArgumentException{
        if( t1 > t2 ) throw new IllegalArgumentException ("Ne valjaju argumenti za tacke");
        pocetna_tacka=t1; krajnja_tacka=t2;
        pocetna_pripada=prva; krajnja_pripada=druga;
    }

    Interval(){
        pocetna_tacka = 0; krajnja_tacka = 0;
        pocetna_pripada = false; krajnja_pripada = false;
    }

    public boolean isNull(){
        if(!pocetna_pripada && !krajnja_pripada) return true;
        return false;
    }

    public boolean isIn (double tacka){
        if(!pocetna_pripada && !krajnja_pripada)
            if( tacka > pocetna_tacka && tacka < krajnja_tacka ) return true;

        else if( pocetna_pripada && krajnja_pripada )
            if( tacka >= pocetna_tacka && tacka <= krajnja_tacka ) return true;

        else if(pocetna_pripada && !krajnja_pripada)
            if( tacka >= pocetna_tacka && tacka < krajnja_tacka ) return true;

        else if(!pocetna_pripada && krajnja_pripada)
            if( tacka > pocetna_tacka && tacka <= krajnja_tacka ) return true;

        return false;
    }

    public Interval intersect(Interval i){
        double p1, k1;
        boolean poc, kraj;
        if(pocetna_tacka > i.pocetna_tacka){
            p1 = pocetna_tacka;
            poc = pocetna_pripada;
        }
        else{
            p1 = i.pocetna_tacka;
            poc = i.pocetna_pripada;
        }

        if(krajnja_tacka < i.krajnja_tacka){
            k1 = krajnja_tacka;
            kraj = krajnja_pripada;
        }
        else{
            k1 = i.krajnja_tacka;
            kraj = i.krajnja_pripada;
        }

        return new Interval(p1, k1, poc, kraj);
    }

    public static Interval intersect(Interval i1, Interval i2){
        return i1.intersect(i2);
    }

}
