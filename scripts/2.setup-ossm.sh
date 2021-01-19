#!/bin/sh

oc new-project demo-ossm-control-plane  --display-name='Control Plane'
oc apply -f manifests/ossm-control-plane-v2.yaml -n demo-ossm-control-plane





