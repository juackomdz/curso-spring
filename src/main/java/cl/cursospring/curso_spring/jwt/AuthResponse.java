package cl.cursospring.curso_spring.jwt;

public class AuthResponse {

    private String correo;
    private String token;
    
    public AuthResponse() {
    }

    public AuthResponse(String correo, String token) {
        this.correo = correo;
        this.token = token;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    
}
