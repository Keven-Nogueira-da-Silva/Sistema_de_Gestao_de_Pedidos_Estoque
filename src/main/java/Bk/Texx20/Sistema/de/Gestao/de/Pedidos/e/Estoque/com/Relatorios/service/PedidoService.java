package Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.service;

import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.ItemPedido;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.Pedido;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.Produto;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.repository.PedidoRepository;
import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutosRepository produtosRepository;

    @Transactional
    public Pedido criarPedido(List<ItemPedido> itens) {
        Pedido pedido = new Pedido();
        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            Produto produto = produtosRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
            produtosRepository.save(produto);

            item.setSubtotal(produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
            item.setPedido(pedido);

            total = total.add(item.getSubtotal());

        }
        pedido.setItens(itens);
        pedido.getTotal();

        return pedidoRepository.save(pedido);
    }

}
