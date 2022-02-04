# Retrospective

**Discuss a part of your project that has not been as successful as you would have liked**

The original plan was to display accurate and live sports data on the UI without hard coding the latest information into our database manually but we could not integrate API into our application. Most of our features, for example currently playing feature, team roster feature, player statistics feature, schedule feature, news feed feature, and standings feature require live updates.

The currently playing feature shows the user the teams that are currently playing and their current scores. Right now, our application is not showing live data, all information for currently playing teams is hardcoded into the database. If API integration was successful, the scores of the currently playing teams would be live such that if a team scores in the 10th minute of the 3rd period, the user would be notified instantly.

The information of each player in our player statistics feature is static because their information is hardcoded into the database. Let’s consider score data, there is a high probability that it changes as a player plays, this change is currently not showing automatically in our player statistics feature. If API integration was successful, a change in player score data will be updated in our player statistics feature as well.

The Newsfeed feature displays some hardcoded news in the database. In this feature, the user is able to like and add a comment. The comments posted by a user are local to our application, it’s not on the internet. If API integration was successful, our newsfeed would be live on the internet and a google search related to hockey games may display results that include our application.

Ultimately, successful API integration would have given the user a true App experience instead of a simulated experience.

**How it can be improved in this iteration?**

We need more time to do in-depth research on how API integration works and how to successfully integrate it into our application. We will not be using API in this iteration as we need to implement and complete the required project deliverables for the iteration 3 release. We plan to update our database with accurate sports data as often as possible, so users see the latest and accurate sports information. We as a team remain dedicated to making the API integration works to ensure a true App experience for users.

**Determine concrete (and realistic) ways of improvement and decide how its success will be evaluated at the end of the iteration (measurable and objective)**

Our continuous improvement strategy includes working on our API integration and watching out for any technical debt that might come with high interest in the future if we decide to add more features or functionality to our application.
This strategy is considered a success based on these criteria:
- a new team member who is currently not in our team can read and understand our codebase, implement a feature with little or no technical debt interest to pay for implementing a new feature.
- There is a 50% percent increase in the number of users in the first year of our successful API integration.

If any one of the criteria shows a significant improvement, without a statistically significant reduction in the other criteria mentioned in our vision statement, the application improvement strategy will be considered a success

**Include a change (as an image) showing the 2 data points of project velocity from the last two iterations**

![project_velocity_retro](https://i.imgur.com/s89TIdb.png)
