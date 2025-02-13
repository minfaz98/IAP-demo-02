package lk.acpt.demofx;

public class Main {
 public static void main(String[] args) {
     Vehicle vehicle = new Vehicle("toyata","camry",2006,"red");



     CustomerController customerController = new CustomerController() {
         @Override
         public void pause() {
             CustomerController.super.pause();
         }
 };


}


}



