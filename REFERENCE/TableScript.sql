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
	Card_Longitude		number(5,9)		not null,				-- 카드 마커 경도값
	Card_Latitude		number(5,9)		not null,				-- 카드 마커 위도값
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
	User_Reg_Date	varchar2(20) 	default to_char(sysdate)
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
	My_Feeling		char(1)			not null,				-- 관심글 기분 (1:, 2:, 3:, 4:, 5: )
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

