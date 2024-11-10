package nextstep.security.authentication;

public class UsernamePasswordAuthenticationToken implements Authentication{

    private final Object principal;
    private final Object credentials;
    private final boolean authenticated;

    public UsernamePasswordAuthenticationToken(Object principal, Object credentials, boolean authenticated) {
        System.out.println("UsernamePasswordAuthenticationToken.UsernamePasswordAuthenticationToken");
        this.principal = principal;
        this.credentials = credentials;
        this.authenticated = authenticated;
    }

    public static UsernamePasswordAuthenticationToken unauthenticated(String principal, String credentials) {
        System.out.println("UsernamePasswordAuthenticationToken.unauthenticated");
        return new UsernamePasswordAuthenticationToken(principal, credentials, false);
    }

    public static UsernamePasswordAuthenticationToken authenticated(String principal, String credentials) {
        System.out.println("UsernamePasswordAuthenticationToken.authenticated");
        return new UsernamePasswordAuthenticationToken(principal, credentials, true);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public Object isAuthenticated() {
        return authenticated;
    }
}