package com.nems.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.socialmedia.models.Share;
@Repository
public interface ShareRepository extends CrudRepository<Share, Integer>{

}
