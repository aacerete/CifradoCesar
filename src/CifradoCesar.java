import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 46990527d on 24/11/16.
 */
public class CifradoCesar {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String text;
        int codi;
        char opcio;

        //Introduim el text
        System.out.print("Introdueix el text: ");
        text = sc.nextLine();


        //Introduim el desplaçament

        System.out.print("Introduce el desplazamiento: ");
        codi = sc.nextInt();


        //Introducim la operació : xifrar o desxifrar
        do {
            sc.nextLine();
            System.out.print("(X)ifrar o (D)esxifrar?: ");
            opcio = (char) System.in.read();
        } while (Character.toUpperCase(opcio) != 'X' && Character.toUpperCase(opcio) != 'D');

        if (Character.toUpperCase(opcio) == 'X') {
            System.out.println("Text xifrat: " + xifratCesar(text, codi));
        } else {
            System.out.println("Texto desxifrat: " + desxifratCesar(text, codi));
        }
    }

    //mètode per a xifrar el text
    public static String xifratCesar(String text, int codi) {

        StringBuilder xifrat = new StringBuilder();
        codi = codi % 26;

        //per a tot el contingut de text, per a cada posicio:
        for (int i = 0; i < text.length(); i++) {

            //si no conté un espai
            if (text.charAt(i)!=' '){

                if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                    if ((text.charAt(i) + codi) > 'z') {
                        xifrat.append((char) (text.charAt(i) + codi - 26));
                    } else {
                        xifrat.append((char) (text.charAt(i) + codi));
                    }

                } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                    if ((text.charAt(i) + codi) > 'Z') {
                        xifrat.append((char) (text.charAt(i) + codi - 26));
                    } else {
                        xifrat.append((char) (text.charAt(i) + codi));
                    }
                }
            }else{
            xifrat.append(' ');
        }


        }
        return xifrat.toString();
    }

    //métode per a desxifrar el text
    public static String desxifratCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {

            if (texto.charAt(i)!=' '){

                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }

            }else{
                cifrado.append(' ');
            }


        }
        return cifrado.toString();
    }
} //Fin cifrado Cesar