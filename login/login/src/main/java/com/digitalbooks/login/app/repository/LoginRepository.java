package com.digitalbooks.login.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.digitalbooks.login.app.entity.AuthorLoginEntity;

public interface LoginRepository extends CrudRepository<AuthorLoginEntity, Integer>, JpaRepository<AuthorLoginEntity, Integer> {

	public Optional<AuthorLoginEntity> findByUserName(String userName);

	public Optional<AuthorLoginEntity> findByUserId(int userId);

}
