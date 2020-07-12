package cn.edu.henu.analytics.controller.gen;

import com.google.gson.JsonObject;
import lombok.val;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import xyz.luchengeng.spread.common.exception.InvalidInputException;
import xyz.luchengeng.spread.reader.SpreadSheetReader;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public class TableController<T> {
    private SpreadSheetReader reader;
    public JpaRepository<T,Long> repo;
    public TableController(SpreadSheetReader reader,
                           JpaRepository<T,Long> repo){
        this.reader = reader;
        this.repo = repo;
    }
    public ResponseEntity<String> validate(byte[] bytes){
        JsonObject obj;
        try {
            obj = reader.read(new ByteArrayInputStream(bytes));
        }catch (InvalidInputException invalidInputException){
            return ResponseEntity.badRequest()
                    .header("col", Objects.requireNonNull(invalidInputException.getCol()).toString())
                    .header("row", Objects.requireNonNull(invalidInputException.getRow()).toString())
                    .header("sheet",invalidInputException.getSheetName())
                    .header("type",invalidInputException.getType().toString())
                    .build();
        }
        return ResponseEntity.ok()
                .body(obj.toString());
    }
    public ResponseEntity<T> submit(T t){
        return ResponseEntity.ok(this.repo.save(t));
    }

    public ResponseEntity<Page<T>> getItemPage(int page,int size){
        return ResponseEntity.ok(repo.findAll(PageRequest.of(page,size)));
    }
    public ResponseEntity<T> getItemById( Long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }
}
