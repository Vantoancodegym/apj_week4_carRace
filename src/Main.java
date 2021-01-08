import model.Car;

public class Main {
    public static void main(String[] args) {
        Car carA=new Car("car A");
        Car carB=new Car("car B");
        Car carC=new Car("car C");
        Thread t1=new Thread(carA);
        Thread t2=new Thread(carB);
        Thread t3=new Thread(carC);
        t1.start();
        t2.start();
        t3.start();
    }
}
