#!/bin/bash
# $Id: runfoundry.sh 4 2009-05-21 19:24:08Z spal $
# $Source$
java -cp /home/sujit/.m2/repository/osl/foundry/actorfoundry/1.0/actorfoundry-1.0.jar:target/classes osl.foundry.FoundryStart com.mycompany.myapp.concurrent.actorfoundry.ActorManager boot 1000000 -open
