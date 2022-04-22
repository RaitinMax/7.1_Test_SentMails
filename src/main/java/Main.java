import java.util.HashMap;
import java.util.Map;

import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

public class Main {

    //Тестовый пример
    public static void main(String[] args) {
        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        geoService.byCoordinates(2.0, 5.1);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");
        messageSender.send(headers);
        geoService.byIp("172.0.32.11").getCountry();
    }
}