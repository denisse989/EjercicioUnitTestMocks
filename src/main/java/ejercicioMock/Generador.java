package ejercicioMock;

public class Generador {
    PrimoUtil primoUtil;
    boolean esPrimo;

    public Generador(PrimoUtil primoUtil) {
        this.primoUtil = primoUtil;
    }
    public Generador(){
        primoUtil=new PrimoUtil();
    }

    public String getNumberValues(int input){
        String numberList="";
        if(input>=1){
           esPrimo= primoUtil.esPrimo(input);
           if(esPrimo){
               for (int i = 1; i <= input; i+=2) {
                   numberList += i+" ";
               }

           }else{
               for(int i = 2; i<=input ; i+=2) {
                   numberList += i+" ";
               }
           }
        }else {
            throw new IllegalArgumentException("Dato incorrecto intentelo de nuevo");
        }

        return numberList.trim();

    }
}
