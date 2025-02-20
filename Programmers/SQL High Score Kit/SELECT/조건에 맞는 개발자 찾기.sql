-- https://school.programmers.co.kr/learn/courses/30/lessons/276034
-- 조건에 맞는 개발자 찾기.sql

SELECT DISTINCT ID,
       EMAIL,
       FIRST_NAME,
       LAST_NAME
  FROM DEVELOPERS AS D
       INNER JOIN
       SKILLCODES AS S
       ON D.SKILL_CODE & S.CODE AND S.NAME IN ('Python', 'C#')
 ORDER BY 1;
