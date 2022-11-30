package com.hanghae.spring1.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    Optional<Memo> findByIdAndPassword(Long id, String password);
}