package org.example;
    import java.util.Arrays;

    public class CifradoCesarFuerzaBruta {
        public static char[] abecedario = " 'abcdefghijklmnñopqrstuvwxyz".toCharArray();
        private static int desplazamiento = 0;

        public static void main(String[] args) {
            String textoCifrado = "Si Cupdmzaplil Uikpwuis Icbwuwti lm Tmfpkw oi lmamtxmvilw cu xixms " +
                    "xzwbiñwupkw mu si opabwzpi g mu si nwztikpwu lm ucmabzw xipa. Sia bizmia " +
                    "acabiubpdia lm mabi puabpbckpwu xcjspki, icbwuwti g sipki awu si lwkmukpi, si " +
                    "pudmabpñikpwu g si lpncapwu lm si kcsbczi. Mu ms tculw ikilmtpkw ma zmkwuwkpli kwtw cui cupdmzaplil lm mfkmsmukpi. " +
                    "Si CUIT zmaxwulm is xzmamubm g tpzi ms ncbczw kwtw ms xzwgmkbw kcsbczis " +
                    "tia ptxwzbiubm lm Tmfpkw. Si CUIT ma cu maxikpw lm spjmzbilma. Mu mssi am xzikbpki kwbplpiuitmubm " +
                    "ms zmaxmbw, si bwsmziukpi g ms lpiswñw. Si xsczisplil lm plmia g lm " +
                    "xmuaitpmubw ma ixzmkpili kwtw apñuw lm ac zpycmhi g ucuki kwtw nikbwz lm " +
                    "lmjpsplil.";

            for (desplazamiento = 1; desplazamiento <= 27; desplazamiento++) {
                System.out.println("Desplazamiento " + desplazamiento + ": " + descifrar(textoCifrado, desplazamiento));
            }
        }

        public static String descifrar(String texto, int desplazamiento) {
            StringBuilder resultado = new StringBuilder();
            for (char i : texto.toCharArray()) {
                int indice = encontrarIndice(i);
                if (indice != -1) {
                    // Calcular la nueva posición
                    int nuevaPosicion = (indice - desplazamiento + abecedario.length) % abecedario.length;
                    resultado.append(abecedario[nuevaPosicion]);
                } else {
                    // Si no es una letra del abecedario, agregarlo sin cambios
                    resultado.append(i);
                }
            }
            return resultado.toString();
        }

        private static int encontrarIndice(char letra) {
            for (int j = 0; j < abecedario.length; j++) {
                if (abecedario[j] == letra) {
                    return j;
                }
            }
            return -1; // No encontrado
        }
    }
