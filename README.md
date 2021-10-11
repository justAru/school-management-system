# school-management-system
Java EE practical tasks  
Project name: School management system  

Brief description: The project concerns the management of all data and records of the institution related to students, teachers and other staff. The project can be expanded to a more advanced level by integrating other functions such as attendance management, the project interface is mainly for 3 types of users - administrators, teachers, students, so that everyone can log in with a valid username / password, can view their data and perform appropriate operations.  

Microservices:  
    Nurdaulet Alim:   
    Notification-service - Service that available to make a notice by several type, according to the project(mobile-app, mail, dl)  
    Administration-service - CRM  
  Yerulan Turganbek:  
    Test-service - Service that provides a subject tests, examination, kahoot*  
    DB Structs - Service that responsible for db structure of our project  
  Aruzhan Demeubayeva  
    Report - service - Service responsible for issuing transcripts and other student documents  
    Schedule - service - Service for displaying the schedule of students  

![WhatsApp Image 2021-10-11 at 23 22 08](https://user-images.githubusercontent.com/57905281/136831142-9a1eb7ee-18e5-4b76-afa7-b284ff843392.jpeg)

Adding eureka(discovery) server to all services
![photo_2021-10-04 17 24 20](https://user-images.githubusercontent.com/57905281/135843342-aa96c91c-a2ce-4bd8-b1ad-cbcd3c404505.jpeg)
