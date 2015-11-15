#!/bin/sh

#for i in $(seq 1 3)
#do
#    curl --silent http://tomee:8080 > /dev/null
#    RES=$?
#    if [ "$RES" = "0"  ]
#    then
#        echo "Tomee Found"
#    else
#        echo waiting 10 s
#        sleep 10
#    fi
#done

cd /usr/bin/app/
gradle build
