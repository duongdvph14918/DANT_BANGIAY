package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import com.fourmen.entity.Accounts;
import com.fourmen.entity.Authorities;

public interface AuthoritiesService {

	Authorities getById(Long id);

	void delete(Authorities entity);

	void deleteById(Long id);

	Optional<Authorities> findById(Long id);

	List<Authorities> findAll();

	 Authorities save(Authorities entity);
	
	public List<Authorities> findAuthoritiesOfAdminstrators();

	Accounts findAcountAuthority(Long idAcc);

	int findAcountAuthorityCheck(Long idAcc);

}
