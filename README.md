## Task-Tracker CLI

___

Solution for the [task-tracker-cli](https://roadmap.sh/projects/task-tracker) project from [roadmap.sh](https://roadmap.sh)

### How to run the program
___

Through the following command, clone the repository:

```
git clone https://github.com/MrxKnf/java-projects/task-tracker.git
```

Enter source code directory and run the following commands:

```
cd task-tracker/src
javac Task-tracker.java
```

### How to use the program
___

```
# Add a task
Task-tracker add Do the housework

# Update a task
Task-tracker update 1 Do the housework and cook dinner

# Delete a task
Task-tracker delete 1

# Mark a task as in progress | done | todo
Task-tracker mark-in-progress 1
Task-tracker mark-done 1
Task-tracker mark-todo 1

# List all | todo | in progress | done tasks
Task-tracker list //List all tasks
Task-tracker list todo
Task-tracker list in-progress
Task-tracker list done
```

