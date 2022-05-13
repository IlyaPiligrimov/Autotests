import java.util.Scanner;

public class FunctionCalcTriagle {

    public static void main(String[] args) {
        try {

            Scanner scanner= new Scanner(System.in);

            int a = 6;
            int b = 6;
            int c = 6;
            double s;
            double x;
            existenceTriagle(a,b,c);
            aSide(a);
            bSide(b);
            cSide(c);


            double d = ((a + b + c));
            double p = d / 2;

            System.out.println("Полупериметр треугольника=" + p);
            x = (p * ((p - a) * (p - b) * (p - c)));
            s = Math.sqrt(x);
            System.out.println("Площадь тpеугольника = " + s);


        } catch (Exception EX) {
            System.out.println(EX.getMessage());
        }


    }

    public static boolean aSide(double a) {
        if (a <= 1 || a >= 20) {
            System.out.println("No correct а");
        }return false;

    }

    public static boolean bSide(double b) {
        if (b <= 1 || b >= 20) {
            System.out.println("No correct в");
        }

        return false;
    }
        public static boolean cSide ( double c){
            if (c <= 1 || c >= 20) {
                System.out.println("No correct с");
            }return false;
        }

        public static boolean existenceTriagle (double a, double b , double c) {
            if ((a + b) < c || (a + c) < b || (b + c) < a) {
                System.out.println("Такой треугольник не существует");

            }else {
                if ((a != b) & (a != c) & (b != c)) {


                    System.out.println("Это разносторонний треугольник.");
                } else if ((a == b) & (b == c))
                    System.out.println("Это равносторонний треугольник.");

                else
                    System.out.println("Это равнобедренный треугольник.");
       return true;


            }
                return true; }

            }


