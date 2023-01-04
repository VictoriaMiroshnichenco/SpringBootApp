package com.miroshnicheko.springbootapp;

import com.miroshnicheko.data.Entity;
import com.miroshnicheko.repository.CommonRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class EntityRepository implements CommonRepository<Entity> {

    private Map<String,Entity> memoryStorage = new HashMap<>();

    @Override
    public Entity save(Entity entity) {
       Entity result = memoryStorage.get(entity.getId());
       if(result!=null){
           result.setDescription(entity.getDescription());
           result.setModifiedDate(LocalDateTime.now());
           entity=result;
       }
       memoryStorage.put(entity.getId(), entity);
       return memoryStorage.get(entity.getId());
    }

    @Override
    public Iterable<Entity> save(Collection<Entity> entities) {
        for (Entity e: entities) {
                this.save(e);
        }
        return  findAll();
    }

    @Override
    public void delete(Entity entity) {
        memoryStorage.remove(entity.getId());
    }

    @Override
    public Entity findById(String id) {
        return memoryStorage.get(id);
    }

    @Override
    public Iterable<Entity> findAll() {
        return memoryStorage.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
