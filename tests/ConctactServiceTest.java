import com.solstice.restfulapi.controllers.ContactController;
import com.solstice.restfulapi.models.Address;
import com.solstice.restfulapi.models.Contact;
import org.assertj.core.api.Assertions;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.time.LocalDate;

@FixMethodOrder(MethodSorters.JVM)
public class ConctactServiceTest extends JerseyTest {
    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(ContactController.class);
    }

    @Test
    public void postTest() {
        Response output = target("/contact").request().post(Entity.entity(new Contact("tom", "solstice", null, "tomas.j.pais@gmail.com", Date.valueOf(LocalDate.parse("1995-11-15")), 44438353L, 1132075813L, new Address(509L, "Aquiles", "Buenos Aires", "Buenos Aires")), MediaType.APPLICATION_JSON + "; charset=UTF8"));
        Assertions.assertThat(output.getStatus()).isEqualTo(200);
        Assertions.assertThat(output.readEntity(Contact.class)).isNotNull();
    }

    @Test
    public void deleteContactTest() {
        Response output = target("/contact/1").request().delete();
        Assertions.assertThat(output.getStatus()).isEqualTo(200);
        Assertions.assertThat(output.readEntity(Contact.class)).isNotNull();
    }

    @Test
    public void invalidGetByIdRequestTest() {
        Response output = target("/contact/helloworld").request().get();
        Assertions.assertThat(output.getStatus()).isEqualTo(404);
    }

    @Test
    public void entityNotFoundExceptionTest() {
        Response output = target("/contact/1").request().get();
        Assertions.assertThat(output.getStatus()).isEqualTo(500);
    }
}
