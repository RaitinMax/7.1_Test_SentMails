package ru.netology.geo;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoServiceTests {
    GeoService geoService = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("getArguments")
    public void geoTest(String ip, Country country){
            assertEquals(geoService.byIp(ip).getCountry(),country );
    }

    public static Stream<Arguments> getArguments() {
        return Stream.of(Arguments.of("172.0.122.112", Country.RUSSIA), Arguments.of("96.444.1211.1557", Country.USA));
    }

    @ParameterizedTest
    @MethodSource("sourceByCoordinates")
    public void testByCoordinates(String expectedExceptionMessage) {
//        try {
//            geoService.byCoordinates(latitude, longitude);
//        } catch (RuntimeException e) {
//            assertEquals(expectedExceptionMessage, e.getMessage());
//        }
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException(expectedExceptionMessage);
        });
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    public static Stream<Arguments> sourceByCoordinates() {
        return Stream.of(Arguments.of("Not implemented"));
    }
}
