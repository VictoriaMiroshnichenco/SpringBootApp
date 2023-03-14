package com.miroshnicheko.client;

import com.miroshnicheko.client.error.EntityErrorHandler;
import com.miroshnicheko.data.Entity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
@Service
public class ToDoRestClient {
    private RestTemplate restTemplate;
    private ToDoRestClientProperties properties;
    public ToDoRestClient(
            ToDoRestClientProperties properties){
        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(
                new EntityErrorHandler());
        this.properties = properties;
    }

    public Iterable<Entity> findAll() throws URISyntaxException {
        RequestEntity<Iterable<Entity>> requestEntity = new RequestEntity
                <Iterable<Entity>>(HttpMethod.GET,new URI(properties.getUrl() +
                properties.getBasePath()));
        ResponseEntity<Iterable<Entity>> response =
                restTemplate.exchange(requestEntity,new
                        ParameterizedTypeReference<Iterable<Entity>>(){});
        if(response.getStatusCode() == HttpStatus.OK){
            return response.getBody();
        }
        return null;
    }
    public Entity findById(String id){
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        return restTemplate.getForObject(properties.getUrl() +
                properties.getBasePath() + "/{id}",Entity.class,params);
    }
    public Entity upsert(Entity toDo) throws URISyntaxException {
        RequestEntity<?> requestEntity = new RequestEntity<>(toDo, HttpMethod.
                POST, new URI(properties.getUrl() + properties.getBasePath()));
        ResponseEntity<?> response = restTemplate.exchange(requestEntity, new
                ParameterizedTypeReference<Entity>() {});
        if(response.getStatusCode() == HttpStatus.CREATED){
            return restTemplate.getForObject(response.getHeaders().
                    getLocation(),Entity.class);
        }
        return null;
    }
    public Entity setCompleted(String id) throws URISyntaxException{
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        restTemplate.postForObject(properties.getUrl() + properties.getBasePath() + "/{id}?_method=patch",null,ResponseEntity.class, params);
        return findById(id);
    }
    public void delete(String id){
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        restTemplate.delete(properties.getUrl() + properties.getBasePath() +"/{id}",params);
    }
    }
