package pl.btbw.modules.home;

import pl.btbw.core.thymeleaf.HtmlResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/home")
public class HomeController {

    @GET
    @Path("/html")
    public HtmlResponse html2() {

        List<AddressView> addresses = new ArrayList<>();
        addresses.add(new AddressView("Warszawa"));
        addresses.add(new AddressView("Gdańsk"));
        addresses.add(new AddressView("Kraków"));

        return new HtmlResponse("test.html")
                .add("home", new HomeView("Lorem Ipsum"))
                .add("address", new AddressView("Gdańsk", "Poland", "00-000", 12))
                .add("addresses", addresses)
                ;
    }

}
