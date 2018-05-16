In this project, we will write a specific JobScheduler class that uses a variant of a simple linked list to schedule arriving jobs according to a particular scheduling policy.



Here is an example:

```
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Job Scheduler version 1.0
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Initial Job Waiting List Status
*******************************
Job List is empty: true
The size is: 0 job(s).

Job Waiting List Status at 1.25s
*************************************
0 obsolete job(s) removed from the list.
Event: Job #1 added to the list.
Job List is empty: false
The size is: 1 job(s).
job #1 : ALERT MESSAGE (UID 1) 1

Job Waiting List Status at 2.35s
*************************************
0 obsolete job(s) removed from the list.
Event: Job #2 added to the list.
Job List is empty: false
The size is: 2 job(s).
job #1 : ALERT MESSAGE (UID 1) 1
job #2 : PRINT document (UID 5) 0

Job Waiting List Status at 2.58s
*************************************
0 obsolete job(s) removed from the list.
Event: Job #3 added to the list.
Job List is empty: false
The size is: 3 job(s).
job #1 : ALERT MESSAGE (UID 1) 1
job #3 : EMERGENCY MESSAGE (UID 8) 1
job #2 : PRINT document (UID 5) 0

Job Waiting List Status at 3.49s
*************************************
1 obsolete job(s) removed from the list.
Event: Job #4 added to the list.
Job List is empty: false
The size is: 3 job(s).
job #3 : EMERGENCY MESSAGE (UID 8) 1
job #2 : PRINT document (UID 5) 0
job #4 : PRINT Lecture Notes (UID 6) 0

Job Waiting List Status at 4.67s
*************************************
2 obsolete job(s) removed from the list.
Event: Job #5 added to the list.
Job List is empty: false
The size is: 2 job(s).
job #5 : SECURITY ALERT (UID 15) 1
job #2 : PRINT document (UID 5) 0

Duplicate List Status
*********************
Job List is empty: false
The size is: 2 job(s).
job #5 : SECURITY ALERT (UID 15) 1
job #2 : PRINT document (UID 5) 0

Clear Original List
*******************
Job List is empty: true
The size is: 0 job(s).

 -------- END Scheduling Simulation --------
```

