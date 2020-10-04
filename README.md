# WasteLess

WasteLess is an application that helps users manage food waste. Before using the application, each user needs to create an account and set up an ideal burdown rate (the rate at which he would like to burn calories). The system helps users keep food waste in check in a few key ways: 
- if the total calories exceed the burndown rate times the number of days until the product expires, the user is notified.
- if a product is about to expire, the user is notified.

In any of the situations listed above the user can choose to danate the food. Moreover, to help users adhere to a healthier lifestyle, the system provides monthly and weekly waste reports.

From an implementation perspective, the application was implemented using Spring Boot (RESTful API), Spring Security (for HTTP basic authentication based on a token) and Angular (client-server architecture). The data is accessed and persisted using Spring Data (ORM) in MongoDB. Notifications were implemented using a websocket (real-time notification). 

To keep the code as clean as possible and decouple controlers from the service layer, I used a mediator coupled with the CQRS (Command and Query Responsibility Segregation) pattern. Moreover, for the report generation and notification side the following design patterns were used:
- Abstract Factory
- Observer
- Mediator
- Builder


