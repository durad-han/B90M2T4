-----------------------------------------------------------------------------------------------------------------
-- ( FORM ) Sequence & Table
-----------------------------------------------------------------------------------------------------------------
--drop table tb_Around_??tableName;
--drop sequence s_Around_??tableName;
--
--create sequence s_Around_??tableName;
--
--create table tb_Around_??tableName (
--	Column_Name			Type(size) primary key,		-- 샘플 (시퀀스)
--	Column_Name			Type(size),					-- 샘플
--	Column_Name			Type(size)					-- 샘플
--);


-----------------------------------------------------------------------------------------------------------------
-- Card Sequence & Table
-----------------------------------------------------------------------------------------------------------------
drop table tb_Around_Card;
drop sequence s_Around_Card;

create sequence s_Around_Card;

create table tb_Around_Card (
	Card_Seq			number(6) 		primary key,			-- 카드 고유번호 (시퀀스)
	User_Seq			number(6) 		not null,				-- 카드 작성자 시퀀스 (FK)
	Card_Content		varchar2(420)	not null,				-- 카드 내용 (140글자)
	Card_Feeling		char(1) 		not null,				-- 카드 기분 (1:, 2:, 3:, 4:, 5: )
	Card_Hashtag		varchar2(420) 	not null,				-- 카드에 작성된 해시태그 ( #.. ; #.. ) ; 을 사용하여 구분
	Card_Longitude		number(14)		not null,				-- 카드 마커 경도값
	Card_Latitude		number(14)		not null,				-- 카드 마커 위도값
	Card_Img_Path		varchar2(200),							-- 카드 배경 이미지 주소값
	Card_Reg_Date		varchar2(20) 	default to_char(sysdate)
);

-----------------------------------------------------------------------------------------------------------------
-- User Sequence & Table
-----------------------------------------------------------------------------------------------------------------
drop table tb_Around_User;
drop sequence s_Around_User;

create sequence s_Around_User;

create table tb_Around_User (
	User_Seq		number(6) 		primary key,			-- 유저 고유번호 (시퀀스)
	User_Id			varchar2(24) 	not null,				-- 유저 아이디
	User_Pass		varchar2(24),							-- 유저 비밀번호 (널값 가능)
	User_Reg_Date	varchar2(20) 	default to_char(sysdate),
	User_Key		varchar2(24)							-- 유저 키
);

-----------------------------------------------------------------------------------------------------------------
-- Comment Sequence & Table
-----------------------------------------------------------------------------------------------------------------
drop table tb_Around_Comment;
drop sequence s_Around_Comment;

create sequence s_Around_Comment;

create table tb_Around_Comment (
	Comment_Seq			number(6) 		primary key,			-- 댓글 고유번호 (시퀀스)
	User_Seq			number(6)		not null,				-- 댓글 작성자 시퀀스 (FK)
	Card_Seq			number(6)		not null,				-- 댓글이 달린 카드 시퀀스 (FK)
	Comment_Content		varchar2(420)	not null,				-- 댓글 내용 (140글자)
	Comment_Img_Path	varchar2(200),							-- 댓글 배경 이미지 주소값
	Comment_Reg_Date	varchar2(20) 	default to_char(sysdate)
); 

-----------------------------------------------------------------------------------------------------------------
-- My Sequence & Table
-----------------------------------------------------------------------------------------------------------------
drop table tb_Around_My_Favorite;
drop sequence s_Around_My_Favorite;

create sequence s_Around_My_Favorite;

create table tb_Around_My_Favorite (
	My_Seq			number(6) 		primary key,			-- 관심글 고유번호 (시퀀스)
	User_Seq		number(6)		not null,				-- 관심글 작성자 시퀀스 (FK)
	My_Content		varchar2(420)	not null,				-- 관심글 내용 (140글자)
	My_Hashtag		varchar2(420)	not null,				-- 관심글에 작성된 해시태그 ( #.. ; #.. ) ; 을 사용하여 구분
	My_Feeling		char(1)			not null,				-- 관심글 기분 (1:veryGood, 2:good, 3:soso, 4:bad, 5:terrible )
	My_Reg_Date		varchar2(20) 	default to_char(sysdate)
); 

-----------------------------------------------------------------------------------------------------------------
-- Hashtag Sequence & Table
-----------------------------------------------------------------------------------------------------------------
drop table tb_Around_Hashtag;
drop sequence s_Around_Hashtag;

create sequence s_Around_Hashtag;

create table tb_Around_Hashtag (
	Hashtag_Seq			number(6) 		primary key,	-- 해시태그 고유번호 (시퀀스)
	Hashtag_Content		varchar2(90)	not null,		-- 해시태그 내용 (30글자)
	Hashtag_Frequency	number(6) 		default 1
); 

-----------------------------------------------------------------------------------------------------------------
-- Img Sequence & Table
-----------------------------------------------------------------------------------------------------------------
drop table tb_Around_Img;
drop sequence s_Around_Img;

create sequence s_Around_Img;

create table tb_Around_Img (
	Img_Seq			number(2) 		primary key,		-- 이미지 고유번호 (시퀀스)
	Img_Path		varchar2(200)	not null			-- 이미지 저장 경로
); 

-----------------------------------------------------------------------------------------------------------------
--  테이블 Sample 입력
-----------------------------------------------------------------------------------------------------------------

-- user1 : admin, user2~4 : tester
insert	into tb_Around_User (user_seq, user_id, user_pass)
		values (s_Around_User.nextval, 'admin', 'admin');
insert	into tb_Around_User (user_seq, user_id, user_pass)
		values (s_Around_User.nextval, 'tester01', 'tester01');
insert	into tb_Around_User (user_seq, user_id, user_pass)
		values (s_Around_User.nextval, 'tester02', 'tester02');
insert	into tb_Around_User (user_seq, user_id, user_pass)
		values (s_Around_User.nextval, 'tester03', 'tester03');
		
-- card1~7 : card card card	
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 1, '첫번째 카드는 어드민이 작성했답니다', 1, '#첫글 #첫카드 #샘플임', 11111111, 22222222);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 2, '두번째 카드는 테스터가 작성했답니다', 1, '#야호 #샘플임', 11111111, 11111111);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 2, '세번째 카드도 테스터가 작성했답니다', 1, '#야호 #샘플임', 11111111, 11111111);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 3, '네번째라고 별다를 거 없다', 3, '#샘플', 11111111, 11111111);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '야 인마!', 5, '#샘플 #버럭', 11111111, 11111111);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '여기서부터는', 5, '#샘플 #설명충', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미 데이터다', 5, '#샘플 #더미', 11111111, 11111111);		

		
		
		insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미 데이터다', 5, '#샘플 #더미', 37.4908343, 127.0313272);
-- card	8~16 : dummy	
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 1, '#샘플 #더미', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 2, '#샘플 #더미', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 3, '#샘플 #더미데이터', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 4, '#샘플 #더미데이터', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 5, '#샘플 #더미데이터', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 5, '#샘플 #더미데이터', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 5, '#샘플 #더미데이터', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 5, '#샘플 #더미데이터', 11111111, 11111111);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미더미더미더미더미더미더미더미', 5, '#샘플 #더미데이터', 11111111, 11111111);		
		
-- hashtag : #첫글 #첫카드 #샘플임(3) #샘플(13) #야호(2) #버럭 #설명충 #더미(3) #더미데이터(7)
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '첫글', 1);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '첫카드', 1);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '샘플임', 3);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '샘플', 13);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '야호', 2);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '버럭', 1);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '설명충', 1);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '더미', 3);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '더미데이터', 7);
		
-- 	comments	
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 2, 1, '와~ 첫글이당');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 3, 1, '와~ 첫글이당ㅎ');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 4, 1, '와~ 첫글이당ㅋ');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 1, 1, '자설리');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 1, 1, '설얍');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 2, 2, '콩까지마');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 2, 2, '콩까지마');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 3, 2, '콩까지마!');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 3, 2, '콩까지마!');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 4, 2, '콩까지마!!');
insert	into tb_Around_Comment (Comment_Seq, User_Seq, Card_Seq, Comment_Content)
		values (s_Around_Comment.nextval, 4, 2, '콩까지마!!');
		
-- my
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 2, '1번글', '#태그1', 1);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 3, '2번글', '#태그1', 2);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 2, '3번글', '#태그1', 3);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 4, '4번글', '#태그2', 4);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 4, '5번글', '#태그2', 5);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 3, '6번글', '#태그2', 2);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 2, '7번글', '#태그실험', 2);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 2, '8번글', '#태그실험', 5);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 4, '9번글', '#태그실험', 5);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 2, '10번글', '#태그실험', 5);
insert	into tb_Around_My_Favorite (My_Seq, User_Seq, My_Content, My_Hashtag, My_Feeling)
		values (s_Around_My_Favorite.nextval, 2, '11번글', '#태그실험', 5);


-------------------------------------------------------------------------------------------------------------------
----  테스트용 table & sample
-------------------------------------------------------------------------------------------------------------------
--drop table tb_Around_Test;
--drop sequence s_Around_Test;
--
--create sequence s_Around_Test;
--
--create table tb_Around_Test (
--	Test_Seq		number(6) 		primary key,			
--	Test_Int		number(6),			
--	Test_String		varchar2(24)		
--);		
--
--insert	into tb_Around_Test (Test_Seq, Test_Int, Test_String)
--		values (s_Around_Test.nextval, 1, '샘플01');
--insert	into tb_Around_Test (Test_Seq, Test_Int, Test_String)
--		values (s_Around_Test.nextval, 2, '샘플02');
--insert	into tb_Around_Test (Test_Seq, Test_Int, Test_String)
--		values (s_Around_Test.nextval, 3333, '샘플03');
		
-------------------------------------------------------------------------------------------------------------------
----  거리계산으로 인한 수정사항 및 샘플 데이터
-------------------------------------------------------------------------------------------------------------------		
delete from tb_around_card;

alter table tb_around_card modify(card_longitude number(9,6));
alter table tb_around_card modify(card_latitude number(9,6));

insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 1, '첫번째 카드는 어드민이 작성했답니다', 1, '#첫글 #첫카드 #샘플임', 127.028179, 37.497755);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 2, '두번째 카드는 테스터가 작성했답니다', 1, '#야호 #샘플임', 127.027857, 37.495950);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 2, '세번째 카드도 테스터가 작성했답니다', 1, '#야호 #샘플임', 127.027621, 37.495397);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 3, '네번째라고 별다를 거 없다', 3, '#샘플', 127.028511, 37.494895);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '야 인마!', 5, '#샘플 #버럭', 127.027492 , 37.493227);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '여기서부터는', 5, '#샘플 #설명충', 127.028254, 37.492733);		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 4, '더미 데이터다', 5, '#샘플 #더미', 127.030325, 37.492699);

		
		
		
		
		
		
		
		
		
		
		
		
		
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 1, '오늘 너무 즐겁게 먹고, 재밌게 놀았네요', 1, ' #맛집 #강남역 #클럽 #매스', 127.026222, 37.499394);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 12, '강남 털드림의원에서 머리 심었어요', 3, ' #탈모 #모발이식 #ㅋㅋㅋ', 127.026174, 37.500045);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 32, '강남역 맛집 어디가 맛있나요?', 2, ' #맛집 #강남역 #도씨에빛', 127.028457, 37.495194);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 23, '토익 점수가 너무 안오르네요 ㅜㅜ', 4, ' #토익 #영단기 #해커스', 127.025466, 37.500251);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 14, '세븐 스프링 너무 맛있어요', 2, ' #세븐스프링 #강남역 #맛집', 127.030245 , 37.490690);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 15, '우울한 하루', 5, ' #우울 #ㅜㅜ #슬픔', 127.039245 , 37.5018990);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 35, '밤새 코딩함 ㅜㅜ', 4, ' #선민찡 #ㅜㅜ', 127.027245 , 37.493690);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 13, '오늘 클럽 물 좋나요? 밤사냐 매스냐 엔비냐 고민중..', 2, ' #클럽 #밤사 #매스 #엔비', 127.025579 , 37.500510);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 16, '고시원 방에서 가만히 생각해보니 내가 방인가 방이 나인가 구분이 안감', 5, ' #고시원 #탈출하고싶다 #미래고시원', 127.030359, 37.496790);



insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '맛집', 23);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '강남역', 32);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '비트캠프', 47);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '목포', 39);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, 'CGV', 27);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '구글', 14);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '요가', 35);

		
		
		
		
		
		
		
		
		
		
		
		
------------ 또 추가 -------------------	
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 16, '고시원 방에서 가만히 생각해보니 내가 방인가 방이 나인가 구분이 안감', 5, ' #고시원 #탈출하고싶다 #미래고시원', 127.030359, 37.496790);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 56, '빗소리가 너무 좋네요.', 3, ' #비 #빗소리 #주륵주륵', 127.025224, 37.492765);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 31, '골프 한판 치고나니 이제 사는 것 같습니다. 역시 사람은 운동을 하고 살아야.....', 1, ' #골프 #운동 #80타', 127.023695, 37.497047);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 18, '우리 애가 벌써 초딩이 됩니다. 축하해 주세요^^', 1, ' #서초초등학교 #초딩 #입학식 #ㅋㅋㅋ', 127.023938, 37.499233);
insert	into tb_Around_Card (card_seq, user_seq, card_content, card_feeling, card_hashtag, CARD_LONGITUDE, 	CARD_LATITUDE )
		values (s_Around_Card.nextval, 14, '우리 애가 벌써 초딩이 됩니다. 축하해 주세요^^', 1, ' #서초초등학교 #초딩 #입학식 #ㅋㅋㅋ', 127.023938, 37.499233);


		
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '초딩', 24);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '편의점', 11);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '버거킹', 52);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, 'KFC', 28);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '토익', 73);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, 'BMW', 21);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '벤츠', 11);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '치과', 31);
insert	into TB_AROUND_HASHTAG (hashtag_seq, Hashtag_Content, Hashtag_Frequency)
		values (s_AROUND_HASHTAG.nextval, '독서실', 33);