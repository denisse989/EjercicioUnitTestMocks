package ejercicioMockTest;

import ejercicioMock.Generador;
import ejercicioMock.PrimoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GeneradorTest {
    //PASO 2
    PrimoUtil primoUtilMock=Mockito.mock(PrimoUtil.class);

    @Test
    public void verifyNumberValuesPrimo(){
        //PASO3
        Mockito.when(primoUtilMock.esPrimo(11)).thenReturn(true);

        Generador generador=new Generador(primoUtilMock);
        String actualResult=generador.getNumberValues(11);
        String expectedResult= "1 3 5 7 9 11";

        Assertions.assertEquals(expectedResult,actualResult,"ERROR!! la respuesta es incorrecta");

        Mockito.verify(primoUtilMock).esPrimo(11);
    }
    @Test
    public void verifyNumberValuesNoPrimoImpar(){
        //PASO3
        Mockito.when(primoUtilMock.esPrimo(21)).thenReturn(false);

        Generador generador=new Generador(primoUtilMock);
        String actualResult=generador.getNumberValues(21);
        String expectedResult= "2 4 6 8 10 12 14 16 18 20";

        Assertions.assertEquals(expectedResult,actualResult,"ERROR!! la respuesta es incorrecta");

        Mockito.verify(primoUtilMock).esPrimo(21);
    }

    @Test
    public void verifyNumberValuesNoPrimoPar(){
        //PASO3
        Mockito.when(primoUtilMock.esPrimo(8)).thenReturn(false);

        Generador generador=new Generador(primoUtilMock);
        String actualResult=generador.getNumberValues(8);
        String expectedResult= "2 4 6 8";

        Assertions.assertEquals(expectedResult,actualResult,"ERROR!! la respuesta es incorrecta");

        Mockito.verify(primoUtilMock).esPrimo(8);
    }
    @Test
    public void verifyException(){
        Generador generador=new Generador();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {generador.getNumberValues(-1);} );
    }
}
