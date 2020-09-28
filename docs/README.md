# Duke User Guide ٩(^ᴗ^)۶ 

### Duke, named after the Java mascot, is a Personal Assistant Chatbot that helps a person to keep track of various things. 

<br>

* Quick Start
* Features 
  - Adding a new task:&nbsp; [deadline](#adding-a-new-task-deadline)&nbsp; [event](#adding-a-new-task-event) &nbsp; [todo](#adding-a-new-task-todo)
  - Checking/updating of tasks in list:&nbsp; [delete](#deleting-a-task-delete)&nbsp; [done](#marking-task-as-done-done)&nbsp; [find](#locating-a-task-using-a-keyword-find)&nbsp; [list](#viewing-all-task-list)&nbsp; [save](#saving-the-data-save)
  - Exiting the program: &nbsp;[exit](#exiting-the-program-exit)

* Command summary 

<br>

## Quick Start
### Locating the project
1) Fork [ip project](https://github.com/nus-cs2113-AY2021S1/ip).
2) Enable the issue tracker of your fork (Go to Settings of your fork, scroll to the Features section, and tick the Issues checkbox). Reason: at times we post feedback on your issue tracker.
If the issue tracker is enabled, you should be able to visit the following URL `https://github.com/{your_user_name}/ip/issues` e.g., https://github.com/johnDoe/ip/issues
3) Clone the fork onto your computer.

### Downloading Java 11 (if Java is not the latest version)
1) Download Java 11 from [Amazon Corretto](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) according to your OS
2) Save the downloaded file in a convenient, easy to find location

### Setting up project in Intellij
1) Open Intellij (if you are not in the welcome screen, click File > Close Project to close the existing project dialog first)
2) Set up the correct JDK version, as follows: Click Configure > Structure for New Projects and then Project Settings > Project > Project SDK
   - If JDK 11 is listed in the drop down, select it. If it is not, click New... and select the directory where you installed JDK 11
3) Click OK
4) Import the project into Intellij as follows:
   - Click Open or Import.	
   - Select the project directory, and click OK
   - If there are any further prompts, accept the defaults.
   - After the importing is complete, locate the src/main/java/Duke.java file, right-click it, and choose Run Duke.main(). If the setup is correct, you should see something like the below:
   
   ```
   Hello! I'm Duke,
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
           
   What can I do for you? :)
   ```
   
<br>

## Features
> Take note: Inputs that look like \**THIS\** are parameters to be supplied by user.

> Word of advice: try not to add tasks without specifying whether it is deaadline/event/todo, if not the following error message will be shown:
```
OOPS!!! I'm sorry, but I don't know what that means (/ﾟДﾟ)/
```

### Adding a new task: `deadline`

Adds a deadline task to overall list

Format: `deadline **TASK DESCRIPTION** /by **DEADLINE DUE DATE**`
* All fields must be filled

Example: `deadline finish ip /by Sunday` (Where finish ip is the task and Sunday is the deadline due date)

Output:
```
Got it. I've added this task:
[D][✘] finish ip (by: Sunday)
Now you have 1 tasks in the list.
```

Note:
* `[D]` - Deadline Task 
* `[X]` - Deadline is **not** done

### Adding a new task: `event`

Adds an event task to overall list

Format: `event **TASK DESCRIPTION** /at **DATE OF EVENT**`
* All fields must be filled

Example: `event project meeting /at Monday` (Where project meeting is the task and Monday is the event day)

Output:
```
Got it. I've added this task:
[E][✘] project meeting (at: Monday)
Now you have 2 tasks in the list.
```

Note:
* `[E]` - Event task
* `[X]` - Event is **not** done

### Adding a new task: `todo`

Adds a todo task to overall list

Format: `todo **TASK DESCRIPTION**`
* All fields should be filled. If not, the following error message will be shown:
   ```
   OOPS!!! The description of a todo cannot be empty ☹
   ```

Example: `todo prepare for meeting` (Where prepare for meeting is the task)

Output:
```
Got it. I've added this task:
[T][✘] prepare for meeting
Now you have 3 tasks in the list.
```

Note:
* `[T]` - Todo task
* `[X]` - Todo is **not** done

### Deleting a task: `delete`

Following the order on the overall list, specified deadlines/events/todo will be deleted

Format: `delete **INDEX OF TASK ON LIST**`
* Index has to be an integer
* Only one deadlines/events/todo can be deleted at one time
[X] will be changed to [✔]

Example: `delete 2`

Output:
```
Noted. I've removed this task:
[E][✓] project meeting (at: Monday)
Now you have 2 tasks in the list.
```

### Marking task as done: `done`

Following the order on the overall list, specified deadlines/events/todo will be marked as done

Format: `done **INDEX OF TASK ON LIST**`
* Index has to be a integer
* Only one deadlines/events/todo can be marked as done at one time
[✘] will be changed to [✔]

Example: `done 2`

Output:
```
Nice! I've marked this task as done:
[E][✓] project meeting (at: Monday)
```

### Locating a task using a keyword: `find`

Finds all deadlines/events/todo description recorded in list with specified keyword 

Format: `find **KEYWORD**`

Example: `find meeting`

Output:
```
1. [E][✘] project meeting (at: Monday)
2. [T][✘] prepare for meeting
```

### Viewing all task: `list`

Shows a list of all deadlines/events/todo recorded

Format: `list`

Output:
```
1. [D][✘] finish ip (by: Sunday)
2. [E][✘] project meeting (at: Monday)
3. [T][✘] prepare for meeting
```

### Saving the data: `save`

List data will be saved automatically in the hard disk whenever the task list changes, there is no need to input a command

### Exiting the program: `exit`

Terminates the Duke program

Format: `bye`

Output:
```
Bye. Hope to see you again soon!
```

<br>

## Command summary

|    Action       |      Format     |   Examples | 
|:---:|:---:|:---:|
|       deadline   |    `deadline **TASK DESCRIPTION** /by **DEADLINE DUE DATE**`                 |   `deadline finish ip /by Sunday` |
|       event        |         `event **TASK DESCRIPTION** /at **DATE OF EVENT**`          |  `event project meeting /at Monday` |
|todo|        `todo **TASK DESCRIPTION**`       |   `todo prepare for meeting` | 
|          list             |            `list`            |    | 
|           find         |  `find **KEYWORD**`                    |    `find meeting`  |
|           done                |       `done **INDEX OF TASK ON LIST**`          |   `done 2`  |
|             exit             |                 `bye`          |    | 
