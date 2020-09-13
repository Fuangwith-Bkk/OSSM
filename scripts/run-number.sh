#!/bin/sh

COUNT=0
MAX=$1
URL=ossm-backend-ztest.apps.cluster-94f9.94f9.example.opentlc.com/req

while [ $COUNT -lt $MAX ];
do
    curl $URL -s -w " | Time Total: %{time_total} seconds.\n" 
    COUNT=$(expr $COUNT + 1)
done