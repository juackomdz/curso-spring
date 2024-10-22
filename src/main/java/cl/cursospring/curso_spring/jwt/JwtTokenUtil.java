package cl.cursospring.curso_spring.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import cl.cursospring.curso_spring.model.UsuarioModel;
import cl.cursospring.curso_spring.utilidades.Constantes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

    private static final long EXPIRATE_DURATION = 24*60*60*1000;
    /* 
    public boolean validateAccessToken(String token){

    }
*/

    private SecretKey getSignKey(){
        byte[] keysByte = Decoders.BASE64.decode(Constantes.FIRMA);
        return Keys.hmacShaKeyFor(keysByte);
    }
    //muchas clases deprecadas
    public String generateToken(UsuarioModel usuario) {
        return Jwts.builder()
        .subject(String.format("%s,%s", usuario.getUsername(), usuario.getPassword()))
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

    /* 
        // Método de ejemplo para uso
        public static void main(String[] args) {
            // Crear claims
            Claims claims = Jwts.claims().setSubject("usuario@example.com");
            claims.put("role", "admin");
    
            // Generar un token
            String token = generateToken(claims);
            System.out.println("Token generado: " + token);
    
            // Parsear el token
            Claims parsedClaims = parseClaims(token);
            if (parsedClaims != null) {
                System.out.println("Claims parseados: " + parsedClaims);
            }
        }

*/
    
}
