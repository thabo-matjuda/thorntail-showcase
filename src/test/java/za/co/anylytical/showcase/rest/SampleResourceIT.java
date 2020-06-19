package za.co.anylytical.showcase.rest;

//@RunWith( Arquillian.class)
public class SampleResourceIT {

//    @Deployment
//    public static Archive createDeployment() {
//
//        // Import Maven runtime dependencies
//        File[] libs = Maven.resolver()
//                .loadPomFromFile("pom.xml")
//                .importDependencies(ScopeType.COMPILE, ScopeType.TEST)
//                .resolve()
//                .withTransitivity()
//                .asFile();
//
//        WebArchive archive = ShrinkWrap.create( WebArchive.class, "thorntail-test-api.war");
//        archive.addPackages( Boolean.TRUE, "za.co.anylytical.showcase");
//        archive.addAsLibrary("project-defaults.yml");
//        archive.addAsLibraries( libs);
//
//        // print all included packages
//        System.out.println( archive.toString(true));
//
//        return archive;
//    }
//
//    // http://localhost:8881/that-service/text
//    @Test
//    public void testAPI() throws Exception {
//        given().when().get("http://localhost:8881/text")
//                .then().statusCode(200);
//    }
}