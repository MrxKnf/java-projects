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
TaskTracker add Do the housework

# Update a task
TaskTracker update 1 Do the housework and cook dinner

# Delete a task
TaskTracker delete 1

# Mark a task as in progress | done | todo
TaskTracker mark-in-progress 1
TaskTracker mark-done 1
TaskTracker mark-todo 1

# List all | todo | in progress | done tasks
TaskTracker list //List all tasks
TaskTracker list todo
TaskTracker list in-progress
TaskTracker list done
```

