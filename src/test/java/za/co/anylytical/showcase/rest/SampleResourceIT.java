package za.co.anylytical.showcase.rest;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith( Arquillian.class)
public class SampleResourceIT {

    @Deployment
    public static Archive createDeployment() {
        WebArchive webArtifact = ShrinkWrap.create( WebArchive.class, "thorntail-test-api.war");
        webArtifact.addPackages( Boolean.TRUE, "za.co.anylytical.showcase");
        webArtifact.addAsWebResource("project-defaults.yml");

        // Print all file and included packages
        System.out.println( webArtifact.toString(true));

        return webArtifact;
    }

    @Test
    public void test_That_We_Reach_Our_WebResource_Just_Fine_Yea() throws Exception {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8881/that-service/text");
        Response response = target.request().get();
        int statusCode = response.getStatusInfo().getStatusCode();
        String reponseBody = response.readEntity(String.class);
        assertEquals( 200, statusCode);
        
        System.out.println("RESPONSE CODE : " + statusCode);
        System.out.println("RESPONSE BODY : " + reponseBody);
    }
}