package net.juliomurillo.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.juliomurillo.shopping.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}