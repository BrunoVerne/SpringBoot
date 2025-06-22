package Spring.Proyecto.Controllers;

import Spring.Proyecto.dto.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonPlaceHolderController {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://jsonplaceholder.typicode.com";

    public JsonPlaceHolderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        String endpoint = baseUrl + "/posts";
        List<Post> post =  this.restTemplate.getForObject(endpoint, ArrayList.class);
        return ResponseEntity.ok(post);
    }

    public ResponseEntity<?> save(@RequestBody Post post){
        String endpoint = baseUrl + "/posts";
        Post postSave = this.restTemplate.postForObject(endpoint, post, Post.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(postSave);

    }


}