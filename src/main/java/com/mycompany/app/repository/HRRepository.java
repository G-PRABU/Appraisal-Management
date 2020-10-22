package com.mycompany.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.app.model.HR;

public interface HRRepository extends JpaRepository<HR,Long>{
    public Optional<HR> findByEmail(String username); 

    @Query("select h from HR h where " + "lower(h.name) like lower(concat('%',:name,'%')) or lower(h.email) like lower(concat('%',:name,'%'))" )
	public List<HR> findByName(@Param("name") String name);

}
