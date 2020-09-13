#!/bin/sh

oc new-project demo-ossm-control-plane  --display-name='Control Plane'
oc apply -f manifests/ossm-control-plane.yaml -n demo-ossm-control-plane

oc new-project demo-ossm-frontend --display-name='Front end'
oc new-project demo-ossm-backend --display-name='Back end'

oc apply -f manifests/ossm-member-roll.yaml -n demo-ossm-control-plane

