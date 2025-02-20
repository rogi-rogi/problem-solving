-- https://school.programmers.co.kr/learn/courses/30/lessons/298518
-- 특정 물고기를 잡은 총 수 구하기.sql

SELECT COUNT(*) AS "FISH_COUNT"
  FROM FISH_INFO AS I
       INNER JOIN
       FISH_NAME_INFO AS NI
       ON I.FISH_TYPE = NI.FISH_TYPE AND NI.FISH_NAME IN ("BASS", "SNAPPER");
