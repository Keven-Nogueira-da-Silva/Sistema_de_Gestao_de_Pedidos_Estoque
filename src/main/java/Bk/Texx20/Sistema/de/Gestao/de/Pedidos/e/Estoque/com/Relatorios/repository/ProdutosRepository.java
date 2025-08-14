package Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.repository;

import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);


}
