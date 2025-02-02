## Task-Tracker CLI

___

Solution for the [task-tracker-cli](https://roadmap.sh/projects/task-tracker) project from [roadmap.sh](https://roadmap.sh)

### How to run the program
___

Through the following command, clone the repository:

```
git clone https://github.com/MrxKnf/java-projects.git
```

Enter source code directory and run the following commands:

```
cd java-projects/task-tracker/src
javac TaskTracker.java
```

### How to use the program
___

```
# Add a task
java TaskTracker add "Do the housework"

# Update a task
java TaskTracker update 1 "Do the housework and cook dinner"

# Delete a task
java TaskTracker delete 1

# Mark a task as in progress | done | todo
java TaskTracker mark-in-progress 1
java TaskTracker mark-done 1
java TaskTracker mark-todo 1

# List all | todo | in progress | done tasks
java TaskTracker list //List all tasks
java TaskTracker list todo
java TaskTracker list in-progress
java TaskTracker list done
```

