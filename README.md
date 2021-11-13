Original App Design Project - README
===

# Truth or Dare 

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Play if you dare or truth, I guess.

### App Evaluation

- **Category:** Social Gaming
- **Mobile:** This app would be primarily developed for mobile. While in the future, it could be just as viable on a computer, we believe this app would work best as a mobile app. 
- **Story:** ALlows users to play the game "truth or dare" with other users online. 
- **Market:** All ages.
- **Habit:** Users can use the app during leisure time.
- **Scope:** First this app will just start off as a simple "truth or dare" app. In the future we could add certain monetization options so "players" could be incentivized to do certain "truths" or "dares".

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [ ] Sign-up/Login page
- [ ] Registration page 
- [ ] Home screen where the user can see the videos of truths and dares
- [ ] Logout Screen
- [ ] Profile page for each user
- [ ] Clips should be labeled truth or dare 
- [ ] Settings page

**Optional Nice-to-have Stories**

- [ ] A comment section where people can comment on each post
- [ ] A follow system where users can follow other users

### 2. Screen Archetypes

* Login 
   * User can login in via username and password
* Registration/Sign up page
   * User can create an account
   * User can sign up as a "watcher" or "player"
* Homescreen
* Upload page 
    * Players see a screen with two buttons (Truth/Dare) 
    * They pick one and see a corresponding task to do and post themselves doing the said task

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Feed
    * Displays the main feed
* Upload content
    * Allows useres to play the game or upload truths and dares
* Profile/Settings
    * Displays the user profile
    * Allows users to update various profile/account settings

**Flow Navigation** (Screen to Screen)

* Feed
   *  Displays the main feed
* Upload Content
   * Allows users to play the game or upload truths and dares
* Profile/Settings
    * Displays the user profile
    * Allows users to update various profile/account settings

## Wireframes
<img src="https://i.imgur.com/WtNToHz.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src='https://i.imgur.com/Wqb8let.png' width=600>

### [BONUS] Interactive Prototype

## Schema 

### Models
#### Post


| Property      | Type     | Description                                 |
|:------------- | -------- |:------------------------------------------- |
| userId        | String   | unique id for the user post (default field) |
| video         | File     | video that the user posts                   |
| challengeDesc | String   | description of truth/dare in each post      |
| likesCount    | Number   | number of likes for each post               |
| createdAt     | DateTime | date when post is created (default field)   |
| dollarAmount  | Number   | the reward amount that the watcher enters   |
| isComplete             | Boolean         | is triggered when the user has finished the truth/dare                                            |
| postType      | String   | type of post (truth/dare)                   |


### Networking
- [Add list of network requests by screen ]
- List of network requests by screen
* Home Feed Screen
    * (Read/Get) Query all posts where isCompleted is true
    ```
    let query = PFQuery(className:"Post")
    query.whereKey("author", equalTo: currentUser)
    query.order(byDescending: "createdAt")
    query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
       if let error = error { 
          print(error.localizedDescription)
       } else if let posts = posts {
          print("Successfully retrieved \(posts.count) posts.")
      // TODO: Do something with posts...
       }
    }
    ```
* Create Request Screen
    * (Create/Post) Create new postType
    * (Create/Post)
    * (Create/Post)
    * (Create/Post)
* Create Post Screen
    * (Create/POST) Create a new post object
* Profile Screen
    * (Read/GET) Query logged in user object


- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]


