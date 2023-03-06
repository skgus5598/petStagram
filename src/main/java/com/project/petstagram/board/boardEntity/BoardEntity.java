package com.project.petstagram.board.boardEntity;

import com.project.petstagram.board.boardDto.BoardResponse;
import com.project.petstagram.myPet.myPetEntity.MypetEntity;
import com.project.petstagram.user.userEntity.UserEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "PET_BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "board_seq_generator")
    @SequenceGenerator( name = "board_seq_generator",sequenceName = "board_seq",initialValue = 1, allocationSize = 1)
    @Column(name = "board_no")
    private Long boardNo;

    @ManyToOne // many = board , user = one 한명의 유저는 여러개의 게시글을 쓸 수 있음
    @JoinColumn(name = "user_no") // FK , 양방향 / 연관관계의 주인
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "pet_no")  // FK, 일대일 / 펫이름은 구분자로 구문하여 한번에 저장/ 이름만 저장할거기또래
    private MypetEntity myPet;

    @Column(name = "board_contents")
    private String boardContents;

    @Column(name = "board_regdate")
    @CreationTimestamp
    private Date boardRegdate;



}
