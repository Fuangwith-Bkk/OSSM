#!/bin/sh

oc apply -f manifests/ossm-frontend-configmap-v2.yaml -n demo-ossm-frontend
oc apply -f manifests/ossm-frontend-deployment-v2.yaml -n demo-ossm-frontend