package cl.cursospring.curso_spring.utilidades;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utilidades {

    public static ResponseEntity<Object> generateResponse(HttpStatus status, String mensaje){
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            
            map.put("fecha", new Date());
            map.put("estado", status.value());
            map.put("mensaje", mensaje);
            return new ResponseEntity<>(map, status);

        } catch (Exception e) {
            map.clear();
            map.put("fecha", new Date());
            map.put("estado", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("mensaje", e.getMessage());
            return new ResponseEntity<>(map, status);
        }
    }
}
