public class Concello {
    private double latitude;
    private double lonxitude;
    private int ID;

    public Concello(double latitude, double lonxitude, int ID) {
        this.latitude = latitude;
        this.lonxitude = lonxitude;
        this.ID = ID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLonxitude() {
        return lonxitude;
    }

    public int getID() {
        return ID;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLonxitude(double lonxitude) {
        this.lonxitude = lonxitude;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public Integer calculoDistancia(Concello lejano){
        int r=6371;
        double diferenciaLat= Math.toRadians(lejano.getLatitude()-this.getLatitude());
        double diferenciaLonx= Math.toRadians(lejano.getLonxitude()-this.getLonxitude());
        double cosenoLatInicio= Math.cos(Math.toRadians(this.getLatitude()));
        double cosenoLatFinal= Math.cos(Math.toRadians(lejano.getLatitude()));
        double senoLat=Math.sin(diferenciaLat/2);
        senoLat=Math.pow(senoLat,2);
        double senoLonx=Math.sin(diferenciaLonx/2);
        senoLonx=Math.pow(senoLonx,2);
        double resultadoParcial= senoLat+(cosenoLatInicio* cosenoLatFinal* senoLonx);
        resultadoParcial= Math.sqrt(resultadoParcial);
        resultadoParcial= Math.asin(resultadoParcial);
        double resultado= 2 * r * resultadoParcial;
        int result=(int)Math.ceil(resultado);
        return result;
    }
}
