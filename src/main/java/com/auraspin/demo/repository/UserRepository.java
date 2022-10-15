package com.auraspin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auraspin.demo.entity.CreateEntity;

public interface UserRepository extends  JpaRepository<CreateEntity, Long> {

}
