--SQL Server Tasks
-- Question 1
-- SELECT  s.*
-- FROM    STUDENT s
-- WHERE   lower(s.LASTNAME) like 'j%'
-- ORDER BY s.FIRSTNAME;

-- Question 2
-- SELECT  i.INSTRUCTORID, i.FIRSTNAME, i.LASTNAME
-- FROM    INSTRUCTOR i 
-- WHERE NOT EXISTS (SELECT * 
--                     FROM    COURSESESSION cs  
--                     WHERE   i.INSTRUCTORID = cs.INSTRUCTORID
--                     AND     cs.STARTDATE >= Date('2014-08-25') 
--                     AND     cs.ENDDATE <= Date('2015-05-08'))
-- ORDER BY i.LASTNAME, i.FIRSTNAME;

-- no session at all
-- select i.FIRSTNAME, cs.COURSEID, cs.STARTDATE, cs.ENDDATE
-- from INSTRUCTOR i LEFT OUTER JOIN COURSESESSION cs
-- ON i.INSTRUCTORID = cs.INSTRUCTORID
-- where cs.COURSEID is null;


-- Question 3
-- SELECT  i.FIRSTNAME,  i.LASTNAME, cs.STARTDATE, cs.ENDDATE, count(*) as "Course Load"
-- FROM    INSTRUCTOR i, COURSESESSION cs
-- WHERE   i.INSTRUCTORID = cs.INSTRUCTORID
-- AND     cs.STARTDATE >= Date('2015-01-12') 
-- AND     cs.ENDDATE <= Date('2015-05-08')
-- GROUP BY i.FIRSTNAME, i.LASTNAME, cs.STARTDATE, cs.ENDDATE
-- ORDER BY i.LASTNAME, i.FIRSTNAME;


-- Question 4

-- SELECT  coalesce(s.LASTNAME, '') || ', ' || coalesce(s.FIRSTNAME, '') || ' ' || coalesce(s.MIDDLENAME, '') as Student,
--         c.COURSECODE as "Course Code",
--         c.SHORTDESC as "Course Desctipion",
--         coalesce(i.LASTNAME, '') || ', ' || coalesce(i.FIRSTNAME, '') || ' ' || coalesce(i.MIDDLENAME, '') as Instructor,
--         cs.ONLINE,
--         cs.STARTDATE as "Start Date",
--         cs.ENDDATE as "End Date"
-- 
-- FROM    STUDENT s, COURSEENROLLMENT ce, COURSESESSION cs, COURSE c, INSTRUCTOR i
-- WHERE   s.STUDENTID = ce.STUDENTID
-- AND     ce.COURSESESSIONID = cs.COURSESESSIONID
-- AND     cs.COURSEID = c.COURSEID
-- AND     i.INSTRUCTORID = cs.INSTRUCTORID
-- AND     cs.STARTDATE >= Date('2014-08-25')
-- AND     cs.ENDDATE <= Date('2015-05-08')
-- ORDER BY s.LASTNAME, s.FIRSTNAME, s.MIDDLENAME, cs.STARTDATE;

-- Question 5
-- SELECT  *
-- FROM    COURSE c 
-- WHERE NOT EXISTS (SELECT * 
--                     FROM    COURSESESSION cs  
--                     WHERE   c.COURSEID = cs.COURSEID
--                     AND     cs.STARTDATE >= Date('2014-08-25') 
--                     AND     cs.ENDDATE <= Date('2015-05-08'))
-- ORDER BY  c.COURSECODE;

-- Question 6
-- insert into course (COURSECODE,SHORTDESC, SUMMARY) values ('CIS401', 'Modern SPA Web Development', 'CIS302 is a prerequisite for this course. This advanced level course focuses on best practices for client-side web
-- application development using Single Page Application JavaScript frameworks.');

-- question 7
-- T-SQL 


--Question 8
-- alter table student add column registered SMALLINT;
-- alter table student drop column registered;

-- Question 9
-- update STUDENT 
-- set registered = 1
-- where STUDENTID in (select s.STUDENTID
--                     from    STUDENT s, COURSEENROLLMENT e
--                     where s.STUDENTID = e.STUDENTID);

select * from STUDENT;

-- question 10
-- T-SQL 