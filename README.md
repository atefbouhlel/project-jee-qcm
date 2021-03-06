# project-jee-qcm
### Default Profiles
* Etudiant (username: student1, mdp: student)
* Enseignant (username: prof, mdp: prof)
* Admin (username: admin, mdp: admin)

### Steps
#### Step 1. Set up the Development Environment for Angular

You need to set up your development environment before you can do anything.

Install Node.js® and npm if they are not already on your machine.

Verify that you are running at least node 6.9.x and npm 3.x.x by running node -v and npm -v in a terminal/console window. Older versions produce errors, but newer versions are fine.

Then install the Angular CLI globally.
* npm install -g @angular/cli

#### Step 2: Serve the angular application

Go to the project directory and launch the server.

* cd front/
* npm install
* ng serve

#### Step 3: Run the Back application

* Open the back/ project on Eclipse
* Modify the database parameters according to your database in the "application.properties" file
* Run the application as a Java Application
