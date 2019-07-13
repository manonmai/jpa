package com.cg.main;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.cg.tms.entity.Address;
import com.cg.tms.util.EntityManagerUtils;

public class TestMain {
	public static void main(String[] args) {
		EntityManagerFactory entityManager = (EntityManagerFactory) EntityManagerUtils.getEntityManager();
		Address p = ((EntityManager) entityManager).find(Address.class, 10000);
		System.out.println(p.getAddressid()+" "+p.getState());
	}

}
