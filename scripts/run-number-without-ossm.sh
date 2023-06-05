#!/bin/sh

#source setURL.sh
export FRONTEND_URL="http://$(oc get route/ossm-frontend -o jsonpath={.spec.host}  -n demo-ossm-frontend)/req"

COUNT=0
MAX=$1
URL=$FRONTEND_URL

while [ $COUNT -lt $MAX ];
do
    curl $URL -s -w " | Time Total: %{time_total} seconds.\n" 
    COUNT=$(expr $COUNT + 1)
done
