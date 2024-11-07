package cl.cursospring.curso_spring.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import cl.cursospring.curso_spring.model.UsuarioModel;
import cl.cursospring.curso_spring.utilidades.Constantes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtTokenUtil {

    private static final long EXPIRATE_DURATION = 24*60*60*1000;


    public boolean validateAccessToken(String token){
        try {
            Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("JWT EXPIRADO: "+e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("TOKEN NULL, VACIO O CONTIENE ESPACIOS: "+e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("JWT ES INVALIDO: "+e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT NO SOPORTADO: "+e.getMessage());
        } catch (SignatureException e) {
            System.out.println("VALIDACION DE FIRMA ERRONEA");
        }
        return false;
    }

    private SecretKey getSignKey(){
        byte[] keysByte = Decoders.BASE64.decode(Constantes.SECRET);
        return Keys.hmacShaKeyFor(keysByte);
    }
    //muchas clases deprecadas
    public String generateToken(UsuarioModel usuario) {
        return Jwts.builder()
        .subject(String.format("%s,%s", usuario.getId(), usuario.getUsername()))
        .issuer("SPRING")
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + EXPIRATE_DURATION))
        .signWith(getSignKey())
        .compact();
    }

    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }


    //parseclaimsjws no esta definido??
    private Claims parseClaims(String token){
        return Jwts.parser()
            .verifyWith(getSignKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
    
}
