-- https://school.programmers.co.kr/learn/courses/30/lessons/298517
-- 가장 큰 물고기 10마리 구하기.sql

SELECT ID, LENGTH
  FROM FISH_INFO
 WHERE LENGTH > 10
 ORDER BY LENGTH DESC, ID LIMIT 10;
