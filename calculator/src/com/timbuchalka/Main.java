package com.timbuchalka;
//Kullanıcıdan iki deger alan ve dört islemi belirli sınırlamalarla yapan hesap makinesi projesi;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        double number1 ,number2,result;
        double numbers[] = new double[2];
        int menu;
        do
        {
            menu = MenuPrefer(); //ilk konsolda gösterilip ve secimin yaptırılacagı yerdir
            switch(menu)
            {
                case 1:
                    System.out.println(Messages.welcomeMessage); number1=GetDecimalNumber();
                    System.out.println(Messages.welcomeMessage2); number2=GetDecimalNumber();
                    result = Addition(number1,number2);
                    ResultDisplay(result);
                    break;
                case 2:
                    System.out.println(Messages.welcomeMessage); number1=GetDecimalNumber();
                    System.out.println(Messages.welcomeMessage2); number2=GetDecimalNumber();
                    result = Subtraction(number1,number2);
                    ResultDisplay(result);
                    break;
                    case 3:
                        System.out.println(Messages.welcomeMessage); number1=GetDecimalNumber();
                        System.out.println(Messages.welcomeMessage2); number2=GetDecimalNumber();
                result = Multiplication(number1,number2);
                if (result>99999999.0){
                   System.out.println("LUTFEN SAYILARI KUCULT!"); }
                else
                ResultDisplay(result);
                break;
                case 4:
                    System.out.println(Messages.welcomeMessage); number1=GetDecimalNumber(); //ilk sayıyı ekrandan isteyen çıktı
                    System.out.println(Messages.welcomeMessage2); number2=GetDecimalNumber();// ikinci sayıyı ekrandan isteyen çıktı
                    result = Division(number1,number2);// sonuc = sayı1/sayı2
                    if (number2==0){
                        System.out.println(Messages.zeromessage);
                    }
                    else
                    ResultDisplay(result); //sonucgoster(sonuc)
                    break;

                case 5:
                    break; // break komutlarıyla islem yaptıktan sonra islemi bitir demek istiyoruz.
                default:
                    Scanner show = new Scanner(System.in);
                    System.out.println(Messages.finalmessage);
                    System.out.println(Messages.getFinalmessage);
                    show.nextLine();
                    break;
            }
        }
        while( menu!=5 );
        System.out.println(Messages.exitmassege);
    }
    public static void MenuOpen() //MenuPrefer metodunun içinde çagırılır ve ekranda görünen ilk çıktıdır.
    {
        System.out.println(Messages.choosemessage);
    }
    /* bu metodda kullanıcıdan bir tam sayı girişi istenir
    kontrol edildikten sonra int tipinde değilse bir hata mesajı verir ve sizden tekrar seçim yapmanızı ister
    döngümüz while oldugundan dolayı istenilen tipi girene kadar tekrar eder.
     */
    public static int MenuPrefer()
    {
        int number;
        MenuOpen();
        System.out.println(Messages.choosemessage2);
        while (true)

            try
            {
                Scanner scan = new Scanner(System.in);
                number = scan.nextInt();
                return number;
            }
            catch (InputMismatchException e)
            {
                System.out.println(Messages.errormessage2);
            }
        }

    public static double GetDecimalNumber()
    {
        double number;
        while (true)
        {
            try
            {
                Scanner scan = new Scanner(System.in);
                number = scan.nextDouble();
                return number;
            }
            catch (InputMismatchException e)
            {
                System.out.println(Messages.errormessage);
            }
        }
    }
    public static double Addition(double number1,double number2)
    {
        return number1+number2;
    }
    public static double Subtraction(double number1,double number2)
    {
        return number1-number2;
    }
    public static double Division(double number1,double number2)
    {
        return number1/number2;
    }
    public static double Multiplication(double number1,double number2)
    {
        return number1*number2;
    }

    public static void ResultDisplay( double number)
    {
        Scanner show = new Scanner(System.in);
        System.out.println(Messages.resultmessage +number);
        System.out.println(Messages.againmessage);
        show.nextLine();
    }
}
