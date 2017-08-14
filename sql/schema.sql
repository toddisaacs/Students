--Useful converison data http://docs.oracle.com/cd/E19501-01/819-3659/gcmaz/
DROP TABLE CourseEnrollment;
DROP TABLE CourseSession;
DROP TABLE Course;
DROP TABLE Instructor;
DROP TABLE Student;

-- Create table Student 
CREATE TABLE Student (
	StudentId BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	FirstName VARCHAR(50),
	MiddleName VARCHAR(50),
	LastName VARCHAR(50) NOT NULL,
	Address VARCHAR(100) NOT NULL,
	Address2 VARCHAR(100),
	City VARCHAR(100) NOT NULL,
	StateCode VARCHAR(2) NOT NULL,
	ZipCode VARCHAR(7) NOT NULL
);


-- Create table Instructor using SMALLINT for SQL Server BIT
CREATE TABLE Instructor (
	InstructorId BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	FirstName VARCHAR(50),
	MiddleName VARCHAR(50),
	LastName VARCHAR(50) NOT NULL,
	Tenured SMALLINT
);

-- Create table Course using CLOB for SQL Server Text 
CREATE TABLE Course (
	CourseId BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	CourseCode VARCHAR(10) NOT NULL,
	ShortDesc VARCHAR(200) NOT NULL,
	Summary CLOB(64000)
);

-- Create table CourseSession using SMALLINT for SQL Server BIT
CREATE TABLE CourseSession (
	CourseSessionId BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	CourseId BIGINT NOT NULL REFERENCES Course(CourseId),
	InstructorId BIGINT NOT NULL REFERENCES Instructor(InstructorId),
	StartDate DATE NOT NULL,
	EndDate DATE NOT NULL, 
	Online SMALLINT
);

-- Create table CourseEnrollment 
CREATE TABLE CourseEnrollment (
	CourseEnrollmentId BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	CourseSessionId BIGINT NOT NULL REFERENCES CourseSession(CourseSessionId),
	StudentId BIGINT NOT NULL REFERENCES Student(StudentId)
);
