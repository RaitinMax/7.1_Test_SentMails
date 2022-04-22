
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceTests {
    GeoService geoService;


    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests starts");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test started");
        geoService = new GeoServiceImpl();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test finished");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests finished");
    }
//
//    @ParameterizedTest
//    @MethodSource("getArguments")
//    public void geoTest(String ip, Country country) {
//        Assertions.assertEquals(geoService.byIp(ip),country );
//    }
//
//    public static Stream<Arguments> getArguments() {
//        return Stream.of(Arguments.of("172.0.122.112", Country.RUSSIA), Arguments.of("96.444.1211.1557", Country.USA));
//    }

    @ParameterizedTest
    @MethodSource("getArguments2")
    public void geoTest2(double latitude, double longitude)  throws RuntimeException{
       var expected = RuntimeException.class;
        Assertions.assertEquals(geoService.byCoordinates(latitude, longitude), expected);
    }

    public static Stream<Arguments> getArguments2() {
        return Stream.of(Arguments.of(12.0, 5.0), Arguments.of(13.0, 6.0));
    }
}
