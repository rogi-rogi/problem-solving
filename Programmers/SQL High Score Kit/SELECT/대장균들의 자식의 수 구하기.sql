-- https://school.programmers.co.kr/learn/courses/30/lessons/299305
-- 대장균들의 자식의 수 구하기.sql

SELECT E1.ID,
       COUNT(E2.PARENT_ID) AS CHILD_COUNT
  FROM ECOLI_DATA AS E1
       LEFT JOIN
       ECOLI_DATA AS E2
       ON E1.ID = E2.PARENT_ID
 GROUP BY E1.ID
 ORDER BY 1;
