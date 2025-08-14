package Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.repository;

import Bk.Texx20.Sistema.de.Gestao.de.Pedidos.e.Estoque.com.Relatorios.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
