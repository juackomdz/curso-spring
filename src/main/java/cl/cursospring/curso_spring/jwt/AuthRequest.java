package cl.cursospring.curso_spring.jwt;

public class AuthRequest {

    private String correo;
    private String pass;

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
