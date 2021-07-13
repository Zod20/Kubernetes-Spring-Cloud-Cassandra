package com.zod.common.model.table;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Data
@Table("user")
public class User  {

  @Id
  @PrimaryKeyColumn(name="id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  @Column("id")
  private UUID id;

  @Column("name")
  private String name;

}
