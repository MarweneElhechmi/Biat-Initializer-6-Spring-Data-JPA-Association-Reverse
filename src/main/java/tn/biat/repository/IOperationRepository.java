package tn.biat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.biat.entities.Operation;


public interface IOperationRepository extends JpaRepository<Operation,Long>{

}
