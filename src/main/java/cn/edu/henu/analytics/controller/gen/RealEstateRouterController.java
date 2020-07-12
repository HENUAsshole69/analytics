package cn.edu.henu.analytics.controller.gen;

import cn.edu.henu.analytics.entity.RealEstate;
import cn.edu.henu.analytics.entity.auth.Subject;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class RealEstateRouterController {
    private Map<String, TableController<?>> controllerMap;
    @Autowired
    public RealEstateRouterController(Map<String, TableController<?>> controllerMap) {
        this.controllerMap = controllerMap;
    }
    @RequestMapping(value = "/RealEstate/validate",method = RequestMethod.POST,consumes =
            MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> validate(@RequestBody byte[] bytes) throws IOException {
        return controllerMap.get("RealEstate").validate(bytes);
    }
    @RequestMapping(value = "/RealEstate/submit",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RealEstate> submit(@RequestBody RealEstate realEstate){
        return ((TableController<RealEstate>)controllerMap.get("RealEstate")).submit(realEstate);
    }
    @GetMapping("/RealEstate/page")
    public ResponseEntity<Page<RealEstate>> getReliabilityItemPage(@RequestParam int page, @RequestParam int size){
        return ((TableController<RealEstate>)controllerMap.get("RealEstate")).getItemPage(page,size);
    }
    @GetMapping("/RealEstate/item/{id}")
    public ResponseEntity<RealEstate> getItemById(@PathVariable Long id){
        return ((TableController<RealEstate>)controllerMap.get("RealEstate")).getItemById(id);
    }
    @DeleteMapping("/RealEstate/item/{id}")
    public ResponseEntity<Void> delItemById(@PathVariable Long id){
        ((TableController<RealEstate>)controllerMap.get("RealEstate")).repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/RealEstate/all/item")
    public ResponseEntity<List<RealEstate>> getAllItem(){
        return ResponseEntity.ok(((TableController<RealEstate>)controllerMap.get("RealEstate")).repo.findAll());
    }
    @GetMapping("/RealEstate/item/bySubmitter/{id}")
    public ResponseEntity<Page<RealEstate>> getItemPageBySubmitterId(@PathVariable Long id,@RequestParam int page,@RequestParam int size){
        val ex = new RealEstate();
        ex.submitter = new Subject();
        ex.submitter.setId(id);
        return ResponseEntity.ok(((TableController<RealEstate>)controllerMap.get("RealEstate")).repo.findAll(Example.of(ex),PageRequest.of(page,size)));
    }
}
