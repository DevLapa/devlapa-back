package com.devlapa.o_pai_o.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeradordeIdServices {
    private final Random random = new Random();
        public <T> Long geradorDeId(JpaRepository<T, Long> repository){
            Long id;
            do{
                id = (long)(0000 + random.nextInt(9000));
            }while (repository.existsById(id));
            return  id;
        }
}
