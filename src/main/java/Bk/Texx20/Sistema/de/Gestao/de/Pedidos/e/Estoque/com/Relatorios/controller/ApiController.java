package Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.controller;

import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.ItemPedido;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.Pedido;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.Produto;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.repository.ProdutosRepository;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final PedidoService pedidoService;
    private final ProdutosRepository produtosRepository;

    @PostMapping("/produtos")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtosRepository.findAll();
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> criarPedido(@RequestBody List<ItemPedido> itens ) {
        Pedido pedido = pedidoService.criarPedido(itens);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
}
