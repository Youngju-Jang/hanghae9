package com.sparta.hanghaestartproject.entity;

import javax.persistence.*;

// @Getter의 역할.. get메소드를 대신 생성해준다. 32~46줄 참조
// @NoArgsConstructor의 역할.. 매개변수가 없는 기본 생성자를 대신 생성해준다. 15줄 참조
@Entity (name = "users")
public class User {
     //- username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성되어야 한다.
     //- password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성되어야 한다.
     //- DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환하기
     public User(){}

     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Long id;

     @Column (nullable = false, unique = true)
     private String username;

     @Column(nullable = false)
     private String password;

     @Column(nullable = false)
     @Enumerated(value = EnumType.STRING)
     private UserRoleEnum role;

     public Long getId() {
          return this.id;
     }

     public String getUsername() {
          return this.username;
     }

     public String getPassword() {
          return this.password;
     }

     public UserRoleEnum getRole() {
          return this.role;
     }

     //     @OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
//     private List<Post> posts = new ArrayList<>();

     public User(String username, String password, UserRoleEnum role) {
          this.username = username;
          this.password = password;
          this.role = role;
     }


}
