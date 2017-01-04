
create database i80;
use i80;

create table Lead(
	leadId int NOT NULL AUTO_INCREMENT, 
	courseName varchar(200), 
	leadName varchar(200),
	leadEmail varchar(120),
	leadMobile varchar(20),	
	PRIMARY KEY (leadId)
) AUTO_INCREMENT=1; 

create table Users(
	userId int NOT NULL AUTO_INCREMENT, 
	userHandle varchar(256),
	courseId int NOT NULL, 
	fullName varchar(200),
	email varchar(120),
	mobile varchar(20),	
	PRIMARY KEY (userId),
	FOREIGN KEY (courseId)
    REFERENCES Courses(courseId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) AUTO_INCREMENT=1; 
--insert into Users(userHandle,fullName,email,mobile,courseId) values("mkpanda","Manas Panda","manas.k.panda@gmail.com","9886707787",1);

--Not used currently
--e.g. "Complete Java Developer Program" will contain, Java, Advanced Java, SQL, Front-end programming
create table CourseBundles(
	courseBundleId int NOT NULL AUTO_INCREMENT, 
	courseBundleName varchar(400),
	PRIMARY KEY (courseBundleId)
)AUTO_INCREMENT=1; 


--e.g. Java, Python etc
create table Courses(
	courseId int NOT NULL AUTO_INCREMENT, 
	extCourseId varchar(100) UNIQUE,
	courseName varchar(400),
	PRIMARY KEY (courseId)
)AUTO_INCREMENT=1; 
--insert into Courses(courseName,extCourseId) values("Java","java");
--insert into Courses(courseName,extCourseId) values("SQL","sql");
--insert into Courses(courseName,extCourseId) values("Advanced Java","adv-java");

-- OOP, Inheritence, Polymorphism etc
create table CourseSections(
	courseSectionId int NOT NULL AUTO_INCREMENT, 
	extSectionId varchar(100) UNIQUE,
	sectionName varchar(400),
	courseId int NOT NULL,
	PRIMARY KEY (courseSectionId),
	FOREIGN KEY (courseId)
    REFERENCES Courses(courseId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
)AUTO_INCREMENT=1;
--insert into CourseSections(extSectionId,sectionName,courseId) values('java-intro','Introduction to Java',1);
--insert into CourseSections(extSectionId,sectionName,courseId) values('java-basics','Language Basics',1);
--insert into CourseSections(extSectionId,sectionName,courseId) values('java-oop','Object Oriented Programming',1);
--insert into CourseSections(extSectionId,sectionName,courseId) values('java-exceptions','Exception Handling',1);
--insert into CourseSections(extSectionId,sectionName,courseId) values('sql-intro','Introduction to SQL',2);
--insert into CourseSections(extSectionId,sectionName,courseId) values('sql-basic-join','Basic joins in SQL',2);


-- Pages contains snippets
create table LessonPages(
	pageId int NOT NULL AUTO_INCREMENT, 
	extPageId varchar(100) UNIQUE,
	pageName varchar(400),
	courseSectionId int NOT NULL,
	PRIMARY KEY (pageId),
	FOREIGN KEY(courseSectionId)
    REFERENCES CourseSections(courseSectionId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
)AUTO_INCREMENT=1; 
-- insert into LessonPages(extPageId,pageName,courseSectionId) values('java-oop-quiz1','Object Oriented Design - Quiz1', 3);

--This will have a collection of questions of various types
create table QuizCollection(
    quizCollectionId int NOT NULL AUTO_INCREMENT, 
	quizCollectionName varchar(400),
	courseSectionId int NOT NULL,
	isDefault int,
	PRIMARY KEY (quizCollectionId),
	FOREIGN KEY(courseSectionId)
    REFERENCES CourseSections(courseSectionId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
)
--Blank names will be automatically shown as "Quiz 1" in the front-end
--insert into QuizCollection(quizCollectionName,courseSectionId,isDefault) values('',3,1);
--insert into QuizCollection(quizCollectionName,courseSectionId) values('',3);
--insert into QuizCollection(quizCollectionName,courseSectionId) values('',3);

create table QuestionType(
	questionTypeId int NOT NULL,
	questionTypeName varchar(100), -- Can be Single choice, Multiple Choice, Code Output
	PRIMARY KEY (questionTypeId)
)
--insert into QuestionType(questionTypeId,questionTypeName) values(1,'Single Choice');
--insert into QuestionType(questionTypeId,questionTypeName) values(2,'Multiple Choice');
--insert into QuestionType(questionTypeId,questionTypeName) values(3,'Code Output');
--insert into QuestionType(questionTypeId,questionTypeName) values(4,'Fill The Blanks');

create table Questions(
	questionId int NOT NULL AUTO_INCREMENT,
	extQuestionId varchar(100) UNIQUE,
	questionTypeId int NOT NULL,
	quizCollectionId int NOT NULL,
	choice1 varchar(200),
	choice2 varchar(200),
	choice3 varchar(200),
	choice4 varchar(200),
	isChoice1Correct int,
	isChoice2Correct int,
	isChoice3Correct int,
	isChoice4Correct int,
	answerString varchar(200),
	FOREIGN KEY(questionTypeId)
    REFERENCES QuestionType(questionTypeId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
	FOREIGN KEY(quizCollectionId)
    REFERENCES QuizCollection(quizCollectionId)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    PRIMARY KEY (questionId)
)
--insert into Questions(extQuestionId,questionTypeId, quizCollectionId,choice1,choice2,choice3,choice4,isChoice1Correct,isChoice2Correct,isChoice3Correct,isChoice4Correct,answerString) values('',1,1,'hello','world','happy','holidays',1,0,0,0,NULL);


