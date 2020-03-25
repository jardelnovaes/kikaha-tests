package kikahatest.mavenplugin;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import kikaha.config.Config;
import kikaha.core.modules.smart.Filter;
import kikaha.core.modules.smart.FilterChainFactory;
import kikaha.core.modules.undertow.Redirect;
import lombok.Getter;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HttpsRedirectFilter implements Filter {

    static final HttpString X_Forwarded_Proto = new HttpString( "X-Forwarded-Proto" );

    @Inject Config config;

    @Getter(lazy = true)
    private final String capacitorHost = config.getString( "kikaha-test.maven-plugin.host" );

    @Override
    public void doFilter( HttpServerExchange httpServerExchange, FilterChainFactory.FilterChain filterChain ) throws Exception {
        val header = httpServerExchange.getRequestHeaders().getFirst( X_Forwarded_Proto );
        if ( header != null && header.equals( "http" ) )
            Redirect.to( httpServerExchange, getCapacitorHost() );
        else
            filterChain.runNext();
    }
}
