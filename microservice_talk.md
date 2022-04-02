### Microservice talk
https://jakubn.gitlab.io/devinmicroserviceworld

certyfikaty: bullshit

"zwykły developer od ficzerów" nie potrzebuje mieć certyfikatu z kubernetesa

### learn
learn managing requirements:

learn:
- behavioral specifications (use cases)
- model processes with sequence/bloc diagrams

books:
- biology of humans ???
- living the nonviolent communication

# design
- how to design architecture
- what is a module (microservice can be modular)
- how microservices/modules communicate (Query/Command/Event)
- how to make REST comm reliable (Outbox pattern)
- how to use your Event Bus correctly (read odels, partitioning, order & delivery guarantees)
- how to handle lack of strong consistency

Designing Event-Driven Systems (Stopford)

Software Architecture for Developers (Brown) - mandatory read

# implementation

Now we are responsible for code on production. We need to learn observability.

### learn:
- each code branch needs a log, especially if you decide not to do anything
Not doing anything is a very important decision!

- learn higher order functions to apply logs without introducing huge meess

- proper business monitoring (Micrometer in Spring Boot: decide what to measure)

- proper infra monitoring (watch your thread pools)

- understand your thread model (5 devs in a team)

- we need metrics to see how *often* something happens

First thing to implement: Tailored Service Template

# deployment

basic kubernetes knowledge needed: node, pod, service, kubectl

pipelines: share them across company

use continous deployment: auto deploy on each merge to master

small, frequent deploymets

remember:
- big monoliths == big deployment risk
- small microservices == small deployment risk

### learn

- RESPONSIBILITY. push to master == deployment
- understand and change your pipeline when needed
- how to rollback to previous version

# operations

### learn:

- how to setup your dashboards
- how to define alarms
- how to make a thread dump and memory dump
- how to debug and see logs (telepresence is a great tool)

Finally, decide how you want to observe and analyze your production.

# testing

### learn:

- in microservices world, there is no such thing as an up-to-date test environment
- learn Behavioral Driven Development
- use Consumer Driven Contracrs
- test your app on production


# security

Now you are responsible for security.

### learn:

- DevSecOps - threat modeling and security experts helping from time to time
- do not be afraid to ask for /buy help, DO NOT IGNORE the problem
- "security is a function of probability"
- scan docker images for vulnerabilities
- subscribe to your framework's newsletter (security updates)
- encrypt data in flight, encrypt data in storage
- use Vaults to keep secrets

### random

motorola w krakowie ma zabronione cosmosDB
