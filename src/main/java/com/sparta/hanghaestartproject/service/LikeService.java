package com.sparta.hanghaestartproject.service;

import com.sparta.hanghaestartproject.dto.CompleteResponseDto;
import com.sparta.hanghaestartproject.entity.*;
import com.sparta.hanghaestartproject.errorcode.CommonErrorCode;
import com.sparta.hanghaestartproject.exception.RestApiException;
import com.sparta.hanghaestartproject.jwt.JwtUtil;
import com.sparta.hanghaestartproject.repository.*;
import com.sparta.hanghaestartproject.util.GetUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class LikeService {
     private final GetUser getUser;
     private final LikePostRepository likePostRepository;
     private final LikeCommentRepository likeCommentRepository;
     private final JwtUtil jwtUtil;
     private final PostRepository postRepository;
     private final CommentRepository commentRepository;
     private final UserRepository userRepository;
//     private Post post;
//     private User user;


     @Transactional
     public CompleteResponseDto likePost(Long id, HttpServletRequest request) {
          Post post = postRepository.findById(id)
                  .orElseThrow(() ->new RestApiException(CommonErrorCode.NO_ARTICLE));
          User user = getUser.getUser(request);       // security 이후 추가할듯 아마?

          if (likePostRepository.findByPostAndUser(post, user) == null) {
               // 좋아요 안눌렀으면 likePost 만들고 좋아요처리
//               post.setLiked(post.getLiked() + 1);             //좋아요 개수  - 추후에 수정
               LikePost likePost = new LikePost(post, user);
               likePostRepository.save(likePost);
               return CompleteResponseDto.success("따봉 추가");
          } else {
               // 좋아요 누른상태면 취소처리후 테이블 삭제
               LikePost likePost = likePostRepository.findByPostAndUser(post, user);
               likePost.unLikePost(post);
               likePostRepository.delete(likePost);
               return CompleteResponseDto.success("따봉 취소");
          }
     }

     @Transactional
     public CompleteResponseDto likeComment(Long id, HttpServletRequest request) {
          Comment comment = commentRepository.findById(id)
                  .orElseThrow(() ->new RestApiException(CommonErrorCode.NO_COMMENT));
          User user = getUser.getUser(request);       // security 이후 추가할듯 아마?

          if (likeCommentRepository.findByCommentAndUser(comment, user) == null) {
               // 좋아요 안눌렀으면 likeComment 만들고 좋아요처리
//               post.setLiked(post.getLiked() + 1);             //post_id 개수 countby 로 세면 좋아요갯수 가능할듯?  -최교수님의견
               LikeComment likeComment = new LikeComment(comment, user);
               likeCommentRepository.save(likeComment);
               return CompleteResponseDto.success("따봉 추가");
          } else {
               // 좋아요 누른상태면 취소처리후 테이블 삭제
               LikeComment likeComment = likeCommentRepository.findByCommentAndUser(comment, user);
               likeComment.unLikeComment(comment);
               likeCommentRepository.delete(likeComment);
               return CompleteResponseDto.success("따봉 취소");
          }
     }

}
