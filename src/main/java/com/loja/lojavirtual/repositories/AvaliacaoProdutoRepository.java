package com.loja.lojavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.lojavirtual.entities.AvaliacaoProduto;

@Repository
public interface AvaliacaoProdutoRepository extends JpaRepository<Long, AvaliacaoProduto>{
    
}
