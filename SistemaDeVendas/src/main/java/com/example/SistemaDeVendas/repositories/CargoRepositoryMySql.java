package com.example.SistemaDeVendas.repositories;

import com.example.SistemaDeVendas.entities.Cargo;
import com.example.SistemaDeVendas.interfacies.ICargo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CargoRepositoryMySql implements ICargo {

        private EntityManager entityManager;

        @Autowired
        public CargoRepositoryMySql(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        @Transactional
        @Override
        public void salvar(Cargo cargo) {
            this.entityManager.persist(cargo);
        }

        @Override
        public Cargo buscarPorId(int id) {
            return this.entityManager.find(Cargo.class,id);
        }

        @Override
        public List<Cargo> buscarTodos() {
            return entityManager.createQuery("select s from Cargos s ORDER BY s.nameCargo",Cargo.class).getResultList();
        }

        @Transactional
        @Override
        public void atualizar(int id, Cargo cargo) {
            Cargo cargoInDB = this.entityManager.find(Cargo.class,id);

            cargoInDB.setNomeCargo(cargo.getNomeCargo());

            cargoInDB.setSalario(cargoInDB.getSalario());


            this.entityManager.merge(cargoInDB);
        }
        @Override
        @Transactional
        public void deletar(int id) {
            Query query = entityManager.createQuery("delete from Student s WHERE s.id = :id");

            query.setParameter("id" ,id);

            query.executeUpdate();
        }
        @Transactional
        public void deleteAll() {
            Query query = entityManager
                    .createQuery("delete from Student s");
            query.executeUpdate();
        }
    }
