//package com.sparta.hanghaestartproject.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Getter
//@Entity
//@NoArgsConstructor
//public class LikeComment extends Timestamped{
//
//     @Id
//     @GeneratedValue (strategy = GenerationType.AUTO)
//     private Long id;
//
//     @Column (nullable = false)
//     private String username;
//
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name="comment_id")
//     private Comment comment;
//
//}
