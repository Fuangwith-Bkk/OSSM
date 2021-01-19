#!/bin/sh

oc apply -f manifests/ossm-member-roll.yaml -n demo-ossm-control-plane

oc patch deployment.apps/ossm-frontend-v1 -p '{"spec":{"template":{"metadata":{"annotations":{"sidecar.istio.io/inject":"true"}}}}}' -n demo-ossm-frontend

oc patch deployment.apps/ossm-backend-v1 -p '{"spec":{"template":{"metadata":{"annotations":{"sidecar.istio.io/inject":"true"}}}}}' -n demo-ossm-backend
oc patch deployment.apps/ossm-backend-v2 -p '{"spec":{"template":{"metadata":{"annotations":{"sidecar.istio.io/inject":"true"}}}}}' -n demo-ossm-backend