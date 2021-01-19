#!/bin/sh


oc apply -f manifests/ossm-backend-native-v3.yaml -n demo-ossm-backend
oc apply -f manifests/ossm-backend-service-v3.yaml -n demo-ossm-backend