INSERT INTO reviews (meetup_id, member_id, content, rating, likes_count, views_count, is_public)
VALUES (1, 101, '첫 모임이었는데 분위기가 정말 좋았습니다!', 5, 12, 45, 'Y');

-- 후기 2 (비공개)
INSERT INTO reviews (meetup_id, member_id, content, rating, likes_count, views_count, is_public)
VALUES (2, 102, '장소가 조금 협소했지만 나름 괜찮았습니다.', 3, 5, 20, 'N');

-- 후기 3 (공개)
INSERT INTO reviews (meetup_id, member_id, content, rating, likes_count, views_count, is_public)
VALUES (3, 103, '참가자들과 네트워킹할 수 있어서 유익했어요.', 4, 8, 30, 'Y');

select*From meetup_applications;

SELECT DATE_FORMAT(B.created_at, '%Y.%m.%d') AS apply_at , 		   
			   B.reject_reason,
			   B.member_id AS apply_member_id,
			   B.status AS apply_status,
			   C.nickname, 
			   DATE_FORMAT(A.meetup_At, '%Y.%m.%d') as fomatMeetupAt, 
               A.*
		  FROM meetup_applications  AS B
          JOIN meetups  			AS A ON B.meetup_id = B.meetup_id and A.member_id = B.member_id
          JOIN members 			    AS C ON C.member_id = B.member_id
		 WHERE A.delete_yn = 'N' 
	       AND A.status != 'DELETED' 
		   AND B.status != 'CANCELED'
	       AND B.member_id = 21 
	     ORDER BY A.created_at DESC
		 LIMIT 1, 10	;
         delete from meetup_applications
		INSERT INTO meetup_applications (meetup_id, member_id)
		VALUES (#{meetupId}, 21) 
        select *from meetup_applications
SELECT DATE_FORMAT(B.created_at, '%Y.%m.%d') AS apply_at , B.reject_reason, B.member_id AS 
apply_member_id, B.status AS apply_status, C.nickname, DATE_FORMAT(A.meetup_At, '%Y.%m.%d') 
as fomatMeetupAt, A.* 
FROM meetup_applications AS B 
JOIN meetups AS A ON B.meetup_id = B.meetup_id 
and A.member_id = B.member_id 
JOIN members AS C ON C.member_id = B.member_id 
WHERE A.delete_yn 
= 'N' AND A.status != 'DELETED' AND B.status != 'CANCELED' AND B.member_id = 21
ORDER BY A.created_at DESC LIMIT 0, 4

select*from meetups 

-- 21