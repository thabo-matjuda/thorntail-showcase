package za.co.anylytical.showcase.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * @author: Thabo Lebogang Matjuda
 * @since: 2020-03-07
 * @email: <a href="mailto:thabo@anylytical.co.za">Anylytical Technologies</a>
 * <a href="mailto:tl.matjuda@gmail.com">Personal GMail</a>
 */

@Provider
public class CORSFilter implements ContainerResponseFilter {

    public static final String HTTP_METHODS_DELIMITER = ", ";
    public static final String HTTP_ALL_ORIGINS_DELIMITER = "*";

    public static final String ALLOW_ORIGIN_KEY = "Access-Control-Allow-Origin";
    public static final String ALLOW_HEADERS_KEY = "Access-Control-Allow-Headers";
    public static final String ALLOW_METHODS_KEY = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
                                             

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) {

        containerResponseContext.getHeaders().add( ALLOW_ORIGIN_KEY, HTTP_ALL_ORIGINS_DELIMITER);
        containerResponseContext.getHeaders().add( ALLOW_METHODS_KEY, getAllowedMethods());
        containerResponseContext.getHeaders().add( ACCESS_CONTROL_MAX_AGE, "-1");
        containerResponseContext.getHeaders().add( ALLOW_HEADERS_KEY, "Origin, X-Requested-With, Content-Type, Accept");
    }

    private static String getAllowedMethods() {
        return new StringBuilder()
                .append( "GET").append( HTTP_METHODS_DELIMITER)
                .append( "POST").append( HTTP_METHODS_DELIMITER)
                .append( "PUT").append( HTTP_METHODS_DELIMITER)
                .append( "DELETE").append( HTTP_METHODS_DELIMITER)
                .append( "OPTIONS").append( HTTP_METHODS_DELIMITER)
                .append( "HEAD")
                .toString();
    }
}
