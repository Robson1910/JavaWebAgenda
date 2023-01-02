package io.github.robson.connection;

import java.util.HashSet;

import io.github.robson.model.ContatoEntities;

public interface ContatoInterfaceDAO {

	HashSet<ContatoEntities> List();

	void insert(ContatoEntities contato);

	void select(ContatoEntities contato);

	void update(ContatoEntities contato);

	void delete(ContatoEntities contato);
}
