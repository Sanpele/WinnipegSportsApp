# Iteration 2 Worksheet

## Paying Off Technical Debt

**Objects are Nested in Iteration 1**

One instance of our group paying off technical debt comes from the initial construction of our domain specific objects. Many of them contained nested objects that were hard to translate to SQL tables and required refactoring. 

- [Commit: 8958e8bf](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/commit/8958e8bf75dd42ca0203ddff9acd08d8653c4c83#4d61493eea5042964e918b7b6d15824a3725e1e8_14_11)
- [Commit: c35a80d4](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/commit/c35a80d4da08075f9dfcc749497ffe8bc9a253c5#4d61493eea5042964e918b7b6d15824a3725e1e8_54_5)

We consider this debt to be inadvertent and prudent mostly because while we would do things differently, the core of the object design has remained. Our domain specific objects were initially designed before we started coding in Android Studio. While we have paid off technical debt by refactoring our objects, we could not have known beforehand what exactly we needed. 


**Fake DB Refactoring**

Another instance of our group paying off technical debt was the structure of our fake DB. We initially wrote the DB in a single straight Java file. Furthermore, initially we converted it into something quickly usable in Android Studio using some hacky getters still in one class file. In Iteration 2, in order to match our 4 unique HSQLDB tables, we had to split up our DB into 4 files and add private lists to allow for insertion/update/deletion in the future. 

- [Commit: c633eec8](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/commit/c633eec8b306a1fa961129aa8bb917c3593b547a)
- [Commit: 5417f7e4](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/commit/5417f7e449a2b843b4c7e997d5f3ff79fa19f8da)

Paying off this technical debt was required during a very busy week, and could have been avoided with further iteration on the fake DB and sooner refactoring. Instead not only did we have to change it anyway, we had to spend valuable time that could have gone towards more code documentation and refactoring. 


## SOLID

[SOLID violation of A01 Group 6 (Productive App) issue.](https://code.cs.umanitoba.ca/3350-winter-2021-a01/Productive-6/-/issues/79)


## Retrospective

In Iteration 1 Retrospective, we  identified we needed to communicate progress on assigned tasks with other team members consistently, and manage our time more effectively in order to complete all deliverables. These retrospectives made us utilize the concept of agility on our project appropriately. 

As a team, we are constantly communicating where we are in terms of implementation and we do this [by asking other team mates to review our code during a merge request](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/merge_requests?scope=all&utf8=✓&state=all). This helped us ensure that [what is submitted in Develop](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/graphs/Develop) is good quality code, and in turn also allow team members to have the opportunity to become comfortable with the tools in GitLab -- something we also have brought up during our Retrospective.


## Design Patterns

A design pattern we used is [Singleton](https://refactoring.guru/design-patterns/singleton), and this is [an example of usage](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/blob/Develop/app/src/main/java/comp3350/winSport/application/Services.java).

We used the Singleton design pattern to manage our database ensuring we only allow one database object per table. We implement the Singleton pattern by defining static/synchronized methods to hand out our DB interfaces, and by never creating Service objects. Static methods ensure 1 per class, and by not creating Service objects but accessing the methods from the class itself only 1 implementation of our persistence interfaces will ever be initialized.  


## Iteration 1 Feedback Fixes

Issue: [Interface Object](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/issues/33)

This issue was flagged because of our usage of interfaces in the line: `private ITeam ITeam`. The code ran and worked however is improperly using interfaces and wouldn't have worked this iteration with two classes implementing our interfaces. The code was improperly initializing our interface as an object, not initializing the class that implemented our interface. 

Our fix to this problem initially was [to declare our interface variable as class that implements the interface](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/commit/d00d13664697c4dabd1b5422d23c97c7f5f02c45). However, with the addition of our other DB classes, [we created a class to manage the initialization of our interfaces](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/commit/27887551cb857f9821b9b5360f7bd7570d33afd4) using the Singleton pattern. Which we then extended further [to include all our new DB classes](https://code.cs.umanitoba.ca/3350-winter-2021-a03/winnipeg-sports-app-a03-group-6/-/blob/Develop/app/src/main/java/comp3350/winSport/application/Services.java).

