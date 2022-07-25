package cn.tuling.webfluxr2dbcmysql.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("user_t")
public class User {

 @Id
 private Integer id;
 private String username;
 private LocalDateTime birthday;
}
