package br.com.espiaoamigo.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.espiaoamigo.dao.AbstractDao;
import br.com.espiaoamigo.dao.GenericDao;
import br.com.espiaoamigo.model.Location;


@Repository("locationDao")
public class LocationDaoImpl extends AbstractDao<Location> implements GenericDao<Location> {
	public LocationDaoImpl() {
		super(Location.class);
	}
}
