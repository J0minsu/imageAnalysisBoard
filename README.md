# Lunit_Test

##  Program Structure
![structure](https://github.com/J0minsu/Lunit_Test/blob/master/images/structure.png?raw=true)

### Technology set
|TechNical Name|Value|
|:---:|:---:|
|Language|Java 11|
|Framework|Spring boot 2.4.4|
|DBMS|MySQL 8.0.16|
|Persistance Framework|JPA|
|Test|Postman, JUnit5|

IDE : InteliJ

### Using Dependencies

 - 'org.springframework.boot:spring-boot-starter-data-jpa'
 - 'org.springframework.boot:spring-boot-starter-web'
 - 'org.springframework.boot:spring-boot-starter-security'
 - 'org.springframework.session:spring-session-core'
 - 'mysql:mysql-connector-java'
 - 'org.projectlombok:lombok'
 - 'org.springframework.boot:spring-boot-starter-test'
 - 'org.apache.tomcat.embed:tomcat-embed-jasper'
 - 'javax.servlet:jstl:1.2'

## test flow

### if you want to confirm other account's result is same, you can change login account 'msjo' to 'jslee' -> localhost:8080/test/otherLogin
    WARNING, localhost:8080/test -> set login account to 'msjo'

 1. localhost:8080/api/slides ( when you haven't permission, you can't find yout slides )
 2. localhost:8080/test ( 'msjo' account save in session )
 3. localhost:8080/api/slides ( you can confirm 'msjo' s slides
 4. <<click 'SLIDE UPLOAD TEST' -> check img you want to uplad -> Submit , then, Success or Fail
 5. localhost:8080/test
 6. <<click 'DOWNLOADABLE ALL SLIDE TEST' ( you can find your files )
 7. <<click any link about slide! then, you can download that slide
 8. <<if you want to search file name, localhost:8080/api/slides/ + [search word] >>>> remember one thing's id
 9. localhost:8080/api/histories/analysis/ + [have been rememvered id] ( you can see analysis result you request )
 10. localhost:8080/api/histories ( you can find your histories )
 11. localhost:8080/api/histories/ + [one history's id you want to see ]
 
 
