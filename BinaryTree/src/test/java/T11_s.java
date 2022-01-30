import org.junit.jupiter.api.Test;

public class T11_s {

    @Test
    public static int  numberOfPins (int number, int number2)                                         // Line  1
    {
            if (number == 0 || number2 == 0)
                return 0;
            else                                                                                   // Line  4
                return ((number-1 + number2)+numberOfPins(number+1, number2+1));
        // Line 5
    }


    @Test
    void t(){
        System.out.println(numberOfPins(-5, -9));
        System.out.println(numberOfPins(-4, -8));
        System.out.println(numberOfPins(-6, -7));

    }
}
