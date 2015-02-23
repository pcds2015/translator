# Translator example for PCDS 2015

This is a Mickey Mouse example of a Translator application used in the
DIKU course PCDS 2015 to demonstrate

* Test-Driven Development
* Build management using Ant and Ivy
* Continuous integration using Jenkins and Docker

## Build management

If you have Ant and Ivy installed you may run `ant test` to
initialize, build, and test the application.

Alternatively, you may try this in the Docker Jenkins slave (using
`docker run -ti kmhansen/pcds2015-jenkins-slave /bin/bash` followed by
`cd /home/jenkins/slave`, 
`git clone https://github.com/pcds2015/translator`, and 
`ant test`; see below)

## Running a Jenkins master with Docker

You may run an appropriate Jenkins master (with the swarm and Git
plugins installed) by issuing 

  `docker run --name jenkins -p 8080:8080 -p 50000:50000 -v
/var/jenkins_home kmhansen/pcds2015-jenkins`

This will create a persistent volume for the container and allow you
to restart the container using 

  `docker restart jenkins`

You will next need to configure a job in Jenkins using a web
browser and accessing the url `http://container url:8080`. 

On Linux, you may find the URL of the container by issuing `docker
inspect --format '{{ .NetworkSettings.IPAddress }}' jenkins` . On
Mac/Windows you need to use the IP address of the boot2docker VM; you
can find the appropriate URL using `boot2docker ip`.

## Running Jenkins slaves with Docker

To run appropriate slaves (and connect them to a running master using
the Jenkins swarm protocol), issue:

`docker run --link jenkins:jenkins kmhansen/pcds2015-jenkins-slave`