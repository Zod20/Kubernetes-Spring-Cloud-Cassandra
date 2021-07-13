package com.zod.userservice;

import com.zod.common.model.table.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {

  Optional<User> findByIdAndName(UUID id, String name);
}
