package cl.cursospring.curso_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cursospring.curso_spring.jwt.AuthRequest;
import cl.cursospring.curso_spring.jwt.AuthResponse;
import cl.cursospring.curso_spring.jwt.JwtTokenUtil;
import cl.cursospring.curso_spring.model.UsuarioModel;
import cl.cursospring.curso_spring.service.UsuarioService;
import cl.cursospring.curso_spring.utilidades.Utilidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class accessController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private UsuarioService service;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /*
     * {"user":"alan brito","pass":"54321"}
     * 
     * {
    "user":"alan brito",
    "pass":"54321"
    }
     * 
     */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            
            
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPass()));

            System.out.println("auth= "+auth);

            UsuarioModel model = service.buscarUsuario(req.getUsername());
            String accessToken = jwtUtil.generateToken(model);

            AuthResponse response = new AuthResponse(req.getUsername(), accessToken);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
           
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        }
    }
    

    /* {
        "id":"6",
        "username":"pablo salazar",
        "pass":"1234"
        }
         */
    @PostMapping("/registrar")
    public ResponseEntity<Object> categoria_post(@RequestBody UsuarioModel entity) {
        service.guardar(new UsuarioModel(entity.getUsername(),encoder.encode(entity.getPass())));
        return Utilidades.generateResponse(HttpStatus.CREATED, "creado con exito");
    }
    
}
