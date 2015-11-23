#!/bin/sh

for i in $(seq 1 3)
do
    curl --silent http://tomee:8080 > /dev/null
    RES=$?
    if [ "$RES" = "0"  ]
    then
        echo "TomEE is up and running, launching tests"
        break
    else
        echo "TomEE is down, waiting for 10 sesonds"
        sleep 10
    fi
done

#cd /usr/bin/app/
gradle $@
