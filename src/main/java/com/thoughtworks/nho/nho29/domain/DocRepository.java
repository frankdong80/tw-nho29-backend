package com.thoughtworks.nho.nho29.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocRepository extends JpaRepository<Doc, Long> {

    List<Doc> findAllByTaskCardId(Long taskCardId);
}
