# hibernate
Hibernate probes / Gradle / Spring Boot

## HowTo init
- Image page -- https://hub.docker.com/_/mysql/ -- 5.6
- Start a container -- docker run --name mysql56 -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 -it mysql:5.6
- Jump into shell in container -- docker exec -it <container ID> bash
- Jump into mysql console -- mysql -u root -p --> then enter `root`
- Show all existing DBs -- show databases;
- Create a new DB -- CREATE DATABASE hibernate;
- Create user and grant admin access to new DB -- CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';
- Grant all privileges to hibernate DB -- GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';
- Show all users -- SELECT User FROM mysql.user;
- Now I can jump into mysql console with user 
- Create new table -- CREATE TABLE hibernate.message (id INT AUTO_INCREMENT PRIMARY KEY, message VARCHAR(100));
- Jump into a context of particular DB -- use hibernate;
- Clear console -- Edit -> Clear Screen
- Insert new record to DB -- INSERT INTO messages () VALUES('Hello world!');
- Drop all messages from DB -- truncate table message;
- Cool tool to access DB -- SQLetron -- https://github.com/sqlectron -- https://sqlectron.github.io/
- Drop a particular table -- DROP TABLE message;