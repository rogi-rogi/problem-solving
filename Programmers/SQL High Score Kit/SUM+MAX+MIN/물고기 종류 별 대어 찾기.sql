-- https://school.programmers.co.kr/learn/courses/30/lessons/293261
-- 물고기 종류 별 대어 찾기.sql

SELECT F.ID,
       FN.FISH_NAME,
       F.LENGTH
  FROM FISH_INFO AS F
       INNER JOIN
       FISH_NAME_INFO AS FN
       ON F.FISH_TYPE = FN.FISH_TYPE
 WHERE F.LENGTH = (SELECT MAX(LENGTH) FROM FISH_INFO WHERE FISH_TYPE = F.FISH_TYPE)
 ORDER BY F.ID;
