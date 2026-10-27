package br.com.nomedaempresa.iniciandojava.controller;

import br.com.nomedaempresa.iniciandojava.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class ProdutoController {

    private ArrayList<Produto> database;

    public ProdutoController(){
        database = new ArrayList<>(){{
            add(new Produto(1, 1500.0, "Computador"));
            add(new Produto(2, 50.0, "Mouse"));
            add(new Produto(3, 100.0, "Teclado"));
            add(new Produto(4, 500.0, "Monitor"));
            add(new Produto(5, 800.0, "Impressora"));
        }};
    }

    @GetMapping("/produtos")
    public ResponseEntity<ArrayList<Produto>> getTodosProdutos(){
        if(database != null) return ResponseEntity.ok(database);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("produtos/{id}")
    public ResponseEntity<Produto> getProdutoPeloId(@PathVariable int id){
        Produto produto = database.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("produtos/sort")
    public ResponseEntity<List<Produto>> recuperarOrdenado(@RequestParam(name="order", required = false) String order){
        if(order == null) return ResponseEntity.ok(database);
        else if(order.equals("asc")){
            return ResponseEntity.ok(database.stream().sorted(Comparator.comparing(Produto::getPreco)).toList());
        }
        else if(order.equals("desc")){
            return ResponseEntity.ok(database.stream().sorted(Comparator.comparing(Produto::getPreco).reversed()).toList());
        }else {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> addNewProduto(@RequestBody Produto p){
        if(p != null) {
            database.add(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable int id, @RequestBody Produto produto){
        int posicao = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
        if(posicao >= 0) {
            database.set(posicao, produto);
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("produtos/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable int id){
        int posicao = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
        if(posicao >= 0){
            Produto produto = database.get(posicao);
            database.remove(posicao);
            return ResponseEntity.ok(produto);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
