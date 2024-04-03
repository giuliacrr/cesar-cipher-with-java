public class CifrarioDiCesare {
    private static final String DIZIONARIO = "abcdefghijklmnopqrstuvwxyz0123456789àèìòùç"; // Dictonary we will use

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso <messaggio> <shift> <modalità(0/1)>");
            return;
        }
        // When user passes <messaggio> <numero_di_shift> <modalità(1/0)>
        // where 0 -> Crittografia , 1 -> Decrittografia)>

        String messaggio = args[0].toLowerCase(); // to simplify, let's lowercase the string
        int shift = Integer.parseInt(args[1]); // Number of shift (or "jumps") that we do to change index
        int modalità = Integer.parseInt(args[2]); // where 0 -> Crittografia , 1 -> Decrittografia
        String risultato = ""; // String where we will push result once encrypted/decrypted

        if (modalità == 1) {
            risultato = cripta(messaggio, shift); // call the method where args will be text and number of shifts
        } else if (modalità == 0) {
            risultato = decripta(messaggio, shift);
        } else { // Else will trigger if user enters something != 1 or 0
            System.out.println("Modalità non valida. Usa 1 per Crittografia e 0 per decrittografia");
            return;
        }
        System.out.println("Risultato : " + risultato); // Print on console the result
    }

    private static String cripta(String testo, int shift) {
        return trasforma(testo, shift);
    }

    private static String decripta(String testo, int shift) {
        return trasforma(testo, -shift); // shift is negative, since we have to go backwards while decrypting
    }

    public static String trasforma(String testo, int shift) {
        StringBuilder risultato = new StringBuilder(); // Will make result in a string from array

        for (char carattere : testo.toCharArray()) { // We iterate each character of the text that we transform in an
                                                     // Array of chars
            if (DIZIONARIO.indexOf(carattere) != -1) {
                int posizioneOriginale = DIZIONARIO.indexOf(carattere);
                // Supermario effect - like this, index doesn't trigger OutOfBoundException and
                // % will give us back the new position of the character
                int nuovaPosizione = (DIZIONARIO.length() + posizioneOriginale + shift) % DIZIONARIO.length();
                risultato.append(DIZIONARIO.charAt(nuovaPosizione));// Adds the character that corresponds to the new
                                                                    // position
            } else {
                risultato.append(carattere); // Adds them into Risultato string
            }
        }
        return risultato.toString(); // Returns the result risultato
    }

}