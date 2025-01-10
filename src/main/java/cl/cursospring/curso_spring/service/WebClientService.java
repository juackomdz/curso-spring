package cl.cursospring.curso_spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.cursospring.curso_spring.model.PostsDTO;
import cl.cursospring.curso_spring.model.ResponseWebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {


    WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();


    public Flux<ResponseWebClient> getPost(){
        return client.get().uri("/todos/1").retrieve().bodyToFlux(ResponseWebClient.class);
    }

    public Flux<ResponseWebClient> getPostId(Integer id){
        return client.get().uri("/todos/"+id).retrieve().bodyToFlux(ResponseWebClient.class);
    }

    public Mono<ResponseWebClient> postTodo(ResponseWebClient res){
        return client.post().uri("/todos").bodyValue(res).retrieve().bodyToMono(ResponseWebClient.class);
    }
}
