package cl.cursospring.curso_spring.jwt;

public class AuthResponse {

    private String user;
    private String token;
    

    public AuthResponse() {
    }


    public AuthResponse(String user, String token) {
        this.user = user;
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    
}
