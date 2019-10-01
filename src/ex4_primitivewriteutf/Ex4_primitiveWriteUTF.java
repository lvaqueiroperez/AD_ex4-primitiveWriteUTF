/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4_primitivewriteutf;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Ex4_primitiveWriteUTF {

    /**
     * @param args the command line arguments
     */
    /*
     OJO! CERRAR LOS FLUJOS CADA VEZ QUE SE DEJEN DE UTILIZAR, NO TODOS AL FINAL
     NO LIAR EL CÓDIGO CON TRY CATCH INNECESARIOS, USAR THROWS !!!
     (CUANDO VEMOS QUE EL PROGRAMA FUNCIONA PODREMOS, AL FINAL, AÑADIR ALGÚN
     TRY CATCH SI QUEREMOS)
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        /*
         Propoñovos un exercicio que consistirá en grabar unha mesma cadea  de
         texto duas veces usando o metodo writeUTF  nun ficheiro denominado
         text3.txt para posteriormente recuperalos (voltalos a ler).
         */
        //escritura
        FileOutputStream escribir = null;
        BufferedOutputStream escribirBuffer = null;
        DataOutputStream escribirData = null;
        //lectura
        FileInputStream leer = null;
        BufferedInputStream leerBuffer = null;
        DataInputStream leerData = null;
        String lecturas = "";

        escribir = new FileOutputStream("/home/oracle/Desktop/ex4/texto3.txt");
        escribirBuffer = new BufferedOutputStream(escribir);
        escribirData = new DataOutputStream(escribirBuffer);

        leer = new FileInputStream("/home/oracle/Desktop/ex4/texto3.txt");
        leerBuffer = new BufferedInputStream(leer);
        leerData = new DataInputStream(leerBuffer);

        escribirData.writeUTF("o tempo está xélido");
        System.out.println("Bytes escritos: " + escribirData.size());

        escribirData.writeUTF("o tempo está xélido");
        System.out.println("Bytes escritos: " + escribirData.size());

        System.out.println("Bytes totales escritos: " + escribirData.size());
        escribirData.close();

        while (leerData.available() != 0) {

            lecturas = leerData.readUTF();
            System.out.println("Leemos cadena:" + lecturas);
            System.out.println("Quedan por leer:" + leerData.available());

        }

        leerData.close();
    }
}
