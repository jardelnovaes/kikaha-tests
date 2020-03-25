package kikahatest.mavenplugin.security;

import io.undertow.server.HttpServerExchange;
import kikaha.caffeine.CaffeineSessionStore;
import kikaha.core.modules.security.MonolithSessionStore;
import lombok.Getter;
import lombok.val;

import javax.inject.Inject;

/**
 * Created by miere.teixeira on 27/07/2017.
 */
public class HybridSessionStore extends MonolithSessionStore {

    @Getter
    @Inject
    CaffeineSessionStore sessionStore;

    @Override
    protected boolean shouldNotStoreSession(HttpServerExchange exchange) {
        val relativePath = exchange.getRelativePath();
        return relativePath.startsWith( "/api" ) && !relativePath.equals( "/api/reload-session" );
    }
}
