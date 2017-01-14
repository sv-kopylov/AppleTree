package appletree;

public class Processor {

    class purelements {

        double K, Ph, Az;
    };

    class ferti {

        double amonSelitr, superPhos, sulfatKaly;
    };
    final double ASinclude = 0.34;
    final double SPhinclude = 0.49;
    final double SulKinclude = 0.53;
    final double Pi = 3.1415926;

    purelements minE = new purelements();
    purelements maxE = new purelements();
    ferti minF = new ferti();
    ferti maxF = new ferti();
    double radius, S;

    String CalcAndSay(String rad) {
        String message;

        try {
            radius = Double.valueOf(rad);
            radius/=100;
            S = Pi * radius * radius;
            
            minE.K = 10 * S;
            maxE.K = 15 * S;
            minE.Ph = 6 * S;
            maxE.Ph = 10 * S;
            minE.Az = 9 * S;
            maxE.Az = 12 * S;
            minF.amonSelitr = minE.Az / ASinclude;
            maxF.amonSelitr = maxE.Az / ASinclude;
            minF.superPhos = minE.Ph / SPhinclude;
            maxF.superPhos = maxE.Ph / SPhinclude;
            minF.sulfatKaly = minE.K / SulKinclude;
            maxF.sulfatKaly = maxE.K / SulKinclude;
            
            message = "<html><body>"
                    + " <font size=\"6\"> <b>Результаты</b><br></font>  <font size=\"5\">В год для такого дерева нужно:</font>"
                    + " <br><br><font size=\"4\">Азота (N) в граммах: от " +
                    (int)minE.Az + " до " + (int)maxE.Az + 
                    "<br>Такое количество азота содержится в<br>"+
                    (int)minF.amonSelitr + " - " + (int)maxF.amonSelitr +
                    " граммах амиачной селитры<br><br>"+
                    "Фосфора (P2O5) в граммах: от " +(int)minE.Ph + " до " +(int)maxE.Ph +
                    " <br>"+
                    "Такое количество фосфора содержится в<br>"+
                    (int)minF.superPhos + " - " +(int)maxF.superPhos +
                    " граммах гранулированного двойного суперфосфата<br><br>"+
                    "Калия (K2O)в граммах: от " + (int)minE.K + " до " + (int)maxE.K + " <br>"+
                    "Такое количество калия содержится в<br>"+
                    (int)minF.sulfatKaly + " - " +(int)maxF.sulfatKaly + " граммах сульфата калия<br>"+
                    "</font></body></html>";

        } catch (Exception e) {
            message = "<html><body> <font size=\"5\" color=\"red\">Некорректный ввод, нужно ввести радиус приствольного круга в сантиметрах, см. рисунок </font></body></html>";
        }

        
        return message;
    }

}
