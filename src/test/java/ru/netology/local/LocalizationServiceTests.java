package ru.netology.local;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

public class LocalizationServiceTests {
    LocalizationService location = new LocalizationServiceImpl();

    @ParameterizedTest
    @MethodSource("getArguments")
    public void geoTest(String message, Country country) {
        Assertions.assertEquals(message, location.locale(country));
    }

    public static Stream<Arguments> getArguments() {
        String englishMessage = "Welcome";
        String russianMessage = "Добро пожаловать";
        return Stream.of(Arguments.of(englishMessage, Country.USA),
                Arguments.of(russianMessage, Country.RUSSIA),
                Arguments.of(englishMessage, Country.BRAZIL),
                Arguments.of(englishMessage, Country.GERMANY));
    }
}
