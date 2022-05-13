import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.jupiter.api.*;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TriagleTest {
private static Logger logger = LoggerFactory.getLogger(TriagleTest.class);


@BeforeAll
static void beforeAll(){
    logger.info("INFO");
    logger.debug("Debug");
    logger.error("ERROR");
    System.out.println("Метод выполнился 1 раз перед всеми тестами класса");

}

@BeforeEach
void beforeEach   (){
    System.out.println("Метод выполняется перед каждым тестом");

}
@Test
@DisplayName("Проверка стороны а позитивная")
public void asideCheck() {
    boolean resultPozitive = FunctionCalcTriagle.aSide(12);
    Assertions.assertTrue(true);
}
    @Test
    @DisplayName("Проверка стороны а негативная")
    public void aSideCheckNegative(){
        boolean resultNegative = FunctionCalcTriagle.aSide(22);
        Assertions.assertFalse(false);

}

@Test
@DisplayName("Проверка стороны b позитивная")
public void bSideCheck(){
    boolean resultPozitive = FunctionCalcTriagle.bSide( 5);
    Assertions.assertTrue(true);
}
    @Test
    @DisplayName("Проверка стороны b негативная")
    public void bSideCheckNegative(){
        boolean resultNegative = FunctionCalcTriagle.bSide(44);
        Assertions.assertFalse(false);
    }
    @Test
    @DisplayName("Проверка стороны c позитивная")
    public void cSideCheck() {
        boolean resultPozitive = FunctionCalcTriagle.cSide(5);
        Assertions.assertTrue(true);


    }
    @Test
    @DisplayName("Проверка стороны b негативная")
    public void cSideCheckNegative(){
        boolean resultNegative = FunctionCalcTriagle.cSide(66);
        Assertions.assertFalse(false);
    }

@Test
@DisplayName("Проверка существования")
public void exictenceTriagle(){
    boolean resultNegative = FunctionCalcTriagle.existenceTriagle(2,33,6);
    boolean resultPozitive = FunctionCalcTriagle.existenceTriagle(5,5,5);
    Assertions.assertTrue(true);
    Assertions.assertFalse(false);
}
@Test
@DisplayName("Проверка какой именно треугольник")
public void triagleCheck(){
    boolean resultEquilateral = FunctionCalcTriagle.existenceTriagle(5,5,5);//равностороний
    boolean resultVersatile = FunctionCalcTriagle.existenceTriagle(5,6,8);//разносторонний
    boolean resultIsosceles = FunctionCalcTriagle.existenceTriagle(2,9,9);//равнобедренный
Assertions.assertTrue(resultEquilateral);
Assertions.assertTrue(resultIsosceles);
Assertions.assertTrue(resultVersatile);
}



@AfterEach
void afterEach() {

}

@AfterAll
    static void  afterAll(){
    System.out.println("Метод выполнилнится после всех тестов");

}
}




