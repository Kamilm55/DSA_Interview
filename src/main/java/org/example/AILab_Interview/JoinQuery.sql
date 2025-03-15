-- https://livesql.oracle.com/next/

-- To create two tables for storing student information and their scores,
-- and then join them to calculate the average score for each student,
-- ordered by the average score in descending order,
-- here's how you can do it in Oracle SQL:

-- Creating tables
CREATE TABLE students (
     student_id NUMBER PRIMARY KEY,
     first_name VARCHAR2(100),
     last_name VARCHAR2(100),
     dob DATE,
     email VARCHAR2(100)
);
-- CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1; -- oracle sql auto increment primary key (Use the Sequence in an INSERT Statement
-- You can use student_seq.NEXTVAL to automatically generate student_id)
--   student_id INT AUTO_INCREMENT PRIMARY KEY, -- mysql
--  student_id SERIAL PRIMARY KEY, -- postgres
CREATE TABLE student_scores (
      score_id NUMBER PRIMARY KEY,
      student_id NUMBER,
      score NUMBER,
     CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(student_id)
);

-- Inserting data into students table
INSERT INTO students (student_id, first_name, last_name, dob, email)
VALUES (1, 'John', 'Doe', TO_DATE('2000-01-01', 'YYYY-MM-DD'), 'john.doe@example.com');

INSERT INTO students (student_id, first_name, last_name, dob, email)
VALUES (2, 'Jane', 'Smith', TO_DATE('2001-02-15', 'YYYY-MM-DD'), 'jane.smith@example.com');

-- Inserting data into student_scores table
INSERT INTO student_scores (score_id, student_id, score)
VALUES (1, 1, 85);

INSERT INTO student_scores (score_id, student_id, score)
VALUES (2, 1, 92);

INSERT INTO student_scores (score_id, student_id, score)
VALUES (3, 2, 78);

INSERT INTO student_scores (score_id, student_id, score)
VALUES (4, 2, 88);

INSERT INTO student_scores (score_id, student_id, score)
VALUES (5, 2, 91);

-- Answer of question:
SELECT s.student_id,
       s.first_name,
       s.last_name,
       AVG(ss.score) AS average_score
FROM students s
/*INNER*/ JOIN student_scores ss ON s.student_id = ss.student_id
GROUP BY s.student_id, s.first_name, s.last_name
ORDER BY average_score DESC;

--  All non-aggregated columns must be in GROUP BY.

