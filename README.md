# Springboot_JPA_crud_mysql

Step-1:- Create a database in mysql with name: student_crud

Step-2:- Configure application.properties files and make change as

          spring.datasource.username=yourusername
          
          spring.datasource.password=yourpassword

Step-3:- Run the SpringBootJpaApplication.java file

Step-4:- Open Postman and go to workspace

Step-5:- To insert student details:-

          select request as POST

          Enter url:- localhost:8080/studentDetails/saveStudent
          
          click on body select raw and enter the following in the body:
          
          {
          "stdName":"any_name",
          "stdClass":"any_class",
          "schoolName":"any_school"
           }
           
           Now click on Send button.

Step-6:- To retrieve student details:-
          
          select request as GET
          
          Enter url:- localhost:8080/studentDetails/studentList
          
          Click on Send Button

Step-7:- To update student details:-
          
          select request as PUT
          
          Enter url:- localhost:8080/studentDetails/updateStudent/1
          
          click on body select raw and enter the following in the body:
          
          {
          "stdName":"change_name",
          "stdClass":"change_class",
          "schoolName":"change_school"
           }
          
          Now click on Send Button

Step-8:- To delete a Student by sno:-
          
          select request as DELETE
          
          Enter url:- localhost:8080/studentDetails/deleteStudent/1
          
          Click on Send Button
