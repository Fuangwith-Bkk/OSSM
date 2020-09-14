#!/bin/sh

oc apply -f manifests/ossm-backend-native-v1.yaml -n demo-ossm-backend
oc apply -f manifests/ossm-backend-native-v2.yaml -n demo-ossm-backend
oc apply -f manifests/ossm-backend-service.yaml -n demo-ossm-backend

oc apply -f manifests/ossm-frontend-configmap.yaml -n demo-ossm-frontend
oc apply -f manifests/ossm-frontend-deployment-v1.yaml -n demo-ossm-frontend
oc apply -f manifests/ossm-frontend-service.yaml -n demo-ossm-frontend
oc apply -f manifests/ossm-frontend-route.yaml -n demo-ossm-frontend